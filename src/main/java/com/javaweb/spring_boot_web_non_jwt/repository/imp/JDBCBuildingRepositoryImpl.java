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

import com.javaweb.spring_boot_web_non_jwt.dto.GetBuildingRequest;
import com.javaweb.spring_boot_web_non_jwt.repository.BuildingRepository;
import com.javaweb.spring_boot_web_non_jwt.repository.entity.BuildingEntity;


public class JDBCBuildingRepositoryImpl implements BuildingRepository{
	@Value("${spring.datasource.url}")
	static String DB_URL;
	@Value("${spring.datasource.user}")
	static String USER;
	@Value("${spring.datasource.password}")
	static String PASS;

	@Override
	public List<BuildingEntity> findAll(GetBuildingRequest request) {
		StringBuilder sql = new StringBuilder("select * from building b where 1 = 1 ");
		if(request.getName() != null && !request.getName().isEmpty()) {
			sql.append("and b.name like '%" + request.getName() + "%' ");
		}
		if(request.getDistrictId() != null) {
			sql.append("and b.districtid like '%" + request.getDistrictId() + "%' ");
		}
		List<BuildingEntity> result = new ArrayList<>();
		try(
			Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql.toString());
				){
			while(rs.next()) {
				BuildingEntity building = new BuildingEntity();
				building.setName(rs.getString("name"));
				building.setStreet(rs.getString("street"));
				building.setWard(rs.getString("ward"));
				building.setNumberOfBasement(rs.getInt("numberofbasement"));
				result.add(building);
			}
		}catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Connected database failed ...");
		}
		return result;
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'deleteById'");
	}

}
