package com.shaw.aspect;

import com.shaw.annotation.MySQLDataBase;
import com.shaw.annotation.OracleDataBase;
import com.shaw.util.MutlipleDataSource;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @ClassName: MutliDataSourceAdvice
 * @Description:
 * @Author Lindsey Shaw
 * @Date 2018/9/2 2:29
 **/

@Component
@Aspect
@Order(1)
public class MutliDataSourceAdvice {

    private final static Logger logger = LoggerFactory.getLogger(MutliDataSourceAdvice.class);

    /**
     * 验证是否根据注解切换数据源
     *
     * @param joinPoint
     * @return
     */
    @Around("execution(* com.shaw.service..*.*(..))")
    public Object doAround(ProceedingJoinPoint joinPoint) {

        Object aThis = joinPoint.getTarget();
        boolean mysql = aThis.getClass().isAnnotationPresent(MySQLDataBase.class);
        boolean oracle = aThis.getClass().isAnnotationPresent(OracleDataBase.class);

        //当使用注解不是mysql注解时，切换到oracle
        if (mysql) {
            MutlipleDataSource.setDataSourceKey("MySQLDataSource");
            logger.info("使用MySQL数据库");
        } else if (oracle) {
            MutlipleDataSource.setDataSourceKey("OracleDataSource");
            logger.info("使用Oracle数据库");
        }
        try {
            return joinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return null;
    }
}
