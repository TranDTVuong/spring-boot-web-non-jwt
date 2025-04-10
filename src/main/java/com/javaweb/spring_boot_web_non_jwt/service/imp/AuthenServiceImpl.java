package com.javaweb.spring_boot_web_non_jwt.service.imp;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.javaweb.spring_boot_web_non_jwt.dto.AuthRequest;
import com.javaweb.spring_boot_web_non_jwt.dto.AuthResponse;
import com.javaweb.spring_boot_web_non_jwt.dto.UserInformation;
import com.javaweb.spring_boot_web_non_jwt.repository.UserRepository;
import com.javaweb.spring_boot_web_non_jwt.repository.entity.UserEntity;
import com.javaweb.spring_boot_web_non_jwt.security.JwtUtil;
import com.javaweb.spring_boot_web_non_jwt.service.AuthenService;
import com.javaweb.spring_boot_web_non_jwt.service.UserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthenServiceImpl implements AuthenService{
    private final UserService userService;
    private final UserRepository userRepository;

    @Override
    public ResponseEntity<AuthResponse> login(AuthRequest request) {
        AuthResponse result = AuthResponse.builder()
        .username(request.getUsername())
        .build();
        UserEntity userInfo = userRepository.findByUsername(request.getUsername());
        if(userService.verifyPassword(request.getUsername(), request.getPassword(), userInfo.getPassword())) {
            result.setFullname(userInfo.getFullName());
            result.setToken(JwtUtil.generateToken(request.getUsername()));
            
            return ResponseEntity.ok(result);
        } else {
            return ResponseEntity.badRequest().body(result);
        }
        
    }

    @Override
    public ResponseEntity signUp(AuthRequest request) {
        UserInformation userInfo = UserInformation.builder()
        .username(request.getUsername())
        .password(userService.hashPassword(request.getUsername(), request.getPassword()))
        .fullname(request.getFullname())
        .email(request.getEmail())
        .phone(request.getPhone())
        .createdBy(request.getCreatedBy())
        .build();
        return userService.registerUser(userInfo) == 1 ? ResponseEntity.ok(null) : ResponseEntity.internalServerError().build();
    }
    
}
