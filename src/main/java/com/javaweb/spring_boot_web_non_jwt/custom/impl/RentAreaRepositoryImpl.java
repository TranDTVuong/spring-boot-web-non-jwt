package com.javaweb.spring_boot_web_non_jwt.custom.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.javaweb.spring_boot_web_non_jwt.repository.RentAreaRepository;
import com.javaweb.spring_boot_web_non_jwt.repository.entity.DistrictEntity;
import com.javaweb.spring_boot_web_non_jwt.repository.entity.RentAreaEntity;

@Repository
public class RentAreaRepositoryImpl implements RentAreaRepository {
    @Value("${spring.datasource.url}")
	static String DB_URL;
	@Value("${spring.datasource.user}")
	static String USER;
	@Value("${spring.datasource.password}")
	static String PASS;
    // Unused in JPA

    @Override
    public List<RentAreaEntity> getValueByBuildingId(Long id) {
        StringBuilder sql = new StringBuilder("select * from district d where d.id = " + id + ";");
        List<RentAreaEntity> result = new ArrayList<>();
        try(
			Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql.toString());
				){
			while(rs.next()) {
                RentAreaEntity rentAreaEntity = new RentAreaEntity();
                result.add(rentAreaEntity);
			}
		}catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Connected database failed ...");
		}
        return result;
    }
    
}
