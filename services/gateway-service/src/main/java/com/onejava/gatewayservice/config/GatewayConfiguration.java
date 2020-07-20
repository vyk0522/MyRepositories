package com.onejava.gatewayservice.config;

import com.onejava.gatewayservice.filter.AddRequestHeaderFilter;
import com.onejava.gatewayservice.filter.ZuulLoggerFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfiguration {
    @Bean
    public AddRequestHeaderFilter addRequestHeaderFilter() {
        return new AddRequestHeaderFilter();
    }

    @Bean
    public ZuulLoggerFilter loggerFilter(){
        return new ZuulLoggerFilter();
    }

}
