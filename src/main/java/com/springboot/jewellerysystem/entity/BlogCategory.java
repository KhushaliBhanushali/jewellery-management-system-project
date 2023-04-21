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

@Entity
@Table(name = "blog_category")
public class BlogCategory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Integer id;

	@Basic
	@Column(name = "name", nullable = false, length = 50)
	private String name;

	@Basic
	@Column(name = "status", nullable = false)
	private Integer status;

	@OneToMany(mappedBy = "blogCategory", fetch = FetchType.LAZY)
	private Set<Blog> blog = new HashSet<>();

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

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Set<Blog> getBlogs() {
		return blog;
	}

	public void setBlogs(Set<Blog> blog) {
		this.blog = blog;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		BlogCategory other = (BlogCategory) obj;
		return Objects.equals(id, other.id) && Objects.equals(name, other.name) && Objects.equals(status, other.status);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, status);
	}

	public BlogCategory() {
		super();
	}

	public BlogCategory(String name, Integer status) {
		super();
		this.name = name;
		this.status = status;
	}

	@Override
	public String toString() {
		return "BlogCategory [id=" + id + ", name=" + name + ", status=" + status + "]";
	}
}
