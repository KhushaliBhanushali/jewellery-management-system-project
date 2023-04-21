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
import javax.persistence.Transient;

@Entity
@Table(name = "banner_image")
public class BannerImage {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Integer id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "banner_id", referencedColumnName = "id", nullable = false)
	private Banner banner;

	@Basic
	@Column(name = "banner_image", nullable = false, length = 255)
	private String bannerImage;

	@Basic
	@Column(name = "banner_link", nullable = false, length = 255)
	private String bannerLink;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBannerImage() {
		return bannerImage;
	}

	public void setBannerImage(String bannerImage) {
		this.bannerImage = bannerImage;
	}

	public String getBannerLink() {
		return bannerLink;
	}

	public void setBannerLink(String bannerLink) {
		this.bannerLink = bannerLink;
	}

	public Banner getBanner() {
		return banner;
	}

	public void setBanner(Banner banner) {
		this.banner = banner;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		BannerImage other = (BannerImage) obj;
		return Objects.equals(id, other.id) && Objects.equals(bannerImage, other.bannerImage)
				&& Objects.equals(bannerLink, other.bannerLink);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, bannerImage, bannerLink);
	}

	public BannerImage() {
		super();
	}

	public BannerImage(String bannerImage, String bannerLink) {
		super();
		this.bannerImage = bannerImage;
		this.bannerLink = bannerLink;
	}

	@Override
	public String toString() {
		return "BannerImage [id=" + id + ", bannerImage=" + bannerImage + ", bannerLink=" + bannerLink + "]";

	}
	@Transient
	public String getImagePath() {
		if (bannerImage == null )
			return null;

		return "/assets1/images/bannerImage/" + bannerImage;
	}


}
