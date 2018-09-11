package com.shaw.dao;

import com.shaw.pojo.Stock;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName: StockMapper
 * @Description:
 * @Author Lindsey Shaw
 * @Date 2018/9/6
 **/
public interface StockMapper {


    Stock getStockByID(@Param("sid") int sid);

    int updateStockById(Stock stock);
}
