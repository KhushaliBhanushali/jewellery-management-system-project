package com.springboot.jewellerysystem.entity;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "contact_us")
public class ContactUs {

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
	@Column(name = "phone", nullable = false, length = 50)
	private String phone;

	@Basic
	@Column(name = "email", nullable = false, length = 50)
	private String email;

	@Basic
	@Column(name = "message", nullable = false, length = 255)
	private String message;

	@Basic	
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	@CreationTimestamp
	@Column(name = "enquiry_date", nullable = false)
	public Date enquiryDate;

	@PrePersist
	private void onCreate() {
		enquiryDate = new Date();
	}
	
	@Basic
	@Column(name = "is_read", nullable = false, length = 1)
	private String isRead;

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

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getEnquiryDate() {
		return enquiryDate;
	}

	public void setEnquiryDate(Date enquiryDate) {
		this.enquiryDate = enquiryDate;
	}

	public String getIsRead() {
		return isRead;
	}

	public void setIsRead(String isRead) {
		this.isRead = isRead;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		ContactUs other = (ContactUs) obj;
		return Objects.equals(id, other.id) && Objects.equals(firstName, other.firstName)
				&& Objects.equals(lastName, other.lastName) && Objects.equals(phone, other.phone)
				&& Objects.equals(email, other.email) && Objects.equals(message, other.message)
				&& Objects.equals(enquiryDate, other.enquiryDate) && Objects.equals(isRead, other.isRead);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, firstName, lastName, phone, email, message, enquiryDate, isRead);
	}

	public ContactUs() {
		super();
	}

	public ContactUs(String firstName, String lastName, String phone, String email, String message, Date enquiryDate,
			String isRead) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.email = email;
		this.message = message;
		this.enquiryDate = enquiryDate;
		this.isRead = isRead;
	}

	@Override
	public String toString() {
		return "ContactUs [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", phone=" + phone
				+ ", email=" + email + ", message=" + message + ", enquiryDate=" + enquiryDate + ", isRead=" + isRead
				+ "]";
	}
}
