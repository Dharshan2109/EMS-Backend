package com.example.ems_backend.security;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import java.security.Key;
import java.util.Date;
import org.springframework.stereotype.Component;

@Component
public class JwtUtil {

    private final String SECRET =
            "mysecretkeymysecretkeymysecretkeymysecretkey";

    public String generateToken(String username){

        Key key=Keys.hmacShaKeyFor(
                SECRET.getBytes());

        return Jwts.builder()
                .subject(username)
                .issuedAt(new Date())
                .expiration(
                        new Date(
                                System.currentTimeMillis()
                                        +86400000))
                .signWith(key)
                .compact();
    }

    public String extractUsername(
            String token){

        Key key=
                Keys.hmacShaKeyFor(
                        SECRET.getBytes());

        return Jwts.parser()
                .verifyWith(
                        (javax.crypto.SecretKey)key)
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .getSubject();
    }
}

