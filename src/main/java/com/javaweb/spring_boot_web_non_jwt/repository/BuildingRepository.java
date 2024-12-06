package com.javaweb.spring_boot_web_non_jwt.repository;

import java.util.*;

import com.javaweb.spring_boot_web_non_jwt.repository.entity.BuildingEntity;

public interface BuildingRepository {
	List<BuildingEntity> findAll(String name, Long districtId);
}
