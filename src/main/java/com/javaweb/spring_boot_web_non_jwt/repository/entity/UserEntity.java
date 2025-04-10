package com.javaweb.spring_boot_web_non_jwt.repository.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import lombok.Data;

@NamedStoredProcedureQuery(
    name = "sp_register_user",
    procedureName = "sp_register_user",
    parameters = {
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_username", type = String.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_password", type = String.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_fullname", type = String.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_phone", type = String.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_email", type = String.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_createdby", type = String.class),
        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "p_result", type = Integer.class)
    }
)
@Entity
@Data
@Table(name = "user")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "username", nullable = false, unique = true)
    private String username;
    @Column(name = "password", nullable = false)
    private String password;
    @Column(name = "fullname")
    private String fullName;
    @Column(name = "status", nullable = false)
    private String status;
    @Column(name = "email")
    private String email;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<UserRoleEntity> userRoleEntities = new ArrayList<>();
}
