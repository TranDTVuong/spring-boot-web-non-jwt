package com.javaweb.spring_boot_web_non_jwt.repository.imp;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.javaweb.spring_boot_web_non_jwt.repository.DistrictRepository;
import com.javaweb.spring_boot_web_non_jwt.repository.entity.DistrictEntity;

@Repository
public class DistrictRepositoryImpl implements DistrictRepository {

	@PersistenceContext
    private EntityManager entityManager;

    @Override
    public DistrictEntity findNameById(Long id) {
        String sql = "from DistrictEntity d where d.id = " + id;
        Query query = entityManager.createQuery(sql, DistrictEntity.class);
        return (DistrictEntity) query.getResultList().get(0);
    }
    
}
