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
@Table(name="faq")
public class Faq{

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name="id", nullable = false)
private Integer id;

@Basic
@Column(name="question", nullable = false , length = 255)
private String question;

@Basic
@Column(name="answer", nullable = false , length = 65535)
private String answer;

@Basic
@Column(name="status", nullable = false )
private Integer status;

public Integer getId() { 
	return id; 
} 

public void setId(Integer id) {
	this.id = id;
}
public String getQuestion() { 
	return question; 
} 

public void setQuestion(String question) {
	this.question = question;
}
public String getAnswer() { 
	return answer; 
} 

public void setAnswer(String answer) {
	this.answer = answer;
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
        Faq other = (Faq) obj;
         return   Objects.equals(id, other.id)   &&   Objects.equals(question, other.question)   &&   Objects.equals(answer, other.answer)   &&   Objects.equals(status, other.status)  ;
     }
 
     @Override
     public int hashCode() {
         return Objects.hash(id, question, answer, status);
     }
public Faq() { 
super();
 }
public Faq(String question, String answer, Integer status ){
 super();
 this.question = question; 
this.answer = answer; 
this.status = status; 
}
@Override 
public String toString() {
return "Faq [id=" + id + ", question=" + question + ", answer=" + answer + ", status=" + status + "]" ; 
 } 
}
