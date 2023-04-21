package com.springboot.jewellerysystem.entity;

import java.util.Date;
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
@Table(name = "blog")
public class Blog {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Integer id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "blog_category_id", referencedColumnName = "id", nullable = false)
	private BlogCategory blogCategory;

	@Basic
	@Column(name = "title", nullable = false, length = 50)
	private String title;

	@Basic
	@Column(name = "short_description", nullable = false, length = 255)
	private String shortDescription;

	@Basic
	@Column(name = "description", nullable = false, length = 65535)
	private String description;

	@Basic
	@Column(name = "image", nullable = false, length = 255)
	private String image;

	@Basic
	@Column(name = "entry_date", nullable = false)
	private Date entryDate;

	@Basic
	@Column(name = "status", nullable = false)
	private Integer status;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Date getEntryDate() {
		return entryDate;
	}

	public void setEntryDate(Date entryDate) {
		this.entryDate = entryDate;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public BlogCategory getBlogCategory() {
		return blogCategory;
	}

	public void setBlogCategory(BlogCategory blogCategory) {
		this.blogCategory = blogCategory;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		Blog other = (Blog) obj;
		return Objects.equals(id, other.id) && Objects.equals(title, other.title)
				&& Objects.equals(shortDescription, other.shortDescription)
				&& Objects.equals(description, other.description) && Objects.equals(image, other.image)
				&& Objects.equals(entryDate, other.entryDate) && Objects.equals(status, other.status);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, title, shortDescription, description, image, entryDate, status);
	}

	public Blog() {
		super();
	}

	public Blog(String title, String shortDescription, String description, String image, Date entryDate,
			Integer status) {
		super();
		this.title = title;
		this.shortDescription = shortDescription;
		this.description = description;
		this.image = image;
		this.entryDate = entryDate;
		this.status = status;
	}

	@Override
	public String toString() {
		return "Blog [id=" + id + ", title=" + title + ", shortDescription=" + shortDescription + ", description="
				+ description + ", image=" + image + ", entryDate=" + entryDate + ", status=" + status + "]";
	}
	@Transient
	public String getImagePath() {
		if (image == null )
			return null;

		return "/assets1/images/blog/" + image;
	}
}
