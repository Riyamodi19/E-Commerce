package com.grownited.dto;

public class UserAddressDto {
	
	   private Integer userAddressId;
	   private Integer userId;
	   private String  title;
	   private String  unitName;
	   private String  street;
	   private String  landMark;
	   private Integer cityId;
	   private String cityName;
	   private Integer stateId;
	   private String stateName;
	   private String addressDetail;
	   private int zipCode;
	   
	   
	  public UserAddressDto(Integer userAddressId, Integer userId, String title, String unitName, String street,
			String landMark, Integer cityId, String cityName, Integer stateId, String stateName, String addressDetail,
			int zipCode) {
		super();
		this.userAddressId = userAddressId;
		this.userId = userId;
		this.title = title;
		this.unitName = unitName;
		this.street = street;
		this.landMark = landMark;
		this.cityId = cityId;
		this.cityName = cityName;
		this.stateId = stateId;
		this.stateName = stateName;
		this.addressDetail = addressDetail;
		this.zipCode = zipCode;
	}
	public Integer getUserAddressId() {
		return userAddressId;
	}
	public void setUserAddressId(Integer userAddressId) {
		this.userAddressId = userAddressId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getUnitName() {
		return unitName;
	}
	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getLandMark() {
		return landMark;
	}
	public void setLandMark(String landMark) {
		this.landMark = landMark;
	}
	public Integer getCityId() {
		return cityId;
	}
	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public Integer getStateId() {
		return stateId;
	}
	public void setStateId(Integer stateId) {
		this.stateId = stateId;
	}
	public String getStateName() {
		return stateName;
	}
	public void setStateName(String stateName) {
		this.stateName = stateName;
	}
	public String getAddressDetail() {
		return addressDetail;
	}
	public void setAddressDetail(String addressDetail) {
		this.addressDetail = addressDetail;
	}
	public int getZipCode() {
		return zipCode;
	}
	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}
	   
}