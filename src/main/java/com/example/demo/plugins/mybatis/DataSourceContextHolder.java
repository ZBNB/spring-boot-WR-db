package com.example.demo.plugins.mybatis;

import lombok.extern.slf4j.Slf4j;

/**
 * 本地线程全局变量
 * @author sysadmin
 *
 */
@Slf4j
public class DataSourceContextHolder  {
    private static final ThreadLocal<String> local = new ThreadLocal<String>();

    public static ThreadLocal<String> getLocal() {
        return local;
    }

    /**
     * 读可能是多个库
     */
    public static void read() {

        local.set(DataSourceType.read.getType());
    }

    /**
     * 写只有一个库
     */
    public static void write() {
        log.info("writewritewrite");
        local.set(DataSourceType.write.getType());
    }

    public static String getJdbcType() {
        return local.get();
    }
}
