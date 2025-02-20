package com.javaweb.spring_boot_web_non_jwt.repository;

import org.springframework.stereotype.Repository;

import com.javaweb.spring_boot_web_non_jwt.repository.entity.DistrictEntity;

@Repository
public interface DistrictRepository {
    public DistrictEntity findNameById(Long id);
}
