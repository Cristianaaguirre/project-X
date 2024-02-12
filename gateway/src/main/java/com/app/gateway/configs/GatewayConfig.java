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
           .route(r -> r.path("")
                .filters(f -> f.filter(filter))
                .uri(""))
           .build();
   }

}
