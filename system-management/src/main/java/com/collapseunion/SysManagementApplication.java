package com.collapseunion;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 系统管理微服务
 *
 * @author CloudSen
 */
@SpringBootApplication
@EnableEurekaClient
@Slf4j
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
