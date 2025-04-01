package com.javaweb.spring_boot_web_non_jwt.dto.common;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserCredential {
    private String userId;
    private String username;
    private String password;
    private int updatePassword;
    private String status;
    private String lastEditPasswordDateTime;
    private String expirePasswordDateTime;
}
