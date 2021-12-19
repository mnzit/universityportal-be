package com.nepalaya.up;

import com.nepalaya.up.constant.SecurityConstant;
import com.nepalaya.up.exception.AuthenticationExceptionImpl;
import com.nepalaya.up.util.JwtUtil;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AuthTokenFilter extends OncePerRequestFilter {

    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {


        String authorizationHeader = request.getHeader(HttpHeaders.AUTHORIZATION);

        if (authorizationHeader == null) {
            throw new AuthenticationExceptionImpl();
        }

        if (authorizationHeader.trim().length() == 0) {
            throw new AuthenticationExceptionImpl();
        }

        if (authorizationHeader.contains(SecurityConstant.JWT_PREFIX)) {
            String token = authorizationHeader.replace(SecurityConstant.JWT_PREFIX, "");
            if (jwtUtil.validate(token)) {
                try {
                    Jwt jwt = jwtUtil.jwt(token);
                    Claims body = (Claims) jwt.getBody();
                    String email =  body.get("email",String.class);

                    UserDetails userDetails = userDetailsService.loadUserByUsername(email);
                    UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                            new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                    usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
                } catch (Exception ex) {
                    throw new AuthenticationExceptionImpl();
                }
            } else {
                throw new AuthenticationExceptionImpl();
            }
        } else {
            throw new AuthenticationExceptionImpl();
        }

        filterChain.doFilter(request, response);
    }

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
        String path = request.getServletPath();
        if (path.equals("/")) {
            return true;
        } else if (path.startsWith("/login")) {
            return true;
        } else {
            return false;
        }
    }
}
