package com.javaweb.spring_boot_web_non_jwt.service;

import org.springframework.http.ResponseEntity;

import com.javaweb.spring_boot_web_non_jwt.dto.AuthRequest;
import com.javaweb.spring_boot_web_non_jwt.dto.AuthResponse;

public interface AuthenService {
    ResponseEntity<AuthResponse> login(AuthRequest request);
    ResponseEntity signUp(AuthRequest request);
}
