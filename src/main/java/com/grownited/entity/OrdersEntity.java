package com.grownited.entity;

import java.time.LocalDate;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="orders")
public class OrdersEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer orderId;			
   private Integer userId;			
   private String status;			
   private Integer totalAmount;				
   private LocalDate	createdAt;
public Integer getOrderId() {
	return orderId;
}
public void setOrderId(Integer orderId) {
	this.orderId = orderId;
}
public Integer getUserId() {
	return userId;
}
public void setUserId(Integer userId) {
	this.userId = userId;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
public Integer getTotalAmount() {
	return totalAmount;
}
public void setTotalAmount(Integer totalAmount) {
	this.totalAmount = totalAmount;

}
public LocalDate getCreatedAt() {
	return createdAt;
}
public void setCreatedAt(LocalDate createdAt) {
	this.createdAt = createdAt;
}
   
   
}
