package com.javaweb.spring_boot_web_non_jwt.repository.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


import lombok.Data;

@Entity
@Data
@Table(name="building")
public class BuildingEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "name")
	private String name;
	@Column(name = "numberofbasement")
	private Integer numberOfBasement;
	@Column(name = "ward")
	private String ward;
	@Column(name = "street")
	private String street;
	// @Column(name = "districtid")
	// private Long districtId;
	@Column(name = "managername")
	private String managerName;
	@Column(name = "managerphonenumber")
	private String managerPhoneNumber;
	@Column(name = "floorarea")
	private Long floorArea;
	// @Column(name = "emptyerea")
	// private String emptyErea;
	@Column(name = "rentprice")
	private String rentPrice;
	@Column(name = "servicefee")
	private String serviceFee;
	@Column(name = "brokeragefee")
	private String brokerageFee;

	@ManyToOne
	@JoinColumn(name="districtid")
	private DistrictEntity district;
	
	@OneToMany(mappedBy = "building", fetch = FetchType.LAZY)
	private List<RentAreaEntity> rentAreas = new ArrayList<>();
}
