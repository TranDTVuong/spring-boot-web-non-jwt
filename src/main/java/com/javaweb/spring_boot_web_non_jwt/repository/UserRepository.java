package com.javaweb.spring_boot_web_non_jwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.javaweb.spring_boot_web_non_jwt.repository.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long>{
    public UserEntity findByUsername(String username);

    @Procedure(name = "sp_register_user")
    Integer registerUser(
        @Param("p_username") String username,
        @Param("p_password") String password,
        @Param("p_fullname") String fullname,
        @Param("p_phone") String phone,
        @Param("p_email") String email,
        @Param("p_createdby") String createdBy
    );

}
