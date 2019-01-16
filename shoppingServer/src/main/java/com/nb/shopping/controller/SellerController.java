package com.nb.shopping.controller;

import com.nb.shopping.entity.Goods;
import com.nb.shopping.service.SellerService;
import com.nb.shopping.service.UserService;
import com.nb.shopping.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
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
public class SellerController {

    @Autowired
    UserService userService;

    @Autowired
    SellerService sellerService;

    //添加商品
    @RequestMapping(value = "/addSellerGoods", produces = {"application/json;charset=UTF-8"})
    public Result addSellerGoods(String goodsId, HttpSession session) {
        Result result = new Result();
        Map<String, Object> paramMap = new HashMap<>();
        Map<String, Object> data = new HashMap<>();
        List<Goods> canSellGoods = new ArrayList<>();
        int sellerId = userService.getUserByUsername((String) session.getAttribute("username")).getId();
        try {
            paramMap.put("sellerId", sellerId);
            paramMap.put("goodsId", goodsId);
            paramMap.put("goodsCheck", 1);
            sellerService.addSellerGoods(paramMap);
            paramMap.clear();
            paramMap.put("sellerId", sellerId);
            paramMap.put("goodsCheck", 1);
            canSellGoods = sellerService.getSellerGoods(paramMap);
            data.put("canSellGoods", canSellGoods);
            result.setResult(data);
        } catch (Exception e) {
            result.setBusErrInfos("已经存在该商品");
            e.printStackTrace();
        }
        return result;
    }

    //删除商品
    @RequestMapping(value = "/delSellerGoods", produces = {"application/json;charset=UTF-8"})
    public Result delSellerGoods(String goodsId, HttpSession session) {
        Result result = new Result();
        Map<String, Object> paramMap = new HashMap<>();
        Map<String, Object> data = new HashMap<>();
        List<Goods> canSellGoods = new ArrayList<>();
        int sellerId = userService.getUserByUsername((String) session.getAttribute("username")).getId();
        try {
            paramMap.put("sellerId", sellerId);
            paramMap.put("goodsId", goodsId);
            sellerService.deleteSellerGoods(paramMap);
            paramMap.clear();
            paramMap.put("sellerId", sellerId);
            paramMap.put("goodsCheck", 1);
            canSellGoods = sellerService.getSellerGoods(paramMap);
            data.put("canSellGoods", canSellGoods);
            result.setResult(data);
        } catch (Exception e) {
            result.setBusErrInfos("删除商品失败");
            e.printStackTrace();
        }
        return result;
    }

    //添加新商品
    @RequestMapping(value = "/addNewGoods", produces = {"application/json;charset=UTF-8"})
    public Result addNewGoods(String typeId, String name, String desc, String price, String photo, HttpSession session) {
        Result result = new Result();
        Map<String, Object> paramMap = new HashMap<>();
        Map<String, Object> data = new HashMap<>();
        int sellerId = userService.getUserByUsername((String) session.getAttribute("username")).getId();
        try {
            Goods goods = new Goods();
            goods.setName(name);
            goods.setDesc(desc);
            goods.setPrice(Double.parseDouble(price));
            goods.setPhoto(photo);
            goods.setTypeId(Integer.parseInt(typeId));
            sellerService.addNewGoods(goods);
            int goodsId = goods.getId();
            paramMap.clear();
            paramMap.put("sellerId", sellerId);
            paramMap.put("goodsId", goodsId);
            paramMap.put("goodsCheck", 0);
            sellerService.addSellerGoods(paramMap);
            result.setResult(goods);
        } catch (Exception e) {
            result.setBusErrInfos("添加新商品失败");
            e.printStackTrace();
        }
        return result;
    }

    //商品审核状态
    @RequestMapping(value = "/goodsCheckStatus", produces = {"application/json;charset=UTF-8"})
    public Result getGoodsCheckStatus(HttpSession session) {
        Result result = new Result();
        Map<String, Object> paramMap = new HashMap<>();
        List<Goods> checkingGoods = new ArrayList<>();
        Map<String, Object> data = new HashMap<>();
        try {
            int sellerId = userService.getUserByUsername((String) session.getAttribute("username")).getId();
            paramMap.put("sellerId", sellerId);
            //paramMap.put("goodsCheck", 1);
            checkingGoods = sellerService.getGoodsCheckStatus(paramMap);
            data.put("checkingGoods",checkingGoods);
            result.setResult(checkingGoods);
        } catch (Exception e) {
            result.setBusErrInfos("查询失败，请重试!!!");
            e.printStackTrace();
        }
        return result;
    }

}
