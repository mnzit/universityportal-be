package com.nepalaya.up.util;

import com.nepalaya.up.model.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class JwtUtil {

    @Value("${jwt.expiresInMinute}")
    private Long expiresInMinute;

    @Value("${jwt.secretKey}")
    private String secretKey;

    public String generateToken(UserDetails userDetails) {
        User user = (User) userDetails;
        Date issueDate = new Date();
        Date expiryDate = new Date(issueDate.getTime() + expiresInMinute * 60 * 1000);

        Map<String, Object> claims = new HashMap<>();
        claims.put("id", user.getId());
        claims.put("status", user.getStatus());
        claims.put("role", user.getRole().getName());
        claims.put("authorities", user
                .getAuthorities()
                .stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(",")
                )
        );

        return Jwts
                .builder()
                .setSubject(user.getFullName())
                .setClaims(claims)
                .setIssuedAt(new Date())
                .setExpiration(expiryDate)
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
    }
}
