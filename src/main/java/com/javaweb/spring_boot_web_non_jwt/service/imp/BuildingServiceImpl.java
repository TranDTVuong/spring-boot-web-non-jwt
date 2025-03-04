package com.javaweb.spring_boot_web_non_jwt.service.imp;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaweb.spring_boot_web_non_jwt.Beans.BuildingDTO;
import com.javaweb.spring_boot_web_non_jwt.dto.GetBuildingRequest;
import com.javaweb.spring_boot_web_non_jwt.repository.BuildingRepository;
import com.javaweb.spring_boot_web_non_jwt.repository.entity.BuildingEntity;
import com.javaweb.spring_boot_web_non_jwt.service.BuildingService;

@Service
public class BuildingServiceImpl implements BuildingService{
    @Autowired
    private BuildingRepository buildingRepository;

    @Override
    public List<BuildingDTO> findAll(GetBuildingRequest request) {
        List<BuildingDTO> result = new ArrayList<>();
        List<BuildingEntity> buildingEntities = buildingRepository.findAll(request);
        System.out.println("request: ");
        System.out.println(request);
        for(BuildingEntity item : buildingEntities) {
            BuildingDTO building = new BuildingDTO();
            building.setName(item.getName());
            building.setAddress(item.getStreet() + ", " + item.getWard());
            building.setNumberOfBasement(item.getNumberOfBasement());
            result.add(building);
        }
        return result;
    }
    
}
