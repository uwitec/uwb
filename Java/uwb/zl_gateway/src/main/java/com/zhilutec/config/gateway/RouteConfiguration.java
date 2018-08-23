package com.zhilutec.config.gateway;

import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.discovery.DiscoveryClientRouteDefinitionLocator;
import org.springframework.cloud.gateway.discovery.DiscoveryLocatorProperties;
import org.springframework.cloud.gateway.route.RouteDefinitionLocator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.cors.reactive.CorsUtils;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;

@EnableDiscoveryClient
@Configuration
public class RouteConfiguration {
    //这里为支持的请求头，如果有自定义的header字段请自己添加（不知道为什么不能使用*）
    // private static final String ALLOWED_HEADERS = "x-requested-with, authorization, Content-Type, Authorization, credential, X-XSRF-TOKEN,token,username,client";
    // private static final String ALLOWED_METHODS = "*";
    // private static final String ALLOWED_ORIGIN = "*";
    // private static final String ALLOWED_Expose = "*";
    // private static final String MAX_AGE = "18000L";

    // @Bean
    // public WebFilter corsFilter() {
    //     return (ServerWebExchange ctx, WebFilterChain chain) -> {
    //         ServerHttpRequest request = ctx.getRequest();
    //         if (CorsUtils.isCorsRequest(request)) {
    //             ServerHttpResponse response = ctx.getResponse();
    //             HttpHeaders headers = response.getHeaders();
    //             headers.add("Access-Control-Allow-Origin", ALLOWED_ORIGIN);
    //             headers.add("Access-Control-Allow-Methods", ALLOWED_METHODS);
    //             headers.add("Access-Control-Max-Age", MAX_AGE);
    //             headers.add("Access-Control-Allow-Headers", ALLOWED_HEADERS);
    //             headers.add("Access-Control-Expose-Headers", ALLOWED_Expose);
    //             headers.add("Access-Control-Allow-Credentials", "true");
    //             if (request.getMethod() == HttpMethod.OPTIONS) {
    //                 response.setStatusCode(HttpStatus.OK);
    //                 return Mono.empty();
    //             }
    //         }
    //         return chain.filter(ctx);
    //     };
    // }


    // @Bean
    // public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
    //     RouteLocator routeLocator = builder.routes()
    //             .route("restfull_route2", r -> r.path("/uwb/resources/**")
    //                     .uri("http://192.168.10.232:80"))
    //             .route("websocket_route2", r -> r.path("/uwb/websocket/**")
    //                     .uri("http://192.168.10.232:80"))
    //             .build();
    //     return routeLocator;
    // }

    // @Bean
    // RedisRateLimiter redisRateLimiter() {
    //     return new RedisRateLimiter(1, 2);
    // }


    @Bean
    public DiscoveryLocatorProperties discoveryLocatorProperties() {
        return new DiscoveryLocatorProperties();
    }


    /**
     *
     *如果使用了注册中心（如：Eureka），进行控制则需要增加如下配置,从eureka获取路由
     */
    @Bean
    public RouteDefinitionLocator discoveryClientRouteDefinitionLocator(DiscoveryClient discoveryClient, DiscoveryLocatorProperties properties) {
        return new DiscoveryClientRouteDefinitionLocator(discoveryClient, properties);
    }


}