package com.app.postservice.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.Map;
import java.util.function.Function;

@Component
public class JwtProviderImpl implements JwtProvider{

   @Value("${jwt.secretKey}")
   private String SECRET_KEY;

   private SecretKey key;

   @PostConstruct
   protected void init() {
      this.key = Keys.hmacShaKeyFor(Decoders.BASE64.decode(this.SECRET_KEY));
   }

   private Claims extractAllClaims(String token) {
      try {
         return Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token).getBody();
      } catch (Exception e) {
         throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
      }
   }

   private  <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
      final Claims claims = extractAllClaims(token);
      return claimsResolver.apply(claims);
   }

   private Boolean isTokenExpired(String token) {
      return extractClaim(token, Claims::getExpiration).before(new Date());
   }


}
