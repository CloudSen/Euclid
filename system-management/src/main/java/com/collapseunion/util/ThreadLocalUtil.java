package com.collapseunion.util;

import com.collapseunion.config.dbconfig.DataSourceRouting;

/**
 * 本地线程资源工具
 *
 * @author CloudSen
 */
public class ThreadLocalUtil {

    private static final ThreadLocal<DataSourceRouting.DbKey> DB_KEY = new ThreadLocal<>();

    public static DataSourceRouting.DbKey getDbKey() {
        return DB_KEY.get() == null ? DataSourceRouting.DbKey.DEV : DB_KEY.get();
    }

    public static void setDbKey(DataSourceRouting.DbKey dbKey) {
        DB_KEY.set(dbKey);
    }

    public static void clearDbKey() {
        DB_KEY.remove();
    }
}

