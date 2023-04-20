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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="banner")
public class Banner{

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name="id", nullable = false)
private Integer id;

@ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "banner_type_id",referencedColumnName = "id",nullable = false)
private BannerType bannerType;

@Basic
@Column(name="name", nullable = false , length = 50)
private String name;

@Basic
@Column(name="status", nullable = false )
private Integer status;

@OneToMany(mappedBy = "banner", fetch = FetchType.LAZY)
private Set<BannerImage> bannerImage = new HashSet<>();

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
public BannerType getBannerType() { 
	return bannerType; 
} 

public void setBannerType(BannerType bannerType) {
	this.bannerType = bannerType;
}
public Set<BannerImage> getBannerImages() { 
	return bannerImage; 
} 

public void setBannerImages(Set<BannerImage> bannerImage) {
	this.bannerImage = bannerImage;
}
  @Override
     public boolean equals(Object obj) {
         if (this == obj) return true;
         if (obj == null || getClass() != obj.getClass()) return false;
        Banner other = (Banner) obj;
         return   Objects.equals(id, other.id)   &&   Objects.equals(name, other.name)   &&   Objects.equals(status, other.status)  ;
     }
 
     @Override
     public int hashCode() {
         return Objects.hash(id, name, status);
     }
public Banner() { 
super();
 }
public Banner(String name, Integer status ){
 super();
 this.name = name; 
this.status = status; 
}
@Override 
public String toString() {
return "Banner [id=" + id + ", name=" + name + ", status=" + status + "]" ; 
 } 
}
