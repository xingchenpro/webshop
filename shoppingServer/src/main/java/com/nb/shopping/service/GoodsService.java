package com.nb.shopping.service;

import com.nb.shopping.entity.Goods;
import java.util.List;
import java.util.Map;

/**
 * @author :hly
 * @github :https://github.com/huangliangyun
 * @blog :http://www.javahly.com/
 * @CSDN :blog.csdn.net/Sirius_hly
 * @date :2019/1/8
 */

public interface GoodsService {
    //添加商品
    public int addGoods(Goods goods);

    //查询商品
    public List<Goods> findGoods(Map<String, Object> map);

    //修改商品属性
    public int updateGoodsInfo(Goods goods);

    //删除商品
    public int deleteGoods(Integer id);

    //修改商品属性
    public int updateGoodsStatus(Map<String, Object> map);

    //修改商家商品属性
    public int updateSellerGoodsStatus(Map<String, Object> map);

    //得到每一位商家的第一条商品信息
    public List<Goods> getPeerSellerGoods(Map<String, Object> map);

    //得到某商家的全部商品信息
    public List<Goods> getSellerAllGoods(Map<String, Object> map);

    //得到某商家的某商品
    public List<Goods> getSellerGoods(Map<String, Object> map);

}
