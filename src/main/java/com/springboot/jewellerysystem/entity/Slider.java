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
@Table(name = "slider")
public class Slider {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Integer id;

	@Basic
	@Column(name = "image", nullable = false, length = 255)
	private String image;

	@Basic
	@Column(name = "text1", nullable = false, length = 100)
	private String text1;

	@Basic
	@Column(name = "text2", nullable = false, length = 100)
	private String text2;

	@Basic
	@Column(name = "text3", nullable = false, length = 100)
	private String text3;

	@Basic
	@Column(name = "text4", nullable = false, length = 100)
	private String text4;

	@Basic
	@Column(name = "btn_text", nullable = false, length = 20)
	private String btnText;

	@Basic
	@Column(name = "btn_link", nullable = false, length = 255)
	private String btnLink;

	@Basic
	@Column(name = "status", nullable = false)
	private Integer status;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getText1() {
		return text1;
	}

	public void setText1(String text1) {
		this.text1 = text1;
	}

	public String getText2() {
		return text2;
	}

	public void setText2(String text2) {
		this.text2 = text2;
	}

	public String getText3() {
		return text3;
	}

	public void setText3(String text3) {
		this.text3 = text3;
	}

	public String getText4() {
		return text4;
	}

	public void setText4(String text4) {
		this.text4 = text4;
	}

	public String getBtnText() {
		return btnText;
	}

	public void setBtnText(String btnText) {
		this.btnText = btnText;
	}

	public String getBtnLink() {
		return btnLink;
	}

	public void setBtnLink(String btnLink) {
		this.btnLink = btnLink;
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
		Slider other = (Slider) obj;
		return Objects.equals(id, other.id) && Objects.equals(image, other.image) && Objects.equals(text1, other.text1)
				&& Objects.equals(text2, other.text2) && Objects.equals(text3, other.text3)
				&& Objects.equals(text4, other.text4) && Objects.equals(btnText, other.btnText)
				&& Objects.equals(btnLink, other.btnLink) && Objects.equals(status, other.status);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, image, text1, text2, text3, text4, btnText, btnLink, status);
	}

	public Slider() {
		super();
	}

	public Slider(String image, String text1, String text2, String text3, String text4, String btnText, String btnLink,
			Integer status) {
		super();
		this.image = image;
		this.text1 = text1;
		this.text2 = text2;
		this.text3 = text3;
		this.text4 = text4;
		this.btnText = btnText;
		this.btnLink = btnLink;
		this.status = status;
	}

	@Override
	public String toString() {
		return "Slider [id=" + id + ", image=" + image + ", text1=" + text1 + ", text2=" + text2 + ", text3=" + text3
				+ ", text4=" + text4 + ", btnText=" + btnText + ", btnLink=" + btnLink + ", status=" + status + "]";
	}

	@Transient
	public String getImagePath() {
		if (image == null)
			return null;

		return "/assets1/images/slider/" + image;
	}

}
