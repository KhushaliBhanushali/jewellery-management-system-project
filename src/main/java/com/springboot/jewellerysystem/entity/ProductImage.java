package com.springboot.jewellerysystem.entity;

import java.util.Objects;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "product_image")
public class ProductImage {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Integer id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "product_id", referencedColumnName = "id", nullable = false)
	private Product product;

	@Basic
	@Column(name = "image", nullable = false, length = 255)
	private String image;

	@Basic
	@Column(name = "status", nullable = false)
	private Integer status;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		ProductImage other = (ProductImage) obj;
		return Objects.equals(id, other.id) && Objects.equals(image, other.image)
				&& Objects.equals(status, other.status);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, image, status);
	}

	public ProductImage() {
		super();
	}

	public ProductImage(String image, Integer status) {
		super();
		this.image = image;
		this.status = status;
	}

	@Override
	public String toString() {
		return "ProductImage [id=" + id + ", image=" + image + ", status=" + status + "]";
	}

@Transient
	public String getImagePath() {
		if (image == null )
			return null;

		return "/assets1/images/products/" + image;
	}
}
