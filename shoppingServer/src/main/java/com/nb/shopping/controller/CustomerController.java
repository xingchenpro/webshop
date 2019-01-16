package com.nb.shopping.controller;

import com.nb.shopping.entity.Goods;
import com.nb.shopping.service.CustomerService;
import com.nb.shopping.service.GoodsService;
import com.nb.shopping.service.UserService;
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
 * @date :2019/1/11
 */
@RestController
@RequestMapping("/")
public class CustomerController {

    @Autowired
    UserService userService;

    @Autowired
    GoodsService goodsService;

    @Autowired
    CustomerService customerService;

    //得到某商家的全部商品
    @RequestMapping(value = "/sellerAllGoods", produces = {"application/json;charset=UTF-8"})
    public Result getSellerAnotherGoods(String sellerId) {
        Result result = new Result();
        Map<String, Object> paramMap = new HashMap<>();
        Map<String, Object> data = new HashMap<>();
        paramMap.put("goodsCheck", 1);
        paramMap.put("sellerId", sellerId);
        try {
            List<Goods> goods = goodsService.getSellerAllGoods(paramMap);
            data.put("goods",goods);
            result.setResult(data);
        } catch (Exception e) {
            result.setBusErrInfos("查询其余失败!!!");
            e.printStackTrace();
        }
        return result;
    }

    //得到某商家该条商品以及全部商品
    @RequestMapping(value = "/goodsDetails", produces = {"application/json;charset=UTF-8"})
    public Result getGoodsDetails(String sellerId,String goodsId) {
        Result result = new Result();
        Map<String, Object> data = new HashMap<>();
        Map<String, Object> paramMap = new HashMap<>();
        try {
            paramMap.put("sellerId", sellerId);
            paramMap.put("goodsId", goodsId);
            List<Goods> goodsDetails = goodsService.getSellerGoods(paramMap);
            paramMap.clear();
            paramMap.put("goodsCheck", 1);
            paramMap.put("sellerId", sellerId);
            List<Goods> goods = goodsService.getSellerAllGoods(paramMap);
            data.put("goodsDetails",goodsDetails);
            data.put("goods",goods);
            result.setResult(data);
        } catch (Exception e) {
            result.setBusErrInfos("查询该商品失败!!!");
            e.printStackTrace();
        }
        return result;
    }

    //判断用户是否登录
    @RequestMapping(value = "/isLogin", produces = {"application/json;charset=UTF-8"})
    public Result isLogin(HttpSession session) {
        Result result = new Result();
        Map<String, Object> paramMap = new HashMap<>();
        if(session.getAttribute("username")==null) {
            result.setBusErrInfos("您尚未登录!!!");
        }else{
            int userId = userService.getUserByUsername((String) session.getAttribute("username")).getId();
            paramMap.put("userId",userId);
            result.setResult(customerService.getCustomer(paramMap));
        }
        return result;
    }
}
