package com.grownited.entity;



import java.util.*;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity//create table
@Table(name="users")//table name set
public class UserEntity {
//UUID , Integer , Long , int , long userId;
	
	@Id //primary key allowed
	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
private	Integer userId;
private	String firstName;
private String lastName;
@Column(unique = true)
private	String email;
private	String password;
private String confirmPassword;
private	String contactNum;
private	String gender;
private	String role;//member,security,chairman,admin
private Date createdAt;
private Integer status; //active or disabled

public Integer getStatus() {
	return status;
}
public void setStatus(Integer status) {
	this.status = status;
}
public Integer getUserId() {
	return userId;
}
public void setUserId(Integer userId) {
	this.userId = userId;
}

public Date getCreatedAt() {
	return createdAt;
}
public void setCreatedAt(Date createdAt) {
	this.createdAt = createdAt;
}
public String getFirstName() {
	return firstName;
}
public void setFirstName(String firstName) {
	this.firstName = firstName;
}
public String getLastName() {
	return lastName;
}
public void setLastName(String lastName) {
	this.lastName = lastName;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getContactNum() {
	return contactNum;
}
public void setContactNum(String contactNum) {
	this.contactNum = contactNum;
}
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}
public String getRole() {
	return role;
}
public void setRole(String role) {
	this.role = role;
}
public String getConfirmPassword() {
	return confirmPassword;
}
public void setConfirmPassword(String confirmPassword) {
	this.confirmPassword = confirmPassword;
}


}
