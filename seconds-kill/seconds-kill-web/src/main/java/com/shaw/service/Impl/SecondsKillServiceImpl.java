package com.shaw.service.Impl;

import com.shaw.dao.OrderMapper;
import com.shaw.dao.StockMapper;
import com.shaw.pojo.Order;
import com.shaw.pojo.Stock;
import com.shaw.service.SecondsKillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @ClassName: SecondsKillServiceImpl
 * @Description:
 * @Author Lindsey Shaw
 * @Date 2018/9/6
 **/
@Service
@Transactional(rollbackFor = Exception.class)
public class SecondsKillServiceImpl implements SecondsKillService {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private StockMapper stockMapper;

    @Override
    public int killOrder(int sid) {
        //验证库存
        Stock stock = checkStock(sid);

        //扣库存
        saleStock(stock);

        //创建订单
        int id = createOrder(stock);

        return id;
    }

    /**
     * 创建订单
     * @param stock
     * @return
     */
    private int createOrder(Stock stock) {
        Order order = new Order();
        order.setSid(stock.getId());
        order.setName(stock.getName());
        int id = orderMapper.insertSelective(order);
        return id;
    }

    /**
     * 查询商品是否还有剩余
     *
     * @param sid
     * @return
     */
    private Stock checkStock(int sid) {
        Stock stock = stockMapper.getStockByID(sid);
        if (stock.getSale().equals(stock.getCount())) {
            throw new RuntimeException("库存不足");
        } else {
            return stock;
        }
    }

    /**
     * 使用乐观锁修改商品库存
     * @param stock
     */
    private void saleStock(Stock stock) {
        int i = stockMapper.updateStockById(stock);
        if (i == 0) {
            throw new RuntimeException("并发更新库存失败");
        }
    }
}
