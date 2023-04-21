package com.springboot.jewellerysystem.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Table(name="link")
public class Link{

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name="id", nullable = false)
private Integer id;

@Basic
@Column(name="link_type", nullable = false , length = 50)
private String linkType;

@Basic
@Column(name="url", nullable = false , length = 255)
private String url;

@Basic
@Column(name="status", nullable = false )
private Integer status;

public Integer getId() { 
	return id; 
} 

public void setId(Integer id) {
	this.id = id;
}
public String getLinkType() { 
	return linkType; 
} 

public void setLinkType(String linkType) {
	this.linkType = linkType;
}
public String getUrl() { 
	return url; 
} 

public void setUrl(String url) {
	this.url = url;
}
public Integer getStatus() { 
	return status; 
} 

public void setStatus(Integer status) {
	this.status = status;
}
  @Override
     public boolean equals(Object obj) {
         if (this == obj) return true;
         if (obj == null || getClass() != obj.getClass()) return false;
        Link other = (Link) obj;
         return   Objects.equals(id, other.id)   &&   Objects.equals(linkType, other.linkType)   &&   Objects.equals(url, other.url)   &&   Objects.equals(status, other.status)  ;
     }
 
     @Override
     public int hashCode() {
         return Objects.hash(id, linkType, url, status);
     }
public Link() { 
super();
 }
public Link(String linkType, String url, Integer status ){
 super();
 this.linkType = linkType; 
this.url = url; 
this.status = status; 
}
@Override 
public String toString() {
return "Link [id=" + id + ", linkType=" + linkType + ", url=" + url + ", status=" + status + "]" ; 
 } 
}
