package com.revature.hikingbuddy.services;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Value;

import org.springframework.stereotype.Service;

import com.revature.hikingbuddy.dtos.responses.Principal;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class TokenService {
    @Value("${jwt.secret}")
    private String SECRET_KEY;

    public String generateToken(Principal userprincipal)
    {
        Map<String, Object> claims = new HashMap<>();
        claims.put("id", userprincipal.getId());
        claims.put("role", userprincipal.getRole());

        return Jwts.builder()
               .setClaims(claims)
               .setSubject(userprincipal.getUsername())
               .setIssuedAt(new Date(System.currentTimeMillis()))
               .setExpiration(new Date(System.currentTimeMillis() + 1000 *60 * 60 * 10))
               .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
               .compact();
    }

    public boolean validateToken(String token, Principal userPrincipal)
    {
        String tokenUsername = extractUsername(token);
        return tokenUsername.equals(userPrincipal.getUsername());
    }

    public String extractUsername(String token)
    {
        return extractClaim(token, Claims::getSubject);
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver)
    {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    public String extractUserId(String token)
    {
        return (String) extractAllClaims(token).get("id");
    }

    public String extractUserRole(String token)
    {
        return (String) extractAllClaims(token).get("role");
    }

    private Claims extractAllClaims(String token)
    {
        return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
    }
}
