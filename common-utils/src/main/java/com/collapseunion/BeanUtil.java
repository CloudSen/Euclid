package com.collapseunion;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * 用于普通类获取Spring Bean
 *
 * @author CloudSen
 */
@Component
public class BeanUtil {

    private static ApplicationContext applicationContext;

    public BeanUtil(ApplicationContext applicationContext) {
        BeanUtil.applicationContext = applicationContext;
    }

    public static <T> T getBean(Class<T> beanClass) {
        return BeanUtil.applicationContext.getBean(beanClass);
    }
}
