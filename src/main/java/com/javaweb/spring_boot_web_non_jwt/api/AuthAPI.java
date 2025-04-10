package com.javaweb.spring_boot_web_non_jwt.api;

import org.springframework.web.bind.annotation.RestController;

import com.javaweb.spring_boot_web_non_jwt.dto.AuthRequest;
import com.javaweb.spring_boot_web_non_jwt.dto.AuthResponse;
import com.javaweb.spring_boot_web_non_jwt.dto.common.UserCredential;
import com.javaweb.spring_boot_web_non_jwt.service.AuthenService;
import com.javaweb.spring_boot_web_non_jwt.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class AuthAPI {
    @Autowired
    private AuthenService authenService;

    @PostMapping("api/auth/login")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest request) {
        return authenService.login(request);
    };

    @PostMapping("api/auth/signup")
    public ResponseEntity signup(@RequestBody AuthRequest request) {
        return authenService.signUp(request);
    };

}
