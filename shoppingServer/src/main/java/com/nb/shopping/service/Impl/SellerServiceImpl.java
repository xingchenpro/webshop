package com.nb.shopping.service.Impl;

import com.nb.shopping.dao.SellerDao;
import com.nb.shopping.entity.Customer;
import com.nb.shopping.entity.Goods;
import com.nb.shopping.entity.Seller;
import com.nb.shopping.service.SellerService;
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
public class SellerServiceImpl implements SellerService {

    @Autowired
    SellerDao sellerDao;

    @Override
    public List<Seller> getSeller(Map<String, Object> map) {
        return sellerDao.getSeller(map);
    }


    @Override
    public List<Goods> getSellerGoods(Map<String, Object> map) {
        return sellerDao.getSellerGoods(map);
    }

    @Override
    public int deleteSellerGoods(Map<String, Object> map) {
        return sellerDao.deleteSellerGoods(map);
    }

    @Override
    public int addSellerGoods(Map<String, Object> map) {
        return sellerDao.addSellerGoods(map);
    }

    @Override
    public int addNewGoods(Goods goods) {
        return sellerDao.addNewGoods(goods);
    }

    @Override
    public List<Goods> getGoodsCheckStatus(Map<String, Object> map) {
        return sellerDao.getGoodsCheckStatus(map);
    }

    @Override
    public Seller getSellerMsgByGoods(Map<String, Object> map) {
        return sellerDao.getSellerMsgByGoods(map);
    }

    @Override
    public int insertSeller(Seller seller) {
        return sellerDao.insertSeller(seller);
    }

    @Override
    public int updateSellerInfo(Seller seller) {
        return sellerDao.updateSellerInfo(seller);
    }

}
