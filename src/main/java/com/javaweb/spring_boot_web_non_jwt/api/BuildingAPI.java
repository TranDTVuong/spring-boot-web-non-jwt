package com.javaweb.spring_boot_web_non_jwt.api;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.javaweb.spring_boot_web_non_jwt.Beans.BuildingDTO;
import com.javaweb.spring_boot_web_non_jwt.service.BuildingService;



@RestController
public class BuildingAPI {
	@Autowired
	private BuildingService buildingService;

	@GetMapping("/api/buildings")
	public List<BuildingDTO> getBuilding(@RequestParam(value="name", required = false) String name, 
			@RequestParam(value="districtId", required = false) Long districtId,
			@RequestParam(value="typeCode", required = false) List<String> typeCode) {

		return buildingService.findAll(name, districtId);
	}

}
