package com.javaweb.spring_boot_web_non_jwt.service.impl;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaweb.spring_boot_web_non_jwt.dto.GetDistrictResponse;
import com.javaweb.spring_boot_web_non_jwt.repository.DistrictRepository;
import com.javaweb.spring_boot_web_non_jwt.repository.entity.DistrictEntity;
import com.javaweb.spring_boot_web_non_jwt.service.DistrictService;

@Service
public class DistrictServiceImpl implements DistrictService {
    @Autowired
    private DistrictRepository districtRepository;

    @Override
    public GetDistrictResponse findNameById(Long id) {
        GetDistrictResponse result = new GetDistrictResponse();
        DistrictEntity districtEntity = districtRepository.findById(id).orElseThrow(() -> 
        new EntityNotFoundException("District not found with id: " + id));
        result.setName(districtEntity.getName());
        result.setCode(districtEntity.getCode());
        return result;
    }
    
}
