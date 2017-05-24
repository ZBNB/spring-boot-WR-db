
package com.example.demo.conf.mybatis;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * 拦截设置本地线程变量
 * @author sysadmin
 *
 */
@Aspect
@Component
@Slf4j
public class DataSourceAOP {
    @Before("execution(* com.example.demo.mapper..*.select*(..)) || execution(* com.example.demo.mapper..*.get*(..))"
    		+ " || execution(* com.example.demo.mapper..*.find*(..))")
    public void setReadDataSourceType() {
        DataSourceContextHolder.read();
        log.info("dataSource切换到：Read");
    }

    @Before("execution(* com.example.demo.mapper..*.insert*(..)) || execution(* com.example.demo.mapper..*.update*(..))")
    public void setWriteDataSourceType() {
        DataSourceContextHolder.write();
        log.info("dataSource切换到：write");
    }
}

