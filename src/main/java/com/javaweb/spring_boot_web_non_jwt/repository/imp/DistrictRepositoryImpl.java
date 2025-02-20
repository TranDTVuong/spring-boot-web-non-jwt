package com.javaweb.spring_boot_web_non_jwt.repository.imp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.javaweb.spring_boot_web_non_jwt.repository.DistrictRepository;
import com.javaweb.spring_boot_web_non_jwt.repository.entity.DistrictEntity;

@Repository
public class DistrictRepositoryImpl implements DistrictRepository {
    @Value("${spring.datasource.url}")
	static String DB_URL;
	@Value("${spring.datasource.user}")
	static String USER;
	@Value("${spring.datasource.password}")
	static String PASS;
    // Unused in JPA
    @Override
    public DistrictEntity findNameById(Long id) {
        StringBuilder sql = new StringBuilder("select * from district d where d.id = " + id + ";");
        DistrictEntity result = new DistrictEntity();
        try(
			Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql.toString());
				){
			while(rs.next()) {
                result.setCode(rs.getString("code"));
                result.setName(rs.getString("name"));
			}
		}catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Connected database failed ...");
		}
        return result;
    }
    
}
