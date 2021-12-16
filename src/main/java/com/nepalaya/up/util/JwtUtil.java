package com.nepalaya.up.util;

import com.nepalaya.up.model.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class JwtUtil {

    public static String generateToken(UserDetails userDetails){
        User user = (User) userDetails;
        Date issueDate = new Date();
        Date expiryDate = new Date(issueDate.getTime()+600000);
        String secretKey = "mbA7W_&3Gg'a'{.Z!@4724:%=rF.YjuA";

        Map<String, Object> claims = new HashMap<>();
        claims.put("role", user.getRole().getName());
        claims.put("authorities", user
                .getRole()
                .getRoleAuthorities()
                .stream()
                .map(
                        roleAuthority -> roleAuthority
                                .getAuthority()
                                .getName()
                ).collect(Collectors.joining(","))
        );
        return Jwts
                .builder()
                .setSubject(
                        new StringBuilder()
                                .append(user.getFirstName())
                                .append(" ")
                                .append(user.getLastName())
                                .toString()
                )
                .setClaims(claims)
                .setIssuedAt(new Date())
                .setExpiration(expiryDate)
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();


    }
}
