package com.nb.shopping.dao;

import com.nb.shopping.entity.Order;

import java.util.List;
import java.util.Map;

/**
 * @author :hly
 * @github :https://github.com/huangliangyun
 * @blog :http://www.javahly.com/
 * @CSDN :blog.csdn.net/Sirius_hly
 * @date :2019/1/8
 */
public interface OrderDao {

    //查询某客户所有订单
    public List<Order> getCustomerAllOrder(Map<String,Object> map);

    //添加订单
    public int addOrder(Order order);

    //添加订单商品
    public int addOrderGoods(Map<String,Object> map);

    //修改订单状态
    public int updateOrderStatus(Map<String,Object> map);


}
