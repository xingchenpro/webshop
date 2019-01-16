package com.nb.shopping.controller;
import com.nb.shopping.entity.Customer;
import com.nb.shopping.entity.Goods;
import com.nb.shopping.entity.GoodsTypes;
import com.nb.shopping.entity.Seller;
import com.nb.shopping.service.*;
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
 * @date :2018/12/21
 */

@RestController
@RequestMapping("/")
public class IndexController {

    @Autowired
    GoodsTypesService goodsTypesService;

    @Autowired
    UserService userService;

    @Autowired
    GoodsService goodsService;

    @Autowired
    CustomerService customerService;

    @Autowired
    SellerService sellerService;

    //首页
    @RequestMapping(value = {"/index","/"},  produces = {"application/json;charset=UTF-8" })
    public Result index() {
        Result result = new Result();
        Map<String, Object> data = new HashMap<>();
        Map<String, Object> paramMap = new HashMap<>();
        try {
            List<GoodsTypes> goodsTypes = goodsTypesService.findGoodsTypes();
            List<Goods> goods = goodsService.getPeerSellerGoods(paramMap);
            data.put("goodsTypes",goodsTypes);
            data.put("goods",goods);
            result.setResult(data);
        } catch (Exception e) {
            result.setBusErrInfos("商品查询失败!!!");
            e.printStackTrace();
        }
        return result;
    }

    @RequestMapping(value = "/home",  produces = {"application/json;charset=UTF-8" })
    public Result home(Integer role, HttpSession session) {
        Result result = new Result();
        try {
            //管理员
            if (role == 1) {
                Map<String, Object> data = new HashMap<>();
                Map<String, Object> paramMap = new HashMap<>();
                paramMap.put("status", 1);
                List<Goods> checkedGoods = goodsService.findGoods(paramMap);
                paramMap.clear();
                paramMap.put("status", 0);
                List<Goods> uncheckedGoods = goodsService.findGoods(paramMap);
                List<Seller> sellers = sellerService.getSeller(paramMap);
                List<Customer> customers = customerService.getCustomer(paramMap);
                data.put("checkedGoods", checkedGoods);
                data.put("uncheckedGoods", uncheckedGoods);
                data.put("sellers", sellers);
                data.put("customers", customers);
                result.setResult(data);
            }
            //商家
            else if (role == 2) {
                int sellerId = userService.getUserByUsername((String) session.getAttribute("username")).getId();
                Map<String,Object> paramMap = new HashMap<>();
                Map<String,Object> data = new HashMap<>();
                List<Goods> canSellGoods = new ArrayList<>();
                List<Goods> AllGoods = new ArrayList<>();
                List<Goods> goodsCheckStatus = new ArrayList<>();
                System.err.println(sellerId);
                paramMap.put("status",1);
                //所有商品
                AllGoods = goodsService.findGoods(paramMap);
                //商家能出售的商品
                paramMap.clear();
                paramMap.put("sellerId",sellerId);
                paramMap.put("goodsCheck",1);
                canSellGoods = sellerService.getSellerGoods(paramMap);
                paramMap.clear();
                paramMap.put("sellerId", sellerId);
                paramMap.put("goodsCheck", 1);
                goodsCheckStatus = sellerService.getGoodsCheckStatus(paramMap);
                data.put("goodsCheckStatus",goodsCheckStatus);
                data.put("AllGoods",AllGoods);
                data.put("canSellGoods",canSellGoods);
                result.setResult(data);
            }
            else if (role==3){

            }
            else {
                result.setParaErrInfos("用户名或者密码错误!!!");
            }
        } catch (Exception e) {
            result.setParaErrInfos("用户名或密码错误！");
            e.printStackTrace();
        }
        return result;
    }

}
