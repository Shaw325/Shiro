package com.shaw.dao;

import com.shaw.pojo.Order;

/**
 * @ClassName: OrderMapper
 * @Description:
 * @Author Lindsey Shaw
 * @Date 2018/9/6
 **/
public interface OrderMapper {

    int insertSelective(Order order);
}
