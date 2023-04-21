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
@Table(name="rate_master")
public class RateMaster{

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name="id", nullable = false)
private Integer id;

@Basic
@Column(name="title", nullable = false , length = 255)
private String title;

@Basic
@Column(name="rate", nullable = false )
private Float rate;

@Basic
@Column(name="gram", nullable = false )
private Integer gram;

@Basic
@Column(name="status", nullable = false )
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
public Float getRate() { 
	return rate; 
} 

public void setRate(Float rate) {
	this.rate = rate;
}
public Integer getGram() { 
	return gram; 
} 

public void setGram(Integer gram) {
	this.gram = gram;
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
        RateMaster other = (RateMaster) obj;
         return   Objects.equals(id, other.id)   &&   Objects.equals(title, other.title)   &&   Objects.equals(rate, other.rate)   &&   Objects.equals(gram, other.gram)   &&   Objects.equals(status, other.status)  ;
     }
 
     @Override
     public int hashCode() {
         return Objects.hash(id, title, rate, gram, status);
     }
public RateMaster() { 
super();
 }
public RateMaster(String title, Float rate, Integer gram, Integer status ){
 super();
 this.title = title; 
this.rate = rate; 
this.gram = gram; 
this.status = status; 
}
@Override 
public String toString() {
return "RateMaster [id=" + id + ", title=" + title + ", rate=" + rate + ", gram=" + gram + ", status=" + status + "]" ; 
 } 
}
