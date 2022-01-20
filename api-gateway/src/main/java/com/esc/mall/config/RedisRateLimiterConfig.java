package com.esc.mall.config;

import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Mono;

/**
 * 限流策略配置类
 *
 * @author jiaorun
 * @date 2022/1/20 16:01
 **/
@Configuration
public class RedisRateLimiterConfig {

    /**
     * 根据请求参数中的username进行限流
     *
     * @author jiaorun
     * @data 2022/1/20 16:03
     * @return org.springframework.cloud.gateway.filter.ratelimit.KeyResolver
     */
    /*@Bean
    KeyResolver userKeyResolver() {
        return exchange -> Mono.just(exchange.getRequest().getQueryParams().getFirst("username"));
    }*/

    /**
     * 根据访问IP进行限流
     *
     * @author jiaorun
     * @data 2022/1/20 16:04
     * @return org.springframework.cloud.gateway.filter.ratelimit.KeyResolver
     */
    @Bean
    public KeyResolver ipKeyResolver() {
        return exchange -> Mono.just(exchange.getRequest().getRemoteAddress().getHostName());
    }
}
