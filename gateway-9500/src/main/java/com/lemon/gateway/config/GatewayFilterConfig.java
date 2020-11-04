package com.lemon.gateway.config;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.RequestPath;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @author hengtao.wu
 * @Date 2020/11/4 16:54
 **/
@Component
public class GatewayFilterConfig implements GlobalFilter, Ordered {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

        System.out.println("拦截器拦截到了请求，url:" + exchange.getRequest().getPath());
        RequestPath path = exchange.getRequest().getPath();
        //白名单直接放行
        if("/pro/provider/user/getById".equals(path.toString())) {
            return chain.filter(exchange);
        }
        //获取request对象并获取header中传递的token值
        String token = exchange.getRequest().getHeaders().getFirst("token");
        if(StringUtils.isEmpty(token)) {
            //当token为空时，设置响应码，并返回response
            exchange.getResponse().setStatusCode(HttpStatus.NOT_FOUND);
            return exchange.getResponse().setComplete();
        }
        //当token验证通过，传递给下一个filter链。如果没有下一个，直接放行。
        //通过.then的内部类实现了拦截post设置，将会在请求结束后，执行
        return chain.filter(exchange).then(
                Mono.fromRunnable(() -> {
                    System.out.println("访问结束");
                })
        );
    }
    /**
     *可以设置多个filter，数值越小，优先级越高
     */
    @Override
    public int getOrder() {
        return 0;
    }
}
