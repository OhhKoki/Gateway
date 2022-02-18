package com.example.filter;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Order(value = 1)    // 指定执行顺序，值越小，优先级越高
@Component
public class AuthorizeFilter implements GlobalFilter {

    /**
     * 身份验证
     * @param exchange：请求上下文，里面可以获取Request、Response等信息
     * @param chain：用来把请求委托给下一个过滤器
     * @return 返回标示当前过滤器业务结束
     */
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        // 1. 获取请求参数
        ServerHttpRequest request = exchange.getRequest();
        MultiValueMap<String, String> params = request.getQueryParams();
        String authorization = params.getFirst("authorization");

        // 2. 判断是否相等
        if ("admin".equals(authorization)) {
            // 相等，方形
            return chain.filter(exchange);
        }

        // 3. 不相等，拦截
        exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);    // 设置响应状态吗
        return exchange.getResponse().setComplete();
    }

}
