//package com.example.FarmersFriend.APIGateway;
//
//import org.springframework.cloud.gateway.filter.GatewayFilter;
//import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
//import org.springframework.http.server.reactive.ServerHttpRequest;
//import org.springframework.stereotype.Component;
//
//@Component
//public class JwtForwardingFilter extends AbstractGatewayFilterFactory<JwtForwardingFilter.Config> {
//
//    public JwtForwardingFilter() {
//        super(Config.class);
//    }
//
//    @Override
//    public GatewayFilter apply(Config config) {
//        return (exchange, chain) -> {
//            // Extract the Authorization header from the incoming request
//            String authHeader = exchange.getRequest()
//                .getHeaders()
//                .getFirst("Authorization");
//
//            // If the header exists and is a Bearer token, forward it
//            if (authHeader != null && authHeader.startsWith("Bearer ")) {
//                ServerHttpRequest modifiedRequest = exchange.getRequest()
//                    .mutate()
//                    .header("Authorization", authHeader)
//                    .build();
//
//                return chain.filter(exchange.mutate().request(modifiedRequest).build());
//            }
//
//            // If no token, proceed without modification
//            return chain.filter(exchange);
//        };
//    }
//
//    public static class Config {
//        // Add configuration properties here if needed
//    }
//}