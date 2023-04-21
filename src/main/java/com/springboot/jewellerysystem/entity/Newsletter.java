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
@Table(name="newsletter")
public class Newsletter{

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name="id", nullable = false)
private Integer id;

@Basic
@Column(name="email", nullable = false , length = 50)
private String email;

@Basic
@Column(name="status", nullable = false )
private Integer status;

public Integer getId() { 
	return id; 
} 

public void setId(Integer id) {
	this.id = id;
}
public String getEmail() { 
	return email; 
} 

public void setEmail(String email) {
	this.email = email;
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
        Newsletter other = (Newsletter) obj;
         return   Objects.equals(id, other.id)   &&   Objects.equals(email, other.email)   &&   Objects.equals(status, other.status)  ;
     }
 
     @Override
     public int hashCode() {
         return Objects.hash(id, email, status);
     }
public Newsletter() { 
super();
 }
public Newsletter(String email, Integer status ){
 super();
 this.email = email; 
this.status = status; 
}
@Override 
public String toString() {
return "Newsletter [id=" + id + ", email=" + email + ", status=" + status + "]" ; 
 } 
}
