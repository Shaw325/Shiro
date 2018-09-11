package com.shaw.util;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @ClassName: MutlipleDataSource
 * @Description: 多数据源的切换
 * @Author Lindsey Shaw
 * @Date 2018/9/1 18:34
 **/
public class MutlipleDataSource extends AbstractRoutingDataSource {

    private static final ThreadLocal<String> dataSourceKey = new ThreadLocal<String>();


    public static void setDataSourceKey(String dataSource){
        dataSourceKey.set(dataSource);
    }


    @Override
    protected Object determineCurrentLookupKey() {
        return dataSourceKey.get();
    }
}
