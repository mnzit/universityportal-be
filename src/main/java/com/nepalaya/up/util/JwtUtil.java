package com.nepalaya.up.util;

import com.nepalaya.up.model.User;
import io.jsonwebtoken.*;
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
        claims.put("status", user.getStatus());
        claims.put("role", user.getRole().getName());
        String authorities = user
                .getAuthorities()
                .stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(","));
        claims.put("authorities", authorities);
        claims.put("email", user.getEmailAddress());

        return Jwts
                .builder()
                .setSubject(user.getEmailAddress())
                .setClaims(claims)
                .setIssuedAt(issueDate)
                .setExpiration(expiryDate)
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
    }

    public boolean validate(String token) {
        try {
            Jwts
                    .parser()
                    .setSigningKey(secretKey)
                    .parse(token);
            return true;
        } catch (Exception ex) {
            LogUtil.exception(ex);
            return false;
        }
    }

    public Jws<Claims> getData(String token){
        return Jwts
                .parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(token);
    }


}
