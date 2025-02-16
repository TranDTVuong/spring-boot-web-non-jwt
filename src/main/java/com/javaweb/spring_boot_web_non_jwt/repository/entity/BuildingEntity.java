package com.javaweb.spring_boot_web_non_jwt.repository.entity;

public class BuildingEntity {
	private String name;
	private Integer numberOfBasement;
	private String ward;
	private String street;
	private Long districtId;
	private String managerName;
	private String managerPhoneNumber;
	private Long floorErea;
	private String emptyErea;
	private String rentPrice;
	private String serviceFee;
	private String brokerageFee;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getNumberOfBasement() {
		return numberOfBasement;
	}
	public void setNumberOfBasement(Integer numberOfBasement) {
		this.numberOfBasement = numberOfBasement;
	}
	public String getWard() {
		return ward;
	}
	public void setWard(String ward) {
		this.ward = ward;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
}
