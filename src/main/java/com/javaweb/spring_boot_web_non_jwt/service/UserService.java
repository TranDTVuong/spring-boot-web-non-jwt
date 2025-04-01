package com.javaweb.spring_boot_web_non_jwt.service;

import com.javaweb.spring_boot_web_non_jwt.dto.common.ResetPasswordResult;
import com.javaweb.spring_boot_web_non_jwt.dto.common.UserCredential;

public interface UserService {
    String hashPassword(String username, String password);
    boolean verifyPassword(String username, String password, String passwordHash);
    String updatePassword(String username, String oldPassword, String newPassword, String passwordHash);
    ResetPasswordResult resetPassword(String targetUserId, String requestUserId);
    boolean isRecentPasswordMatch(String userId, String username, String password);
    int getLoginStatus(String username, String password, String status, String expriedDateTime);
    UserCredential getUserCredentialByUsername(String username);
}
