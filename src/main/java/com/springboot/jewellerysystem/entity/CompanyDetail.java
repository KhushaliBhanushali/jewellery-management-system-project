package com.springboot.jewellerysystem.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Table(name = "company_detail")
public class CompanyDetail {

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
	@Column(name = "helpline_no", nullable = false, length = 20)
	private String helplineNo;

	@Basic
	@Column(name = "address", nullable = false, length = 255)
	private String address;

	@Basic
	@Column(name = "phone", nullable = false, length = 20)
	private String phone;

	@Basic
	@Column(name = "email", nullable = false, length = 50)
	private String email;

	@Basic
	@Column(name = "copy_right", nullable = false, length = 50)
	private String copyRight;

	@Basic
	@Column(name = "home_page", nullable = false, length = 20)
	private String homePage;

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

	public String getHelplineNo() {
		return helplineNo;
	}

	public void setHelplineNo(String helplineNo) {
		this.helplineNo = helplineNo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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

	public String getCopyRight() {
		return copyRight;
	}

	public void setCopyRight(String copyRight) {
		this.copyRight = copyRight;
	}

	public String getHomePage() {
		return homePage;
	}

	public void setHomePage(String homePage) {
		this.homePage = homePage;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		CompanyDetail other = (CompanyDetail) obj;
		return Objects.equals(id, other.id) && Objects.equals(name, other.name) && Objects.equals(logo, other.logo)
				&& Objects.equals(helplineNo, other.helplineNo) && Objects.equals(address, other.address)
				&& Objects.equals(phone, other.phone) && Objects.equals(email, other.email)
				&& Objects.equals(copyRight, other.copyRight) && Objects.equals(homePage, other.homePage);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, logo, helplineNo, address, phone, email, copyRight, homePage);
	}

	public CompanyDetail() {
		super();
	}

	public CompanyDetail(String name, String logo, String helplineNo, String address, String phone, String email,
			String copyRight, String homePage) {
		super();
		this.name = name;
		this.logo = logo;
		this.helplineNo = helplineNo;
		this.address = address;
		this.phone = phone;
		this.email = email;
		this.copyRight = copyRight;
		this.homePage = homePage;
	}

	@Override
	public String toString() {
		return "CompanyDetail [id=" + id + ", name=" + name + ", logo=" + logo + ", helplineNo=" + helplineNo
				+ ", address=" + address + ", phone=" + phone + ", email=" + email + ", copyRight=" + copyRight
				+ ", homePage=" + homePage + "]";
	}
	
	@Transient
	public String getImagePath() {
		if (logo == null )
			return null;

		return "/assets1/images/companyDetail/" + logo;
	}
}
