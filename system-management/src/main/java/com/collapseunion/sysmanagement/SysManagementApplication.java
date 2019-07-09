package com.collapseunion.sysmanagement;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

/**
 * 系统管理微服务
 *
 * @author CloudSen
 */
@Slf4j
@EnableEurekaClient
@EnableCircuitBreaker
@EnableFeignClients
@EnableSpringDataWebSupport
@SpringBootApplication
public class SysManagementApplication {
    static {
        log.info("======> [ INFO ] Starting system management server...");
    }

    public static void main(String[] args) {
        new SpringApplicationBuilder(SysManagementApplication.class)
                .web(WebApplicationType.SERVLET)
                .run(args);
    }
}
