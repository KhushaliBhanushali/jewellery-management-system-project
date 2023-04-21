package com.springboot.jewellerysystem.entity;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "feedback")
public class Feedback {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Integer id;

	@Basic
	@Column(name = "category", nullable = false, length = 255)
	private String category;

	@Basic
	@Column(name = "date", nullable = false)
	private Date date;

	@Basic
	@Column(name = "email", nullable = false, length = 255)
	private String email;

	@Basic
	@Column(name = "message", nullable = false, length = 255)
	private String message;

	@Basic
	@Column(name = "name", nullable = false, length = 255)
	private String name;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		Feedback other = (Feedback) obj;
		return Objects.equals(id, other.id) && Objects.equals(category, other.category)
				&& Objects.equals(date, other.date) && Objects.equals(email, other.email)
				&& Objects.equals(message, other.message) && Objects.equals(name, other.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, category, date, email, message, name);
	}

	public Feedback() {
		super();
	}

	public Feedback(String category, Date date, String email, String message, String name) {
		super();
		this.category = category;
		this.date = date;
		this.email = email;
		this.message = message;
		this.name = name;
	}

	@Override
	public String toString() {
		return "Feedback [id=" + id + ", category=" + category + ", date=" + date + ", email=" + email + ", message="
				+ message + ", name=" + name + "]";
	}
}
