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
@Table(name = "our_service")
public class OurService {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Integer id;

	@Basic
	@Column(name = "name", nullable = false, length = 50)
	private String name;

	@Basic
	@Column(name = "description", nullable = false, length = 255)
	private String description;

	@Basic
	@Column(name = "image", nullable = false, length = 255)
	private String image;

	@Basic
	@Column(name = "status", nullable = false)
	private Integer status;

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
		OurService other = (OurService) obj;
		return Objects.equals(id, other.id) && Objects.equals(name, other.name)
				&& Objects.equals(description, other.description) && Objects.equals(image, other.image)
				&& Objects.equals(status, other.status);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, description, image, status);
	}

	public OurService() {
		super();
	}

	public OurService(String name, String description, String image, Integer status) {
		super();
		this.name = name;
		this.description = description;
		this.image = image;
		this.status = status;
	}

	@Override
	public String toString() {
		return "OurService [id=" + id + ", name=" + name + ", description=" + description + ", image=" + image
				+ ", status=" + status + "]";
	}
	
	@Transient
	public String getImagePath() {
		if (image == null )
			return null;

		return "/assets1/images/our_services/" + image;
	}
}
