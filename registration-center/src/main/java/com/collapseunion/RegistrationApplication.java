package com.collapseunion;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 注册中心
 *
 * @author CloudSen
 */
@SpringBootApplication
@EnableEurekaServer
@Slf4j
public class RegistrationApplication {
    static {
        log.info("======> [ INFO ] Starting registration server...");
    }

    public static void main(String[] args) {
        new SpringApplicationBuilder(RegistrationApplication.class)
                .web(WebApplicationType.SERVLET)
                .run(args);
    }
}
