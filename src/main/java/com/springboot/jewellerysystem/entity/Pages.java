package com.springboot.jewellerysystem.entity;

import java.util.Objects;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "pages")
public class Pages {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Integer id;

	@Basic
	@Column(name = "page_type", nullable = false, length = 50)
	private String pageType;

	@Basic
	@Column(name = "page_title", nullable = false, length = 50)
	private String pageTitle;

	@Basic
	@Column(name = "page_description", nullable = false, length = 65535)
	private String pageDescription;

	@Basic
	@Column(name = "page_banner", nullable = false, length = 255)
	private String pageBanner;

	@Basic
	@Column(name = "status", nullable = false)
	private Integer status;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPageType() {
		return pageType;
	}

	public void setPageType(String pageType) {
		this.pageType = pageType;
	}

	public String getPageTitle() {
		return pageTitle;
	}

	public void setPageTitle(String pageTitle) {
		this.pageTitle = pageTitle;
	}

	public String getPageDescription() {
		return pageDescription;
	}

	public void setPageDescription(String pageDescription) {
		this.pageDescription = pageDescription;
	}

	public String getPageBanner() {
		return pageBanner;
	}

	public void setPageBanner(String pageBanner) {
		this.pageBanner = pageBanner;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		Pages other = (Pages) obj;
		return Objects.equals(id, other.id) && Objects.equals(pageType, other.pageType)
				&& Objects.equals(pageTitle, other.pageTitle) && Objects.equals(pageDescription, other.pageDescription)
				&& Objects.equals(pageBanner, other.pageBanner) && Objects.equals(status, other.status);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, pageType, pageTitle, pageDescription, pageBanner, status);
	}

	public Pages() {
		super();
	}

	public Pages(String pageType, String pageTitle, String pageDescription, String pageBanner, Integer status) {
		super();
		this.pageType = pageType;
		this.pageTitle = pageTitle;
		this.pageDescription = pageDescription;
		this.pageBanner = pageBanner;
		this.status = status;
	}

	@Override
	public String toString() {
		return "Pages [id=" + id + ", pageType=" + pageType + ", pageTitle=" + pageTitle + ", pageDescription="
				+ pageDescription + ", pageBanner=" + pageBanner + ", status=" + status + "]";
	}

	@Transient
	public String getImagePath() {
		if (pageBanner == null)
			return null;

		return "/assets1/images/pages/" + pageBanner;
	}

}
