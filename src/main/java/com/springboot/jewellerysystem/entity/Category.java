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
@Table(name = "category")
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Integer id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "main_category_id", referencedColumnName = "id", nullable = false)
	private MainCategory mainCategory;

	@Basic
	@Column(name = "name", nullable = false, length = 50)
	private String name;

	@Basic
	@Column(name = "image", nullable = false, length = 255)
	private String image;

	@Basic
	@Column(name = "status", nullable = false)
	private Integer status;

	@OneToMany(mappedBy = "category", fetch = FetchType.LAZY)
	private Set<Product> product = new HashSet<>();

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

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public MainCategory getMainCategory() {
		return mainCategory;
	}

	public void setMainCategory(MainCategory mainCategory) {
		this.mainCategory = mainCategory;
	}

	public Set<Product> getProducts() {
		return product;
	}

	public void setProducts(Set<Product> product) {
		this.product = product;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		Category other = (Category) obj;
		return Objects.equals(id, other.id) && Objects.equals(name, other.name) && Objects.equals(image, other.image)
				&& Objects.equals(status, other.status);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, image, status);
	}

	public Category() {
		super();
	}

	public Category(String name, String image, Integer status) {
		super();
		this.name = name;
		this.image = image;
		this.status = status;
	}

	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", image=" + image + ", status=" + status + "]";
	}
	@Transient
	public String getImagePath() {
		if (image == null )
			return null;

		return "/assets1/images/category/" + image;
	}
}
