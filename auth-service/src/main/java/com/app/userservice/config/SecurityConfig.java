package com.app.userservice.config;

import com.app.userservice.common.security.filter.JwtFilter;
import com.app.userservice.common.security.util.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@RequiredArgsConstructor
public class SecurityConfig {

   private final JwtFilter filter;

   @Bean
   public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
      http
           .authorizeHttpRequests(auth -> auth
                .requestMatchers(HttpMethod.POST, "/auth/register", "/auth/login").permitAll()
                .requestMatchers(HttpMethod.GET, "/auth/1").permitAll()
                .requestMatchers(HttpMethod.GET, "/auth/2").hasAuthority(Role.USER.name())
                .anyRequest().authenticated())
           .csrf(AbstractHttpConfigurer::disable)
           .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
           .addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);

      return http.build();
   }

}