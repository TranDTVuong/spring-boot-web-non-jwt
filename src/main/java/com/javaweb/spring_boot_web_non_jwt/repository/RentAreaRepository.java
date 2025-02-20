package com.javaweb.spring_boot_web_non_jwt.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.javaweb.spring_boot_web_non_jwt.repository.entity.RentAreaEntity;

@Repository
public interface RentAreaRepository {
    public List<RentAreaEntity> getValueByBuildingId(Long id);
}
