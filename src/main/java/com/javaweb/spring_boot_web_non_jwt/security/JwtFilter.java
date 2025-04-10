package com.javaweb.spring_boot_web_non_jwt.security;

import java.io.IOException;
import java.util.Collections;
import java.util.Map;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.auth0.jwt.interfaces.Claim;
import com.javaweb.spring_boot_web_non_jwt.dto.common.UserCredential;

import lombok.RequiredArgsConstructor;

import static com.javaweb.spring_boot_web_non_jwt.constants.Constant.*;

@Component
@RequiredArgsConstructor
public class JwtFilter extends OncePerRequestFilter {

    private final JwtUtil jwtUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws ServletException, IOException {

        String authHeader = request.getHeader("Authorization");
        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            String token = authHeader.substring(7);

            if (jwtUtil.verifyToken(token) && SecurityContextHolder.getContext().getAuthentication() == null) {
                Map<String, Claim> claims = jwtUtil.decodeToken(token);
                String username = claims.get("username").asString();
                UserDetails userDetails = User.withUsername(username)
                                  .password("")
                                  .authorities(Collections.emptyList())
                                  .build();
                UsernamePasswordAuthenticationToken authToken =
                        new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());

                authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authToken);
            }
        }

        chain.doFilter(request, response);
    }
}
