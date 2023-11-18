package vn.devpro.BTCK.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table (name ="tbl_sale_order_product")
public class SaleOrderProduct extends BaseModel {
	
	@Column(name="description", length = 300, nullable =  true)
	private String description;
	@Column(name="quantity",  nullable =  true)
	private Integer quantity;
	
	
	public SaleOrderProduct() {
		super();
	}
	
	@ManyToOne(fetch = FetchType.EAGER)
	 @JoinColumn (name="product_id")
	 private Product product;
		
	
	@ManyToOne(fetch = FetchType.EAGER)
	 @JoinColumn (name="sale_order_id")
	 private SaleOrder saleOrder;
		


	public Product getProduct() {
		return product;
	}


	public void setProduct(Product product) {
		this.product = product;
	}


	public SaleOrder getSaleOrder() {
		return saleOrder;
	}


	public void setSaleOrder(SaleOrder saleOrder) {
		this.saleOrder = saleOrder;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public Integer getQuantity() {
		return quantity;
	}


	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	
	

}
