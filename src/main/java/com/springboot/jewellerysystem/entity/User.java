package com.springboot.jewellerysystem.entity;

import java.util.Date;
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

@Entity
@Table(name = "user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Integer id;

	@Basic
	@Column(name = "first_name", nullable = false, length = 50)
	private String firstName;

	@Basic
	@Column(name = "last_name", nullable = false, length = 50)
	private String lastName;

	@Basic
	@Column(name = "password", nullable = false, length = 20)
	private String password;

	@Basic
	@Column(name = "phone", nullable = false, length = 20)
	private String phone;

	@Basic
	@Column(name = "email", nullable = false, length = 50)
	private String email;

	@Basic
	@Column(name = "role", nullable = false, length = 10)
	private String role;

	@Basic
	@Column(name = "status", nullable = false)
	private Integer status;

	@Basic
	@Column(name = "entry_date", nullable = false)
	private Date entryDate;

	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	private Set<Cart> cart = new HashSet<>();

	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	private Set<Order> order = new HashSet<>();

	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	private Set<Wishlist> wishlist = new HashSet<>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getEntryDate() {
		return entryDate;
	}

	public void setEntryDate(Date entryDate) {
		this.entryDate = entryDate;
	}

	public Set<Cart> getCarts() {
		return cart;
	}

	public void setCarts(Set<Cart> cart) {
		this.cart = cart;
	}

	public Set<Order> getOrders() {
		return order;
	}

	public void setOrders(Set<Order> order) {
		this.order = order;
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
		User other = (User) obj;
		return Objects.equals(id, other.id) && Objects.equals(firstName, other.firstName)
				&& Objects.equals(lastName, other.lastName) && Objects.equals(password, other.password)
				&& Objects.equals(phone, other.phone) && Objects.equals(email, other.email)
				&& Objects.equals(role, other.role) && Objects.equals(status, other.status)
				&& Objects.equals(entryDate, other.entryDate);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, firstName, lastName, password, phone, email, role, status, entryDate);
	}

	public User() {
		super();
	}

	public User(String firstName, String lastName, String password, String phone, String email, String role,
			Integer status, Date entryDate) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.phone = phone;
		this.email = email;
		this.role = role;
		this.status = status;
		this.entryDate = entryDate;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", password=" + password
				+ ", phone=" + phone + ", email=" + email + ", role=" + role + ", status=" + status + ", entryDate="
				+ entryDate + "]";
	}
}
