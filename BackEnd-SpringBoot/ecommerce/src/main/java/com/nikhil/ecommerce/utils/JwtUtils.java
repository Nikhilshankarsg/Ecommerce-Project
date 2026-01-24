package com.nikhil.ecommerce.utils;

import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.nikhil.ecommerce.exception.JwtExpiredException;
import com.nikhil.ecommerce.exception.JwtInvalidException;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

@Component
public class JwtUtils {

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private long expiration;

    // 🔐 Create signing key from secret
    private SecretKey getSigningKey() {
        return Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));
    }
    
    public List<GrantedAuthority> getAuthorities(String token) {
        // extract role from token
        String role = extractRole(token);  // e.g., "USER", "ADMIN"

        // convert role to GrantedAuthority
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority("ROLE_" + role);

        return Collections.singletonList(authority);
    }

    // ✅ Generate JWT Token
    public String generateToken(String email, String role) {
        return Jwts.builder()
                .setSubject(email)                    // username
                .claim("role", role)
                .setIssuedAt(new Date())                 // token creation time
                .setExpiration(new Date(System.currentTimeMillis() + expiration)) // expiry
                .signWith(getSigningKey(), SignatureAlgorithm.HS256) // sign token
                .compact();
    }

    // ✅ Validate JWT Token (Signature + Expiry)
    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder()
                .setSigningKey(getSigningKey())
                .build()
                .parseClaimsJws(token); // validates token
            return true;
        } catch (ExpiredJwtException e) {
            throw new JwtExpiredException("JWT Token has expired");
        } catch (JwtException e) {
            throw new JwtInvalidException("Invalid JWT Token");
        }
    }

    // ✅ Extract Username from JWT Token
    public String extractEmail(String token) {
        return extractAllClaims(token).getSubject();
    }

    // ✅ Extract token expiration date
    public Date extractExpiration(String token) {
        return extractAllClaims(token).getExpiration();
    }
    
    public String extractRole(String token) {
        return (String) extractAllClaims(token).get("role");
    }


    // 🔍 Extract all claims
    private Claims extractAllClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(getSigningKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
}
