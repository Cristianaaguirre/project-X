package com.app.gateway.configs;

import lombok.RequiredArgsConstructor;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.cloud.gateway.route.RouteLocator;

@Configuration
@RequiredArgsConstructor
public class GatewayConfig {

   private final AuthFilter filter;

   @Bean
   public RouteLocator routes(RouteLocatorBuilder builder) {
      return builder.routes()
           .route(r -> r.path("/auth/**")
                .filters(f -> f.filter(filter))
                .uri("lb://auth-service"))
           .route(r -> r.path("/tweet/**", "/follow/**")
                .filters(f -> f.filter(filter))
                .uri("lb://user-service"))
           .route(r -> r.path("/usertimeline/**")
                .filters(f -> f.filter(filter))
                .uri("lb://usertimeline-service"))
           .route(r -> r.path("/hometimeline/**")
                .filters(f -> f.filter(filter))
                .uri("lb://hometimeline-service"))
           .build();
   }

}
