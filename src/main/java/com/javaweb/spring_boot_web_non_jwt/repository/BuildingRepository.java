package com.javaweb.spring_boot_web_non_jwt.repository;

import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.javaweb.spring_boot_web_non_jwt.dto.GetBuildingRequest;
import com.javaweb.spring_boot_web_non_jwt.repository.entity.BuildingEntity;

@Repository
public interface BuildingRepository extends JpaRepository<BuildingEntity, Long>{
	// List<BuildingEntity> findAll(GetBuildingRequest request);
	// public void deleteById(Long id);
}
