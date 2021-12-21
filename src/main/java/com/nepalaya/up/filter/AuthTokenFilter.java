package com.nepalaya.up.filter;

import com.nepalaya.up.constant.ApiConstant;
import com.nepalaya.up.constant.LogConstant;
import com.nepalaya.up.constant.SecurityConstant;
import com.nepalaya.up.exception.AuthenticationFailedException;
import com.nepalaya.up.util.JwtUtil;
import com.nepalaya.up.util.LogUtil;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
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

    private final JwtUtil jwtUtil;
    private final UserDetailsService userDetailsService;


    public AuthTokenFilter(JwtUtil jwtUtil, UserDetailsService userDetailsService) {
        this.jwtUtil = jwtUtil;
        this.userDetailsService = userDetailsService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String authorizationHeader = request.getHeader(HttpHeaders.AUTHORIZATION);

        if (authorizationHeader == null) {
            LogUtil.exception(LogConstant.AUTH_HEADER_DOESNT_EXIST);
            throw new AuthenticationFailedException();
        }

        if (authorizationHeader.trim().length() == 0) {
            LogUtil.exception(LogConstant.AUTH_PREFIX_DOESNT_EXIST);
            throw new AuthenticationFailedException();
        }

        if (authorizationHeader.contains(SecurityConstant.JWT_PREFIX)) {
            String token = authorizationHeader.replace(SecurityConstant.JWT_PREFIX, "");
            if (token.length() == 0) {
                LogUtil.exception(LogConstant.AUTH_PREFIX_DOESNT_EXIST);
                throw new AuthenticationFailedException();
            }
            if (jwtUtil.validate(token)) {
                try {
                    Jws<Claims> jwt = jwtUtil.getData(token);
                    Claims body = jwt.getBody();
                    String email = body.get("email", String.class);

                    UserDetails userDetails = userDetailsService.loadUserByUsername(email);

                    // This sets authentication to true
                    UsernamePasswordAuthenticationToken authenticationToken =
                            new UsernamePasswordAuthenticationToken(
                                    userDetails,
                                    userDetails.getPassword(),
                                    userDetails.getAuthorities()
                            );

                    authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    // Setting the authenticated user in the Thread-local
                    SecurityContextHolder.getContext().setAuthentication(authenticationToken);
                } catch (Exception ex) {
                    LogUtil.exception(LogConstant.AUTH_HEADER_INVALID);
                    throw new AuthenticationFailedException();
                }
            } else {
                LogUtil.exception(LogConstant.AUTH_HEADER_INVALID);
                throw new AuthenticationFailedException();
            }
        } else {
            LogUtil.exception(LogConstant.AUTH_PREFIX_DOESNT_EXIST);
            throw new AuthenticationFailedException();
        }

        filterChain.doFilter(request, response);
    }

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) {
        String path = request.getServletPath();
        // Returns true if it shouldn't filter
        for (String url : ApiConstant.UNSECURE) {
            if (path.equals(url)) return true;
        }
        return false;
    }
}
