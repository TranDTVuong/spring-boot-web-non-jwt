package com.javaweb.spring_boot_web_non_jwt.dto.common;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResetPasswordResult {
    private String resultCode;
    private String token;
    private String exceptionTime;
    private String displayName;
    private String username;
}
