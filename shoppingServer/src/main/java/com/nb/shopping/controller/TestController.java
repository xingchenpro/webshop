package com.nb.shopping.controller;

import com.nb.shopping.entity.Goods;
import com.nb.shopping.entity.GoodsTypes;
import com.nb.shopping.service.GoodsService;
import com.nb.shopping.service.GoodsTypesService;
import com.nb.shopping.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
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
 * @date :2018/12/21
 */
@RestController
@RequestMapping("/")
public class TestController {

    @Autowired
    GoodsTypesService goodsTypesService;

    @Autowired
    GoodsService goodsService;

    @RequestMapping(value = "/goodsTypes",produces = {"application/json;charset=UTF-8"})
    public Result getGoodsTypes(){
        Result result = new Result();
        List<GoodsTypes> typesList = goodsTypesService.findGoodsTypes();
        result.setResult(typesList);
        return result;
    }

    @RequestMapping(value = "/addGoodsTypes",produces = {"application/json;charset=UTF-8"})
    public Result insertGoodsTypes(){
        Result result = new Result();
        String goodsType [] = {"电视","咖啡粉", "热风机", "黑咖啡", "电压锅","暖风机", "电暖器", "咖啡","取暖器", "电暖气", "电饭煲", "暖风机", "取暖", "饮水机", "电饭锅" };
        for(int i=0;i<goodsType.length;i++){
            GoodsTypes goodsTypes = new GoodsTypes();
            goodsTypes.setName(goodsType[i]);
            goodsTypesService.addGoodsTypes(goodsTypes);
        }
        List<GoodsTypes> typesList = goodsTypesService.findGoodsTypes();
        result.setResult(typesList);
        return result;
    }


    @RequestMapping(value = "/goods",produces = {"application/json;charset=UTF-8"})
    public Result getGoods(){
        Result result = new Result();
        Map<String,Object> paramMap = new HashMap<>();
        paramMap.put("status",1);
        List<Goods> goodsList = goodsService.findGoods(paramMap);
        System.err.println(goodsList);
        result.setResult(goodsList);
        return result;
    }

    @RequestMapping(value = "/addGoods",produces = {"application/json;charset=UTF-8"})
    public Result addGoods(){
        Result result = new Result();
        //添加商品
        Goods goods = new Goods();
        goods.setNumber(6);
        goods.setName("泡面");
        goods.setPrice(20);
        goodsService.addGoods(goods);
        //添加分类
        return result;
    }

}
