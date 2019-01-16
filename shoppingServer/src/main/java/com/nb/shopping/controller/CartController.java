package com.nb.shopping.controller;

import com.nb.shopping.entity.Cart;
import com.nb.shopping.entity.Customer;
import com.nb.shopping.entity.Seller;
import com.nb.shopping.service.*;
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
public class CartController {

    @Autowired
    UserService userService;

    @Autowired
    OrderService orderService;

    @Autowired
    CustomerService customerService;

    @Autowired
    SellerService sellerService;

    @Autowired
    CartService cartService;

    //得到客户所有的购物车信息
    @RequestMapping(value = "/customerAllCart", produces = {"application/json;charset=UTF-8"})
    public Result getCustomerAllCart(HttpSession session) {
        Result result = new Result();
        Map<String, Object> data = new HashMap<>();
        Map<String, Object> paramMap = new HashMap<>();
        try {
            int userId = userService.getUserByUsername((String) session.getAttribute("username")).getId();
            System.err.println("userId:" + userId);
            paramMap.put("userId", userId);
            List<Cart> carts = cartService.getCustomerAllCart(paramMap);
            data.put("carts", carts);
            result.setResult(data);
        } catch (Exception e) {
            result.setBusErrInfos("查询购物车信息失败!!!");
            e.printStackTrace();
        }
        return result;
    }

    //添加购物车
    @RequestMapping(value = "/addCart", produces = {"application/json;charset=UTF-8"})
    public Result addCart(HttpSession session, String goodsId, String count) {
        Result result = new Result();
        Map<String, Object> data = new HashMap<>();
        Map<String, Object> paramMap = new HashMap<>();
        try {
            int userId = userService.getUserByUsername((String) session.getAttribute("username")).getId();
            paramMap.put("userId", userId);
            List<Customer> customers = customerService.getCustomer(paramMap);
            Customer customer = customers.get(0);
            paramMap.clear();
            paramMap.put("goodsId", goodsId);
            Seller seller = sellerService.getSellerMsgByGoods(paramMap);
            Cart cart = new Cart();
            cart.setCustomerId(customer.getId());
            cart.setSellerId(seller.getId());
            cartService.addCart(cart);
            int cartId = cart.getCartId();
            paramMap.clear();
            paramMap.put("cartId", cartId);
            paramMap.put("goodsId", goodsId);
            paramMap.put("count", count);
            cartService.addCartGoods(paramMap);
            paramMap.clear();
            paramMap.put("userId", userId);
            data.put("carts", cartService.getCustomerAllCart(paramMap));
            result.setResult(data);
        } catch (Exception e) {
            result.setBusErrInfos("添加购物车失败!!!");
            e.printStackTrace();
        }
        return result;
    }

    @RequestMapping(value = "/modifyCartGoodsCount", produces = {"application/json;charset=UTF-8"})
    public Result modifyCartGoodsCount(HttpSession session, String cartId, String goodsId, String status) {
        Result result = new Result();
        Map<String, Object> data = new HashMap<>();
        Map<String, Object> paramMap = new HashMap<>();
        try {
            paramMap.put("cartId", cartId);
            paramMap.put("goodsId", goodsId);
            paramMap.put("status", status);
            cartService.updateCartGoodsCount(paramMap);
            paramMap.clear();
            int userId = userService.getUserByUsername((String) session.getAttribute("username")).getId();
            System.err.println("userId:" + userId);
            paramMap.put("userId", userId);
            List<Cart> carts = cartService.getCustomerAllCart(paramMap);
            data.put("carts", carts);
            result.setResult(data);
        } catch (Exception e) {
            result.setBusErrInfos("修改商品数量信息失败!!!");
            e.printStackTrace();
        }
        return result;
    }

}
