package com.xha.springcloud.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Date;

    @Component
    @Slf4j
    public class GlobalGatewayLogFilter implements GlobalFilter, Ordered {
        @Override
        public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
            log.info("*******come in GlobalGatewayLogFilter:" + new Date());
            String username = exchange.getRequest().getQueryParams().getFirst("username");
            if (!StringUtils.hasText(username)){
                log.info("用户名为空。");
                exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
                return exchange.getResponse().setComplete();
            }
            return chain.filter(exchange);
        }

        @Override
        public int getOrder() {
            return 0;
        }
    }
