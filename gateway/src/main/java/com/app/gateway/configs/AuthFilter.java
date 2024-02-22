package com.app.gateway.configs;

import com.app.gateway.service.JwtProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@RefreshScope
@Component
@RequiredArgsConstructor
public class AuthFilter implements GatewayFilter {

   private final JwtProvider provider;
   private final RouterValidator validator;

   @Override
   public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

      ServerHttpRequest request = exchange.getRequest();

      if(validator.isSecured.test(request)) {

         if (authMissing(request))
            return onError(exchange);

         String token = request.getHeaders().getOrEmpty(HttpHeaders.AUTHORIZATION).get(0);
         String[] chunks = token.split(" ");

         if(chunks.length != 2 || !chunks[0].startsWith("Bearer") || provider.isExpired(chunks[1]))
            return onError(exchange);

      }

      return chain.filter(exchange);
   }

   private Mono<Void> onError(ServerWebExchange exchange) {
      ServerHttpResponse response = exchange.getResponse();
      response.setStatusCode(HttpStatus.UNAUTHORIZED);
      return response.setComplete();
   }

   private boolean authMissing(ServerHttpRequest request) {
      return !request.getHeaders().containsKey(HttpHeaders.AUTHORIZATION);
   }

}
