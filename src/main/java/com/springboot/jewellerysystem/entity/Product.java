package com.springboot.jewellerysystem.entity;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "product")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Integer id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "brand_id", referencedColumnName = "id", nullable = false)
	private Brand brand;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "category_id", referencedColumnName = "id", nullable = false)
	private Category category;

	@Basic
	@Column(name = "name", nullable = false, length = 50)
	private String name;

	@Basic
	@Column(name = "image", nullable = false, length = 255)
	private String image;

	@Basic
	@Column(name = "mrp", nullable = false)
	private Float mrp;

	@Basic
	@Column(name = "sales_price", nullable = false)
	private Float salesPrice;

	@Basic
	@Column(name = "grose_weight", nullable = false)
	private Float groseWeight;

	@Basic
	@Column(name = "net_weight", nullable = false)
	private Float netWeight;

	@Basic
	@Column(name = "is_fixed_labour", nullable = false, length = 1)
	private String isFixedLabour;

	@Basic
	@Column(name = "labour", nullable = false)
	private Float labour;

	@Basic
	@Column(name = "other_charges", nullable = false)
	private Float otherCharges;

	@Basic
	@Column(name = "product_description", nullable = false, length = 255)
	private String productDescription;

	@Basic
	@Column(name = "status", nullable = false)
	private Integer status;

	@OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
	private Set<Cart> cart = new HashSet<>();

	@OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
	private Set<OrderDetail> orderDetail = new HashSet<>();

	@OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
	private Set<ProductDetail> productDetail = new HashSet<>();

	@OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
	private Set<ProductImage> productImage = new HashSet<>();

	@OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
	private Set<Review> review = new HashSet<>();

	@OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
	private Set<Wishlist> wishlist = new HashSet<>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Float getMrp() {
		return mrp;
	}

	public void setMrp(Float mrp) {
		this.mrp = mrp;
	}

	public Float getSalesPrice() {
		return salesPrice;
	}

	public void setSalesPrice(Float salesPrice) {
		this.salesPrice = salesPrice;
	}

	public Float getGroseWeight() {
		return groseWeight;
	}

	public void setGroseWeight(Float groseWeight) {
		this.groseWeight = groseWeight;
	}

	public Float getNetWeight() {
		return netWeight;
	}

	public void setNetWeight(Float netWeight) {
		this.netWeight = netWeight;
	}

	public String getIsFixedLabour() {
		return isFixedLabour;
	}

	public void setIsFixedLabour(String isFixedLabour) {
		this.isFixedLabour = isFixedLabour;
	}

	public Float getLabour() {
		return labour;
	}

	public void setLabour(Float labour) {
		this.labour = labour;
	}

	public Float getOtherCharges() {
		return otherCharges;
	}

	public void setOtherCharges(Float otherCharges) {
		this.otherCharges = otherCharges;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	public Set<Cart> getCarts() {
		return cart;
	}

	public void setCarts(Set<Cart> cart) {
		this.cart = cart;
	}

	public Set<OrderDetail> getOrderDetails() {
		return orderDetail;
	}

	public void setOrderDetails(Set<OrderDetail> orderDetail) {
		this.orderDetail = orderDetail;
	}

	public Set<ProductDetail> getProductDetails() {
		return productDetail;
	}

	public void setProductDetails(Set<ProductDetail> productDetail) {
		this.productDetail = productDetail;
	}

	public Set<ProductImage> getProductImages() {
		return productImage;
	}

	public void setProductImages(Set<ProductImage> productImage) {
		this.productImage = productImage;
	}

	public Set<Review> getReviews() {
		return review;
	}

	public void setReviews(Set<Review> review) {
		this.review = review;
	}

	public Set<Wishlist> getWishlists() {
		return wishlist;
	}

	public void setWishlists(Set<Wishlist> wishlist) {
		this.wishlist = wishlist;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		return Objects.equals(id, other.id) && Objects.equals(name, other.name) && Objects.equals(image, other.image)
				&& Objects.equals(mrp, other.mrp) && Objects.equals(salesPrice, other.salesPrice)
				&& Objects.equals(groseWeight, other.groseWeight) && Objects.equals(netWeight, other.netWeight)
				&& Objects.equals(isFixedLabour, other.isFixedLabour) && Objects.equals(labour, other.labour)
				&& Objects.equals(otherCharges, other.otherCharges)
				&& Objects.equals(productDescription, other.productDescription) && Objects.equals(status, other.status);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, image, mrp, salesPrice, groseWeight, netWeight, isFixedLabour, labour,
				otherCharges, productDescription, status);
	}

	public Product() {
		super();
	}

	public Product(String name, String image, Float mrp, Float salesPrice, Float groseWeight, Float netWeight,
			String isFixedLabour, Float labour, Float otherCharges, String productDescription, Integer status) {
		super();
		this.name = name;
		this.image = image;
		this.mrp = mrp;
		this.salesPrice = salesPrice;
		this.groseWeight = groseWeight;
		this.netWeight = netWeight;
		this.isFixedLabour = isFixedLabour;
		this.labour = labour;
		this.otherCharges = otherCharges;
		this.productDescription = productDescription;
		this.status = status;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", image=" + image + ", mrp=" + mrp + ", salesPrice="
				+ salesPrice + ", groseWeight=" + groseWeight + ", netWeight=" + netWeight + ", isFixedLabour="
				+ isFixedLabour + ", labour=" + labour + ", otherCharges=" + otherCharges + ", productDescription="
				+ productDescription + ", status=" + status + "]";
	}
	
	@Transient
	public String getImagePath() {
		if (image == null )
			return null;

		return "/assets1/images/products/" + image;
	}
}
