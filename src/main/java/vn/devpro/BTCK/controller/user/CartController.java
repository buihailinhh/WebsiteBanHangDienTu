package vn.devpro.BTCK.controller.user;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import vn.devpro.BTCK.dto.Cart;
import vn.devpro.BTCK.dto.CartProduct;
import vn.devpro.BTCK.model.Product;
import vn.devpro.BTCK.model.SaleOrder;
import vn.devpro.BTCK.model.SaleOrderProduct;
import vn.devpro.BTCK.service.ProductService;
import vn.devpro.BTCK.service.SaleOrderService;



@Controller
public class CartController {
	
	@Autowired
	private ProductService productService;
	@Autowired
	private SaleOrderService saleOrderService;
	
	@RequestMapping(value ="/add-to-cart", method = RequestMethod.POST)
	public ResponseEntity<Map<String,Object>> addToCart(final Model model, final HttpServletRequest request,
			final HttpServletResponse response,
			@RequestBody CartProduct addProduct)throws IOException{
		
		// lay gio hang
		HttpSession session = request.getSession(); 
		Cart cart = null;
		// kiem tra xem da lay gio hang chua
		if(session.getAttribute("cart") != null) {// da co gio
			// lay gio hang
			cart = (Cart) session.getAttribute("cart");
			
		}else {// chua co gio hang, khach clck lan dau
			cart = new Cart();
			session.setAttribute("cart", cart);
			
		}
		// lAy hang va dua vao gio hang: 2 truong hop
		//+ lay product trong db
		
		Product dbProduct = productService.getById(addProduct.getProductId());
		
		
	boolean isExistProduct = false;// kiem tra hang chon da co trong gio chua
	 
	for(CartProduct cartProduct: cart.getCartProducts()) {
		if(cartProduct.getProductId()== addProduct.getProductId()) {// hang  da co trong gio
			isExistProduct= true;
			// Tang so luong
			cartProduct.setQuantity(cartProduct.getQuantity().add(addProduct.getQuantity()));
			break;
		}
	}
	if(!isExistProduct) { // hang chua co trong gio
		// them moi
		  	addProduct.setName(dbProduct.getName());
		  	addProduct.setPrice(dbProduct.getPrice());
		  	addProduct.setAvatar(dbProduct.getAvatar());
		  	cart.getCartProducts().add(addProduct);
		
	}
	// thiet lap lai
	session.setAttribute("cart", cart);
	// tra ve tong san pham trong gio hang
	Map<String, Object> jsonResult = new HashMap<String, Object>();
	
	jsonResult.put("code",200);
	jsonResult.put("status", "Success");
	jsonResult.put("totalCartProducts", cart.totalCartProducts());
	return ResponseEntity.ok(jsonResult);
	
	}
	
	// hien thi gio hang
	
	@RequestMapping(value = "/cart-view", method = RequestMethod.GET)
	public String home(final Model model,
			final HttpServletRequest request,
			final HttpServletResponse response
			) throws IOException {
		
		
		HttpSession session = request.getSession();
		BigDecimal totalCartPrice = BigDecimal.ZERO;
		BigInteger totalCartProducts = BigInteger.ZERO;
		Cart cart = null;
		 String errorMessage = null;
		 String message = null;
		
		if(session.getAttribute("cart") != null ) {
			 cart = (Cart) session.getAttribute("cart");
			totalCartPrice = cart.totalCartPrice();
			 totalCartProducts = cart.totalCartProducts();
		     message = " Có tổng :" + cart.totalCartProducts() +"mặt hàng trong giỏ hàng";
			
		}else {// chua co san pham
			errorMessage ="Không có sản phẩm nào trong giỏ hàng của bạn";
		}
		model.addAttribute("totalCartProducts",totalCartProducts);
		model.addAttribute("totalCartPrice",totalCartPrice);
		model.addAttribute("errorMessage",errorMessage);
		model.addAttribute("message",message);
		
	
		return "user/cart-view";
	}
	
	@RequestMapping(value = "/place-order", method = RequestMethod.POST)
	public String placeOrder(final Model model,
			final HttpServletRequest request,
			final HttpServletResponse response
			) throws IOException {
		
		// Lay gio hang de luu danh sach vao tbl_sale_oder_product
		
		
		HttpSession session = request.getSession();
		Cart cart = (Cart) session.getAttribute("cart");
		if(cart != null && cart.totalCartProducts().intValue()> 0) {// cos gio va co hang trong gio
			
			
			// tạo đơn hàng
		SaleOrder saleOrder = new SaleOrder();
		saleOrder.setCustomerName(request.getParameter("txtName"));
		saleOrder.setCustomerMobile(request.getParameter("txtMobile"));
		saleOrder.setCustomerAddress(request.getParameter("txtAddress"));
		saleOrder.setCustomerEmail(request.getParameter("txtEmail"));
		saleOrder.setTotal(cart.totalCartPrice());
		saleOrder.setCode(Long.toString(System.currentTimeMillis()));
		saleOrder.setCreateDate(new Date());
		// Duyet danh sach 
		
		for(CartProduct cartProduct : cart.getCartProducts()) {
			SaleOrderProduct saleOrderProduct = new SaleOrderProduct();
			saleOrderProduct.setQuantity(cartProduct.getQuantity().intValue());
			Product product = productService.getById(cartProduct.getProductId());// Lay product
			saleOrderProduct.setProduct(product);
		saleOrder.addRelationalSaleOrderProduct(saleOrderProduct); // luu vao bang
		}
		
		//lưu đơn hàng vào tbl_sale_order
		
		saleOrderService.saveOrder(saleOrder);
		}
		else {
			// tra ve thong bao  khach chua chon hang vao gio
			
		}
		
	
		return "redirect:/home";
	}

}
