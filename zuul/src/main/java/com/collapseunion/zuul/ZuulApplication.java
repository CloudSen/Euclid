package com.collapseunion.zuul;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulServer;

/**
 * API路由
 *
 * @author CloudSen
 */
@Slf4j
@EnableEurekaClient
@EnableZuulServer
@SpringBootApplication
public class ZuulApplication {
    static {
        log.info("======> [ INFO ] Starting demo server...");
    }

    public static void main(String[] args) {
        new SpringApplicationBuilder(ZuulApplication.class)
                .web(WebApplicationType.SERVLET)
                .run(args);
    }
}
