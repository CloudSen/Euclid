package com.collapseunion.config.dbconfig;

import com.collapseunion.util.ThreadLocalUtil;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * 动态切换数据源
 *
 * @author CloudSen
 */
public class DataSourceRouting extends AbstractRoutingDataSource {

    public enum DbKey {
        /**
         * 开发库
         */
        DEV,
        /**
         * 测试库
         */
        TEST,
        /**
         * 线上库
         */
        PROD,
        ;
    }

    @Override
    protected Object determineCurrentLookupKey() {
        return ThreadLocalUtil.getDbKey();
    }
}

