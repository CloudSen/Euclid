package com.collapseunion.turbine;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

/**
 * 对Hystrix集群监控
 *
 * @author CloudSen
 */
@Slf4j
@EnableTurbine
@EnableEurekaClient
@SpringBootApplication
public class TurbineApplication {
    static {
        log.info("======> [ INFO ] Starting turbine server...");
    }

    public static void main(String[] args) {
        new SpringApplicationBuilder(TurbineApplication.class)
                .web(WebApplicationType.SERVLET)
                .run(args);
    }
}
