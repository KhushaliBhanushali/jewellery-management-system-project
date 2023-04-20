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
@Table(name="banner_type")
public class BannerType{

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name="id", nullable = false)
private Integer id;

@Basic
@Column(name="height", nullable = false )
private String height;

@Basic
@Column(name="name", nullable = false , length = 255)
private String name;

@Basic
@Column(name="width", nullable = false )
private String width;

@OneToMany(mappedBy = "bannerType", fetch = FetchType.LAZY)
private Set<Banner> banner = new HashSet<>();

public Integer getId() { 
	return id; 
} 

public void setId(Integer id) {
	this.id = id;
}
public String getHeight() { 
	return height; 
} 

public void setHeight(String height) {
	this.height = height;
}
public String getName() { 
	return name; 
} 

public void setName(String name) {
	this.name = name;
}
public String getWidth() { 
	return width; 
} 

public void setWidth(String width) {
	this.width = width;
}
public Set<Banner> getBanners() { 
	return banner; 
} 

public void setBanners(Set<Banner> banner) {
	this.banner = banner;
}
  @Override
     public boolean equals(Object obj) {
         if (this == obj) return true;
         if (obj == null || getClass() != obj.getClass()) return false;
        BannerType other = (BannerType) obj;
         return   Objects.equals(id, other.id)   &&   Objects.equals(height, other.height)   &&   Objects.equals(name, other.name)   &&   Objects.equals(width, other.width)  ;
     }
 
     @Override
     public int hashCode() {
         return Objects.hash(id, height, name, width);
     }
public BannerType() { 
super();
 }
public BannerType(String height, String name, String width ){
 super();
 this.height = height; 
this.name = name; 
this.width = width; 
}
@Override 
public String toString() {
return "BannerType [id=" + id + ", height=" + height + ", name=" + name + ", width=" + width + "]" ; 
 } 
}
