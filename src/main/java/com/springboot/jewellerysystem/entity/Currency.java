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
@Table(name="currency")
public class Currency{

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name="id", nullable = false)
private Integer id;

@Basic
@Column(name="name", nullable = false , length = 50)
private String name;

@Basic
@Column(name="symbol", nullable = false , length = 5)
private String symbol;

@Basic
@Column(name="exchange_rate", nullable = false )
private Float exchangeRate;

@Basic
@Column(name="code", nullable = false , length = 3)
private String code;

@Basic
@Column(name="status", nullable = false )
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
public String getSymbol() { 
	return symbol; 
} 

public void setSymbol(String symbol) {
	this.symbol = symbol;
}
public Float getExchangeRate() { 
	return exchangeRate; 
} 

public void setExchangeRate(Float exchangeRate) {
	this.exchangeRate = exchangeRate;
}
public String getCode() { 
	return code; 
} 

public void setCode(String code) {
	this.code = code;
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
        Currency other = (Currency) obj;
         return   Objects.equals(id, other.id)   &&   Objects.equals(name, other.name)   &&   Objects.equals(symbol, other.symbol)   &&   Objects.equals(exchangeRate, other.exchangeRate)   &&   Objects.equals(code, other.code)   &&   Objects.equals(status, other.status)  ;
     }
 
     @Override
     public int hashCode() {
         return Objects.hash(id, name, symbol, exchangeRate, code, status);
     }
public Currency() { 
super();
 }
public Currency(String name, String symbol, Float exchangeRate, String code, Integer status ){
 super();
 this.name = name; 
this.symbol = symbol; 
this.exchangeRate = exchangeRate; 
this.code = code; 
this.status = status; 
}
@Override 
public String toString() {
return "Currency [id=" + id + ", name=" + name + ", symbol=" + symbol + ", exchangeRate=" + exchangeRate + ", code=" + code + ", status=" + status + "]" ; 
 } 
}
