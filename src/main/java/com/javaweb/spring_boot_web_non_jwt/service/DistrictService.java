package com.javaweb.spring_boot_web_non_jwt.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javaweb.spring_boot_web_non_jwt.dto.GetDistrictResponse;

public interface DistrictService {
    GetDistrictResponse findNameById(Long id);
}
