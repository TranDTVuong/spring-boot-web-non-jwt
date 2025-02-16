package com.javaweb.spring_boot_web_non_jwt.dbconfig;

import java.sql.Connection;
import java.sql.DriverManager;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;

@PropertySource("classpath:application-uat.properties")
public class MySQLDBconfig {
    @Value("${spring.datasource.url}")
	static String DB_URL;
	@Value("${spring.datasource.user}")
	static String USER;
	@Value("${spring.datasource.password}")
	static String PASS;

    public static Connection getConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (Exception e) {
            e.printStackTrace();
			System.out.println("Connected database failed ...");
        }
        return conn;
    }
}
