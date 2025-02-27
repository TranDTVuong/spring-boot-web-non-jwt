package com.javaweb.spring_boot_web_non_jwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.javaweb.spring_boot_web_non_jwt.repository.entity.DistrictEntity;
import java.util.List;


@Repository
public interface DistrictRepository extends JpaRepository<DistrictEntity, Long> {
    // DistrictEntity findById(Long id);
}
