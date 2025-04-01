package com.grownited.entity;
import java.time.LocalDate;
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
private LocalDate createdAt;
private Integer status; //active or disabled
private String otp; 
private String profilePicPath;


public String getProfilePicPath() {
	return profilePicPath;
}
public void setProfilePicPath(String profilePicPath) {
	this.profilePicPath = profilePicPath;
}
public String getOtp() {
	return otp;
}
public void setOtp(String otp) {
	this.otp = otp;
}
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

public LocalDate getCreatedAt() {
	return createdAt;
}
public void setCreatedAt(LocalDate createdAt) {
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
