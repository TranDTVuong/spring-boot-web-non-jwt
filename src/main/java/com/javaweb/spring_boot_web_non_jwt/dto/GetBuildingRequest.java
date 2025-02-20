package com.javaweb.spring_boot_web_non_jwt.dto;

import java.util.List;

import lombok.Data;

@Data
public class GetBuildingRequest {
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
    private List<String> typeCode;
}
