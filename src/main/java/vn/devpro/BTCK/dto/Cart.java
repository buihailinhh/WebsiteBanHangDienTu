package vn.devpro.BTCK.dto;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Cart {
	
	// Danh sach san pham trong gio
	List<CartProduct> cartProducts = new ArrayList<CartProduct>();
	
	// tinh tong so san pham trong gio hang
	public BigInteger totalCartProducts() {
		BigInteger total = BigInteger.ZERO;
		for(CartProduct cartProduct : cartProducts) {
			total = total.add(cartProduct.getQuantity());
			
		}
		return total;
		
	}
	
	// tổng số tiền của giỏ hàng
	public BigDecimal totalCartPrice() {
		BigDecimal total = BigDecimal.ZERO;
		for(CartProduct cartProduct: cartProducts) {
			
			total = total.add(cartProduct.totalPrice());
		}
		return total;
	}
	

	public Cart() {
		super();
	}

	public Cart(List<CartProduct> cartProducts) {
		super();
		this.cartProducts = cartProducts;
	}

	public List<CartProduct> getCartProducts() {
		return cartProducts;
	}

	public void setCartProducts(List<CartProduct> cartProducts) {
		this.cartProducts = cartProducts;
	}
	
	


}
