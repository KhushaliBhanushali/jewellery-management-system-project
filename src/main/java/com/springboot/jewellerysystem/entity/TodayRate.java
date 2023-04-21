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
@Table(name="today_rate")
public class TodayRate{

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name="id", nullable = false)
private Integer id;

@Basic
@Column(name="name", nullable = false , length = 255)
private String name;

@Basic
@Column(name="price", nullable = false )
private Float price;

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
public Float getPrice() { 
	return price; 
} 

public void setPrice(Float price) {
	this.price = price;
}
  @Override
     public boolean equals(Object obj) {
         if (this == obj) return true;
         if (obj == null || getClass() != obj.getClass()) return false;
        TodayRate other = (TodayRate) obj;
         return   Objects.equals(id, other.id)   &&   Objects.equals(name, other.name)   &&   Objects.equals(price, other.price)  ;
     }
 
     @Override
     public int hashCode() {
         return Objects.hash(id, name, price);
     }
public TodayRate() { 
super();
 }
public TodayRate(String name, Float price ){
 super();
 this.name = name; 
this.price = price; 
}
@Override 
public String toString() {
return "TodayRate [id=" + id + ", name=" + name + ", price=" + price + "]" ; 
 } 
}
