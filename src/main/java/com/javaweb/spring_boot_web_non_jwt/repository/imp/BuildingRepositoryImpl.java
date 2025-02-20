package com.javaweb.spring_boot_web_non_jwt.repository.imp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.javaweb.spring_boot_web_non_jwt.dto.GetBuildingRequest;
import com.javaweb.spring_boot_web_non_jwt.repository.BuildingRepository;
import com.javaweb.spring_boot_web_non_jwt.repository.entity.BuildingEntity;

@Repository
public class BuildingRepositoryImpl implements BuildingRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<BuildingEntity> findAll(GetBuildingRequest request) {
        // JPQL: JPA Query Language
        String sql = "FROM BuildingEntity b ";
        Query query = entityManager.createQuery(sql, BuildingEntity.class);
        return query.getResultList();
    }

    @Override
    public void deleteById(Long id) {
    }
    
}
