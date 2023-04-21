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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "brand")
public class Brand {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Integer id;

	@Basic
	@Column(name = "name", nullable = false, length = 50)
	private String name;

	@Basic
	@Column(name = "logo", nullable = false, length = 255)
	private String logo;

	@Basic
	@Column(name = "status", nullable = false)
	private Integer status;

	@OneToMany(mappedBy = "brand", fetch = FetchType.LAZY)
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

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
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
		Brand other = (Brand) obj;
		return Objects.equals(id, other.id) && Objects.equals(name, other.name) && Objects.equals(logo, other.logo)
				&& Objects.equals(status, other.status);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, logo, status);
	}

	public Brand() {
		super();
	}

	public Brand(String name, String logo, Integer status) {
		super();
		this.name = name;
		this.logo = logo;
		this.status = status;
	}

	@Override
	public String toString() {
		return "Brand [id=" + id + ", name=" + name + ", logo=" + logo + ", status=" + status + "]";
	}
	
	@Transient
	public String getImagePath() {
		if (logo == null )
			return null;

		return "/assets1/images/brand/" + logo;
	}
}
