package com.javaweb.spring_boot_web_non_jwt.service.imp;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.javaweb.spring_boot_web_non_jwt.dto.common.ResetPasswordResult;
import com.javaweb.spring_boot_web_non_jwt.dto.common.UserCredential;
import com.javaweb.spring_boot_web_non_jwt.service.UserService;
import com.javaweb.spring_boot_web_non_jwt.utils.CrytoUtil;


@Service
public class UserServiceImpl implements UserService{
    @Value("${spring.security.secretkey}")
    static String key;

    @Override
    public String hashPassword(String username, String password) {
        if(password.isEmpty() || password == null) {
            System.out.print("Password can't be empty");
            return "";
        }
        return BCrypt.hashpw(CrytoUtil.sign(key, username + password), BCrypt.gensalt());
    }

    @Override
    public boolean verifyPassword(String username, String password, String passwordHash) {
        if(username.isEmpty() || username == null || password.isEmpty() || password == null || passwordHash.isEmpty() || passwordHash == null) {
            System.out.print("Username and password can't be empty");
            return false;
        }
        return BCrypt.checkpw(CrytoUtil.sign(key, username + password), passwordHash);
    }

    @Override
    public String updatePassword(String username, String oldPassword, String newPassword, String passwordHash) {
        try {
            if(
                username.isEmpty() || username == null || 
                oldPassword.isEmpty() || oldPassword == null || 
                newPassword.isEmpty() || newPassword == null || 
                passwordHash.isEmpty() || passwordHash == null
                ) {
                System.out.print("Username and password can't be empty");
                return "";
            }
            if(verifyPassword(username, oldPassword, passwordHash)) {
                return hashPassword(username, newPassword);
            } else {
                System.out.print("Username or password is not correct");
                return "";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    @Override
    public ResetPasswordResult resetPassword(String targetUserId, String requestUserId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'resetPassword'");
    }

    @Override
    public boolean isRecentPasswordMatch(String userId, String username, String password) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isRecentPasswordMatch'");
    }

    @Override
    public int getLoginStatus(String username, String password, String status, String expriedDateTime) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getLoginStatus'");
    }

    @Override
    public UserCredential getUserCredentialByUsername(String username) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getUserCredentialByUsername'");
    }
    
}
