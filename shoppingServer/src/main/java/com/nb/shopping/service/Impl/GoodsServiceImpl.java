package com.nb.shopping.service.Impl;

import com.nb.shopping.dao.GoodsDao;
import com.nb.shopping.entity.Goods;
import com.nb.shopping.service.GoodsService;
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
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    GoodsDao goodsDao;


    @Override
    public int addGoods(Goods goods) {
        goodsDao.addGoods(goods);
        return 0;
    }

    @Override
    public List<Goods> findGoods(Map<String, Object> map) {
        return goodsDao.findGoods(map);
    }

    @Override
    public int updateGoodsInfo(Goods goods) {
        return goodsDao.updateGoodsInfo(goods);
    }

    @Override
    public int deleteGoods(Integer id) {
        return goodsDao.deleteGoods(id);
    }

    @Override
    public int updateGoodsStatus(Map<String, Object> map) {
        return goodsDao.updateGoodsStatus(map);
    }

    @Override
    public int updateSellerGoodsStatus(Map<String, Object> map) {
        return goodsDao.updateSellerGoodsStatus(map);
    }

    @Override
    public List<Goods> getPeerSellerGoods(Map<String, Object> map) {
        return goodsDao.getPeerSellerGoods(map);
    }

    @Override
    public List<Goods> getSellerAllGoods(Map<String, Object> map) {
        return goodsDao.getSellerAllGoods(map);
    }

    @Override
    public List<Goods> getSellerGoods(Map<String, Object> map) {
        return goodsDao.getSellerGoods(map);
    }

}
