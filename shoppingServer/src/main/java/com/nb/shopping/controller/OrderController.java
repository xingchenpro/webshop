package com.nb.shopping.controller;

import com.nb.shopping.entity.Customer;
import com.nb.shopping.entity.Goods;
import com.nb.shopping.entity.Order;
import com.nb.shopping.entity.Seller;
import com.nb.shopping.service.CustomerService;
import com.nb.shopping.service.OrderService;
import com.nb.shopping.service.SellerService;
import com.nb.shopping.service.UserService;
import com.nb.shopping.util.DateUtil;
import com.nb.shopping.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author :hly
 * @github :https://github.com/huangliangyun
 * @blog :http://www.javahly.com/
 * @CSDN :blog.csdn.net/Sirius_hly
 * @date :2019/1/13
 */

@RestController
@RequestMapping("/")
public class OrderController {

    @Autowired
    UserService userService;

    @Autowired
    OrderService orderService;

    @Autowired
    CustomerService customerService;

    @Autowired
    SellerService sellerService;

    //得到客户所有的订单
    @RequestMapping(value = "/customerAllOrder", produces = {"application/json;charset=UTF-8"})
    public Result getCustomerAllOrder(HttpSession session) {
        Result result = new Result();
        Map<String, Object> data = new HashMap<>();
        Map<String, Object> paramMap = new HashMap<>();
        try {
            int userId = userService.getUserByUsername((String) session.getAttribute("username")).getId();
            paramMap.put("userId", userId);
            List<Order> orders = orderService.getCustomerAllOrder(paramMap);
            data.put("orders", orders);
            result.setResult(data);
        } catch (Exception e) {
            result.setBusErrInfos("查询订单失败!!!");
            e.printStackTrace();
        }
        return result;
    }

    //添加订单
    @RequestMapping(value = "/generateOrder", produces = {"application/json;charset=UTF-8"})
    public Result addOrder(HttpSession session, String goodsId, String count) {
        Result result = new Result();
        Map<String, Object> paramMap = new HashMap<>();
        try {
            int userId = userService.getUserByUsername((String) session.getAttribute("username")).getId();
            paramMap.put("userId", userId);
            List<Customer> customers = customerService.getCustomer(paramMap);
            Customer customer = customers.get(0);
            paramMap.clear();
            paramMap.put("goodsId", goodsId);
            Seller seller = sellerService.getSellerMsgByGoods(paramMap);
            Order order = new Order();
            order.setSellerId(seller.getId());
            order.setCustomerId(customer.getId());
            order.setTime(DateUtil.getCurrentDateString());
            order.setLocation(customer.getAddress());
            order.setStatus(0);
            orderService.addOrder(order);
            int orderId = order.getId();
            paramMap.clear();
            paramMap.put("orderId", orderId);
            paramMap.put("goodsId", goodsId);
            paramMap.put("count", count);
            orderService.addOrderGoods(paramMap);
            paramMap.clear();
            paramMap.put("userId", userId);
            List<Order> orders = orderService.getCustomerAllOrder(paramMap);
            result.setResult(orderId);
        } catch (Exception e) {
            result.setBusErrInfos("添加订单失败!!!");
            e.printStackTrace();
        }
        return result;
    }

    //修改订单状况
    @RequestMapping(value = "/modifyOrderStatus", produces = {"application/json;charset=UTF-8"})
    public Result modifyOrderStatus(String orderId) {
        Result result = new Result();
        Map<String, Object> paramMap = new HashMap<>();
        try {
            paramMap.put("orderId", orderId);
            orderService.updateOrderStatus(paramMap);
        } catch (Exception e) {
            result.setBusErrInfos("修改订单失败!!!");
            e.printStackTrace();
        }
        return result;
    }

}
