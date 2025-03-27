package com.javaweb.spring_boot_web_non_jwt.security;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

public class JwtUtil {
    @Value("${app.jwt.secretkey}")
    private static String SECRECT_KEY;
    private static final Algorithm ALGORITHM = Algorithm.HMAC256(SECRECT_KEY);

    public static String generateToken(String username) {
        return JWT.create()
        .withSubject(username)
        .withIssuer("spring_boot_web_non_jwt")
        .withIssuedAt(new Date())
        .withExpiresAt(new Date(System.currentTimeMillis() + 86400000))
        .sign(ALGORITHM);
    }

    public static boolean verifyToken(String token) {
        try {
            JWTVerifier verifier = JWT.require(ALGORITHM).withIssuer("spring_boot_web_non_jwt").build();
            DecodedJWT jwt = verifier.verify(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
