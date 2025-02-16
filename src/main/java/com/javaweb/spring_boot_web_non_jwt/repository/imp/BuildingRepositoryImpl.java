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

import com.javaweb.spring_boot_web_non_jwt.repository.BuildingRepository;
import com.javaweb.spring_boot_web_non_jwt.repository.entity.BuildingEntity;

@Repository
public class BuildingRepositoryImpl implements BuildingRepository{
	@Value("${spring.datasource.url}")
	static String DB_URL;
	@Value("${spring.datasource.user}")
	static String USER;
	@Value("${spring.datasource.password}")
	static String PASS;

	@Override
	public List<BuildingEntity> findAll(String name, Long districtId) {
		StringBuilder sql = new StringBuilder("select * from building b where 1 = 1 ");
		if(name != null && !name.isEmpty()) {
			sql.append("and b.name like '%" + name + "%' ");
		}
		if(districtId != null) {
			sql.append("and b.districtid like '%" + districtId + "%' ");
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

}
