package com.javaweb.spring_boot_web_non_jwt.dto.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserCredential {
    private String userId;
    private String username;
    private String password;
    private String status;
    private String lastEditPasswordDateTime;
    private String expirePasswordDateTime;
}
