package com.lemon.gateway.config;

import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @author hengtao.wu
 * @Date 2020/11/9 10:43
 **/
public class GatewayLimitConfig implements KeyResolver {
    @Override
    public Mono<String> resolve(ServerWebExchange exchange) {
        //通过host地址来限流，
        return Mono.just(exchange.getRequest().getRemoteAddress().getAddress().getHostAddress());
    }

    //注入到spring容器中
    @Bean(name = "gatewayLimitConfig")
    public GatewayLimitConfig hostAddrKeyResolver() {
        return new GatewayLimitConfig();
    }
}
