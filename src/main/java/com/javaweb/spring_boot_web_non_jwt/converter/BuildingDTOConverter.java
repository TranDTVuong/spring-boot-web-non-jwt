package com.javaweb.spring_boot_web_non_jwt.converter;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.javaweb.spring_boot_web_non_jwt.Beans.BuildingDTO;
import com.javaweb.spring_boot_web_non_jwt.repository.entity.BuildingEntity;
import com.javaweb.spring_boot_web_non_jwt.repository.entity.RentAreaEntity;

public class BuildingDTOConverter {
    @Autowired
    private ModelMapper modelMapper;

    public BuildingDTO toBuildingDTO(BuildingEntity item) {
        BuildingDTO building = modelMapper.map(item, BuildingDTO.class);
        building.setAddress(item.getStreet() + ", " + item.getWard() + ", " + item.getDistrict().getName());
        List<RentAreaEntity> rentAreas = item.getRentAreas();
        String areaResult = rentAreas.stream().map(i -> i.getValue().toString()).collect(Collectors.joining(", "));
        building.setRentArea(areaResult);
        return building;
    }
}
