package com.microservice.user.util;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.microservice.user.UserConstants;
import com.microservice.user.entity.User;
import com.microservice.user.response.UserResponseDto;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jakarta.servlet.http.HttpServletRequest;

@Component
public class JwtUtil {
    private final String secret_key = "bvkSecretKey";
    private long accessTokenValidity = 60*60*1000;

    private final JwtParser jwtParser;
    
    public JwtUtil(){
        this.jwtParser = Jwts.parser().setSigningKey(secret_key);
    }

    public String createToken(UserResponseDto user) {
        Claims claims = Jwts.claims().setSubject(user.getUsername());
        claims.put("email",user.getEmail());
        claims.put("firstname",user.getFirstname());
        claims.put("lastname",user.getLastname());
        Date tokenCreateTime = new Date();
        Date tokenValidity = new Date(tokenCreateTime.getTime() + TimeUnit.MINUTES.toMillis(accessTokenValidity));
        return Jwts.builder()
                .setClaims(claims)
                .setExpiration(tokenValidity)
                .signWith(SignatureAlgorithm.HS256, secret_key)
                .compact();
    }

    private Claims parseJwtClaims(String token) {
        return jwtParser.parseClaimsJws(token).getBody();
    }

    public Claims resolveClaims(HttpServletRequest req) {
        try {
            String token = resolveToken(req);
            if (token != null) {
                return parseJwtClaims(token);
            }
            return null;
        } catch (ExpiredJwtException ex) {
            req.setAttribute("expired", ex.getMessage());
            throw ex;
        } catch (Exception ex) {
            req.setAttribute("invalid", ex.getMessage());
            throw ex;
        }
    }

    public String resolveToken(HttpServletRequest request) {
        String bearerToken = request.getHeader(UserConstants.TOKEN_HEADER);
        if (bearerToken != null && bearerToken.startsWith(UserConstants.TOKEN_PREFIX)) {
        	bearerToken = bearerToken.substring(UserConstants.TOKEN_PREFIX.length());
        	
        	if(bearerToken.length() > 0) return bearerToken;
        	else return null;
        }
        return null;
    }

    public boolean validateClaims(Claims claims) throws AuthenticationException {
        try {
            return claims.getExpiration().after(new Date());
        } catch (Exception e) {
            throw e;
        }
    }

    public String getUsername(Claims claims) {
        return claims.getSubject();
    }

    private List<String> getRoles(Claims claims) {
        return (List<String>) claims.get("roles");
    }

}
