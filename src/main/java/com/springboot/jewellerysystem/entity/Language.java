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
@Table(name="language")
public class Language{

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name="id", nullable = false)
private Integer id;

@Basic
@Column(name="name", nullable = false , length = 50)
private String name;

@Basic
@Column(name="status", nullable = false )
private Integer status;

@Basic
@Column(name="code", nullable = false , length = 3)
private String code;

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
public String getCode() { 
	return code; 
} 

public void setCode(String code) {
	this.code = code;
}
  @Override
     public boolean equals(Object obj) {
         if (this == obj) return true;
         if (obj == null || getClass() != obj.getClass()) return false;
        Language other = (Language) obj;
         return   Objects.equals(id, other.id)   &&   Objects.equals(name, other.name)   &&   Objects.equals(status, other.status)   &&   Objects.equals(code, other.code)  ;
     }
 
     @Override
     public int hashCode() {
         return Objects.hash(id, name, status, code);
     }
public Language() { 
super();
 }
public Language(String name, Integer status, String code ){
 super();
 this.name = name; 
this.status = status; 
this.code = code; 
}
@Override 
public String toString() {
return "Language [id=" + id + ", name=" + name + ", status=" + status + ", code=" + code + "]" ; 
 } 
}
