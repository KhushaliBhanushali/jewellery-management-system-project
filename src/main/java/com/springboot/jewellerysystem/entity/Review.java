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

@Entity
@Table(name = "review")
public class Review {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Integer id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "product_id", referencedColumnName = "id", nullable = false)
	private Product product;

	@Basic
	@Column(name = "rating", nullable = false)
	private Integer rating;

	@Basic
	@Column(name = "title", nullable = false, length = 100)
	private String title;

	@Basic
	@Column(name = "review", nullable = false, length = 255)
	private String review;

	@Basic
	@Column(name = "name", nullable = false, length = 50)
	private String name;

	@Basic
	@Column(name = "email", nullable = false, length = 50)
	private String email;

	@Basic
	@Column(name = "status", nullable = false)
	private Integer status;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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
		Review other = (Review) obj;
		return Objects.equals(id, other.id) && Objects.equals(rating, other.rating)
				&& Objects.equals(title, other.title) && Objects.equals(review, other.review)
				&& Objects.equals(name, other.name) && Objects.equals(email, other.email)
				&& Objects.equals(status, other.status);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, rating, title, review, name, email, status);
	}

	public Review() {
		super();
	}

	public Review(Integer rating, String title, String review, String name, String email, Integer status) {
		super();
		this.rating = rating;
		this.title = title;
		this.review = review;
		this.name = name;
		this.email = email;
		this.status = status;
	}

	@Override
	public String toString() {
		return "Review [id=" + id + ", rating=" + rating + ", title=" + title + ", review=" + review + ", name=" + name
				+ ", email=" + email + ", status=" + status + "]";
	}
}
