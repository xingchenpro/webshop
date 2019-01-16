package com.nb.shopping.controller;

import com.nb.shopping.entity.Goods;
import com.nb.shopping.service.GoodsService;
import com.nb.shopping.service.SellerService;
import com.nb.shopping.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author :hly
 * @github :https://github.com/huangliangyun
 * @blog :http://www.javahly.com/
 * @CSDN :blog.csdn.net/Sirius_hly
 * @date :2019/1/9
 */
@RestController
@RequestMapping("/")
public class AdminController {

    @Autowired
    GoodsService goodsService;

    @Autowired
    SellerService sellerService;

    //查询商品和类型
    @RequestMapping(value = "/findGoodsAndTypes", produces = {"application/json;charset=UTF-8"})
    public Result findGoodsAndTypes() {
        Result result = new Result();
        Map<String, Object> paramMap = new HashMap<>();
        try {
            paramMap.put("status", 1);
            //List<GoodsTypes> goodsTypes = goodsTypesService.findGoodsAndTypes();
            List<Goods> goods = goodsService.findGoods(paramMap);
            Map<String, Object> map = new HashMap<>();
            map.put("goods", goods);
            result.setResult(map);
        } catch (Exception e) {
            result.setBusErrInfos("查询失败!!!");
            e.printStackTrace();
        }
        //添加分类
        return result;
    }

    //更新商品
    @RequestMapping(value = "/updateGoodsInfo", produces = {"application/json;charset=UTF-8"})
    public Result updateGoodsInfo(Goods goods) {
        Result result = null;
        try {
            System.err.println(goods.toString());
            result = new Result();
            goodsService.updateGoodsInfo(goods);
            Map<String, Object> data = new HashMap<>();
            Map<String, Object> paramMap = new HashMap<>();
            paramMap.put("status", 1);
            List<Goods> checkedGoods = goodsService.findGoods(paramMap);
            data.put("checkedGoods", checkedGoods);
            result.setResult(data);
        } catch (Exception e) {
            result.setBusErrInfos("更新成功!!!");
            e.printStackTrace();
        }
        return result;
    }

    //删除商品
    @RequestMapping(value = "/delGoods/{id}", produces = {"application/json;charset=UTF-8"})
    public Result delGoods(@PathVariable("id") Integer id) {
        goodsService.deleteGoods(id);
        Result result = new Result();
        Map<String, Object> data = new HashMap<>();
        Map<String, Object> paramMap = new HashMap<>();
        try {
            paramMap.put("status", 1);
            List<Goods> checkedGoods = goodsService.findGoods(paramMap);
            data.put("checkedGoods", checkedGoods);
        } catch (Exception e) {
            result.setBusErrInfos("删除失败!!!");
            e.printStackTrace();
        }
        result.setResult(data);
        return result;
    }

    //审核商品
    @RequestMapping(value = "/goodsCheck", produces = {"application/json;charset=UTF-8"})
    public Result updateGoodsStatus(String goodsId, String status) {
        Result result = new Result();
        Map<String, Object> data = new HashMap<>();
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("status", status);
        paramMap.put("goodsId", goodsId);
        try {
            goodsService.updateGoodsStatus(paramMap);
            goodsService.updateSellerGoodsStatus(paramMap);
            paramMap.put("status", 0);
            List<Goods> uncheckedGoods = goodsService.findGoods(paramMap);
            data.put("uncheckedGoods", uncheckedGoods);
            result.setResult(data);
        } catch (Exception e) {
            result.setBusErrInfos("修改商品信息失败！！！");
            e.printStackTrace();
        }
        return result;
    }
}
