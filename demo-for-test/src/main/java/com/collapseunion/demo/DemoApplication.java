package com.collapseunion.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

/**
 * 用于测试的微服务
 *
 * @author CloudSen
 */
@Slf4j
@EnableEurekaClient
@EnableFeignClients
@EnableCircuitBreaker
@EnableSpringDataWebSupport
@SpringBootApplication
public class DemoApplication {
    static {
        log.info("======> [ INFO ] Starting demo server...");
    }

    public static void main(String[] args) {
        new SpringApplicationBuilder(DemoApplication.class)
                .web(WebApplicationType.SERVLET)
                .run(args);
    }
}
