package com.nb.shopping.service.Impl;

import com.nb.shopping.dao.OrderDao;
import com.nb.shopping.entity.Order;
import com.nb.shopping.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author :hly
 * @github :https://github.com/huangliangyun
 * @blog :http://www.javahly.com/
 * @CSDN :blog.csdn.net/Sirius_hly
 * @date :2019/1/8
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderDao orderDao;

    @Override
    public List<Order> getCustomerAllOrder(Map<String, Object> map) {
        return orderDao.getCustomerAllOrder(map);
    }

    @Override
    public int addOrder(Order order) {
        return orderDao.addOrder(order);
    }

    @Override
    public int addOrderGoods(Map<String, Object> map) {
        return orderDao.addOrderGoods(map);
    }

    @Override
    public int updateOrderStatus(Map<String, Object> map) {
        return orderDao.updateOrderStatus(map);
    }
}
