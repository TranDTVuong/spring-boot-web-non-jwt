package com.javaweb.spring_boot_web_non_jwt.dto;

import lombok.Data;

@Data
public class AuthRequest {
    private String username;
    private String password;
    private boolean isUpdateRequest;
    private boolean isCreateRequest;
    private String oldPassword;
    private String fullname;
    private String phone;
    private String email;
    private String createdBy;
}
