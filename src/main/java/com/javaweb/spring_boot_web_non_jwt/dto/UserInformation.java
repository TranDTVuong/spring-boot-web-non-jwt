package com.javaweb.spring_boot_web_non_jwt.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserInformation {
    private String username;
    private String password;
    private String fullname;
    private String phone;
    private String email;
    private String createdBy;
}
