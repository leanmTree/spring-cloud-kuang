package com.lemon.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author hengtao.wu
 * @Date 2020/11/4 16:26
 **/
@Configuration
public class GatewayConfig {

 /*   @Bean
    public RouteLocator routeLocatorConsumer(RouteLocatorBuilder routeLocatorBuilder) {
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        routes.route("consumer01", r -> r.path("/consumer/**").uri("lb://consumer80")).build();
        return routes.build();
    }

    @Bean
    public RouteLocator routeLocatorProvider(RouteLocatorBuilder routeLocatorBuilder) {
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        routes.route("provider01", r -> r.path("/provider/**").uri("lb://provider")).build();
        return routes.build();
    }*/
}
