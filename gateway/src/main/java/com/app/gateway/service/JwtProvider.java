package com.app.gateway.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.security.Key;
import java.util.Date;

@Service
public class JwtProvider {

   @Value("${jwt.secretKey}")
   private String secret;

   private Key key;

   @PostConstruct
   public void initKey() {
      this.key = Keys.hmacShaKeyFor(Decoders.BASE64.decode(this.secret));
   }

   public Claims getClaims(String token) {
      try {
         return Jwts.parserBuilder()
              .setSigningKey(key)
              .build()
              .parseClaimsJws(token)
              .getBody();
      } catch (Exception e) {
         throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, e.getMessage());
      }
   }

   public Boolean isExpired(String token) {
      return getClaims(token).getExpiration().before(new Date());
   }

}
