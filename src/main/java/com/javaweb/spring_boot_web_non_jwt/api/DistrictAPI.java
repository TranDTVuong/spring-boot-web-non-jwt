package com.javaweb.spring_boot_web_non_jwt.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.javaweb.spring_boot_web_non_jwt.dto.GetDistrictResponse;
import com.javaweb.spring_boot_web_non_jwt.service.DistrictService;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class DistrictAPI {
    @Autowired
    private DistrictService districtService;

    @GetMapping("api/getDistrictById")
    public GetDistrictResponse getMethodName(Long id) {
        return districtService.findNameById(id);
    }
    
    
}
