package com.javaweb.spring_boot_web_non_jwt.repository.imp;

import java.util.List;
import java.util.stream.Collectors;

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
        String sql = "Select b FROM BuildingEntity b ";
        if(!request.getTypeCode().isEmpty()) {
            sql = sql.concat("JOIN b.buildingRentTypes br ")
                .concat("JOIN br.rentType r where r.code in (" + request.getTypeCode().stream()
                .map(code -> "'" + code + "'")
                .collect(Collectors.joining(", ")) + ") %s ")
                .concat("group by b.id having count(distinct r.code ) =" + request.getTypeCode().size());
        } else {
            sql = sql.concat("where 1 = 1 %s");
        }
        sql = String.format(sql, (request.getName() != null &&!request.getName().isEmpty() ?"and b.name like '%" + request.getName() + "%' " : "") + 
                (request.getDistrictId() != null ? "and b.districtid like '%" + request.getDistrictId() + "%' " : ""));
        Query query = entityManager.createQuery(sql, BuildingEntity.class);
        return query.getResultList();
    }

    @Override
    public void deleteById(Long id) {
    }
    
}
