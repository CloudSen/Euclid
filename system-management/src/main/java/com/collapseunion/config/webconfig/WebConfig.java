package com.collapseunion.config.webconfig;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Spring mvc 相关配置
 *
 * @author CloudSen
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    /**
     * 简单的路由
     *
     * @param registry ViewControllerRegistry注册器
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
    }
}
