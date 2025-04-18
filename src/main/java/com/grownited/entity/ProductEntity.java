package com.grownited.entity;


import java.time.LocalDate;
import java.util.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="product")
public class ProductEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer productId;	
	private String productName;	
	private Integer categoryId;
	private Integer subCategoryId;
	private Integer basePrice;
	private Integer offerPrice;	
	private Double offerPercentage;	
	private String productDetail;	
	private String productImageURL1;	
	private String productImageURL2;	
	private String productImageURL3;
	private int quantity;
	private LocalDate createdAt;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "categoryId", insertable = false, updatable = false)
	private CategoryEntity category;

	
	public CategoryEntity getCategory() {
		return category;
	}
	public void setCategory(CategoryEntity category) {
		this.category = category;
	}
	
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Integer getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
	public Integer getSubCategoryId() {
		return subCategoryId;
	}
	public void setSubCategoryId(Integer subCategoryId) {
		this.subCategoryId = subCategoryId;
	}
	
	
	public Integer getBasePrice() {
		return basePrice;
	}
	public void setBasePrice(Integer basePrice) {
		this.basePrice = basePrice;
	}
	public Integer getOfferPrice() {
		return offerPrice;
	}
	public void setOfferPrice(Integer offerPrice) {
		this.offerPrice = offerPrice;
	}
	public void setOfferPercentage(Double offerPercentage) {
		this.offerPercentage = offerPercentage;
	}
	public Double getOfferPercentage() {
		return offerPercentage;
	}
	public void setOfferePercentage(Double offerPercentage) {
		this.offerPercentage = offerPercentage;
	}
	public String getProductDetail() {
		return productDetail;
	}
	public void setProductDetail(String productDetail) {
		this.productDetail = productDetail;
	}
	public String getProductImageURL1() {
		return productImageURL1;
	}
	public void setProductImageURL1(String productImageURL1) {
		this.productImageURL1 = productImageURL1;
	}
	public String getProductImageURL2() {
		return productImageURL2;
	}
	public void setProductImageURL2(String productImageURL2) {
		this.productImageURL2 = productImageURL2;
	}
	public String getProductImageURL3() {
		return productImageURL3;
	}
	public void setProductImageURL3(String productImageURL3) {
		this.productImageURL3 = productImageURL3;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public LocalDate getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(LocalDate createdAt) {
		this.createdAt = createdAt;
	}
	

}
