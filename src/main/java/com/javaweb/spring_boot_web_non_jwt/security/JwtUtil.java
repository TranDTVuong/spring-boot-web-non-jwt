package com.javaweb.spring_boot_web_non_jwt.security;

import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.javaweb.spring_boot_web_non_jwt.dto.common.UserCredential;
import com.javaweb.spring_boot_web_non_jwt.service.UserService;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class JwtUtil {
    private static String secretKey;
    private static Algorithm ALGORITHM;

    private final UserService userService;

    @Value("${app.jwt.secretkey}")
    public void setSecretKey(String key) {
        secretKey = key;
        ALGORITHM = Algorithm.HMAC256(secretKey);
    }

    public static String generateToken(String username) {
        return JWT.create()
        .withSubject(username)
        .withClaim("username", username)
        .withIssuer("spring_boot_web_non_jwt")
        .withIssuedAt(new Date())
        .withExpiresAt(new Date(System.currentTimeMillis() + 86400000))
        .sign(ALGORITHM);
    }

    public static Map<String, Claim> decodeToken(String token) {
        return JWT.require(ALGORITHM).withIssuer("spring_boot_web_non_jwt").build().verify(token).getClaims();
    }

    public boolean verifyToken(String token) {
        try {
            String username = JWT.require(ALGORITHM).withIssuer("spring_boot_web_non_jwt").build().verify(token).getSubject();
            return username != null && userService.getUserCredentialByUsername(username) != null;
        } catch (Exception e) {
            return false;
        }
    }
}
