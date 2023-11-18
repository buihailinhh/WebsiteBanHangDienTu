package vn.devpro.BTCK.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_product")
public class Product extends BaseModel {
	
	@Column(name = "name", length = 500, nullable = false)
	private String name;
	
	@Column(name = "price", nullable = true)
	private BigDecimal price;
	
	@Column(name = "sale_price", nullable = true)
	private BigDecimal salePrice;
	
	@Column(name = "short_description", length = 3000, nullable = true)
	private String shortDescription;
	
	@Column(name = "detail_description", nullable = true)
	private String detailDescription;
	
	@Column(name = "avatar", length = 200, nullable = true)
	private String avatar;// path của avatar
	
	@Column(name = "is_hot", nullable = true)
	private Boolean isHot = Boolean.FALSE;
	
	//Mapping many-to-one: product-to-category
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "category_id")
	private Category category;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "product")
	private Set<ProductImage> productImages = new HashSet<ProductImage>();
	
	//thêm file  path của ảnh vào tbl_product_image khi thyêm product
	
	public void addRelationalProductImage( ProductImage productImage) {
		productImages.add(productImage);
		productImage.setProduct(this);
	}
	
	//xóa file path của tbl_product_image khi xóa product
	public   void deleteRelationalProductImage(ProductImage productImage) {
		productImages.remove(productImage);
		productImage.setProduct(null);
		
	}

	public Product() {
		super();
	}

	public Product(Integer id, Integer createBy, Integer updateBy, Date createDate, Date updateDate, Boolean status,
			String name, BigDecimal price, BigDecimal salePrice, String shortDescription, String detailDescription,
			String avatar, Boolean isHot, Category category) {
		super(id, createBy, updateBy, createDate, updateDate, status);
		this.name = name;
		this.price = price;
		this.salePrice = salePrice;
		this.shortDescription = shortDescription;
		this.detailDescription = detailDescription;
		this.avatar = avatar;
		this.isHot = isHot;
		this.category = category;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public BigDecimal getSalePrice() {
		return salePrice;
	}

	public void setSalePrice(BigDecimal salePrice) {
		this.salePrice = salePrice;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public String getDetailDescription() {
		return detailDescription;
	}

	public void setDetailDescription(String detailDescription) {
		this.detailDescription = detailDescription;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public Boolean getIsHot() {
		return isHot;
	}

	public void setIsHot(Boolean isHot) {
		this.isHot = isHot;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
	
	
}
