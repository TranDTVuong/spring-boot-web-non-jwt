package com.javaweb.spring_boot_web_non_jwt.service;

import java.util.List;

import com.javaweb.spring_boot_web_non_jwt.Beans.BuildingDTO;
import com.javaweb.spring_boot_web_non_jwt.dto.GetBuildingRequest;

public interface BuildingService {
    List<BuildingDTO> findAll(GetBuildingRequest request);
}
