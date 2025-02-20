package com.javaweb.spring_boot_web_non_jwt.api;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javaweb.spring_boot_web_non_jwt.Beans.BuildingDTO;
import com.javaweb.spring_boot_web_non_jwt.dto.GetBuildingRequest;
import com.javaweb.spring_boot_web_non_jwt.service.BuildingService;



@RestController
public class BuildingAPI {
	@Autowired
	private BuildingService buildingService;

	@GetMapping("/api/buildings")
	public List<BuildingDTO> getBuilding(GetBuildingRequest request) {

		return buildingService.findAll(request);
	}

}
