package com.javaweb.spring_boot_web_non_jwt.Beans;

import lombok.Data;

@Data
public class BuildingDTO {
	private String name;
	private Integer numberOfBasement;
	private String address;
	private Long districtId;
	private String managerName;
	private String managerPhoneNumber;
	private Long floorErea;
	private String emptyErea;
	private String rentPrice;
	private String serviceFee;
	private String brokerageFee;
	private String rentArea;
}
