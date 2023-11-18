package vn.devpro.BTCK.controller.user;

import java.io.IOException;
import java.math.BigInteger;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import vn.devpro.BTCK.dto.Cart;
import vn.devpro.BTCK.model.Product;
import vn.devpro.BTCK.service.ProductService;







@Controller
public class HomeController   {
	
	@Autowired
	private ProductService productService;
	
	
	//Controller handle action name home
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(final Model model,
			final HttpServletRequest request,
			final HttpServletResponse response
			) throws IOException {
		List<Product> products = productService.findAll();
		model.addAttribute("products", products);
		BigInteger totalCartProducts = BigInteger.ZERO;
		
		HttpSession session = request.getSession();
		if(session.getAttribute("cart") != null ) {
			Cart cart = (Cart) session.getAttribute("cart");
			totalCartProducts = cart.totalCartProducts();
			
		}
		model.addAttribute("totalCartProducts", totalCartProducts);
	
		return "user/home";
	}
	
}
