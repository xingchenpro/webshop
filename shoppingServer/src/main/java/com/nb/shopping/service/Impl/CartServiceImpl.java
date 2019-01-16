package com.nb.shopping.service.Impl;

import com.nb.shopping.dao.CartDao;
import com.nb.shopping.entity.Cart;
import com.nb.shopping.service.CartService;
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
public class CartServiceImpl implements CartService {

    @Autowired
    CartDao cartDao;


    @Override
    public List<Cart> getCustomerAllCart(Map<String, Object> map) {
        return cartDao.getCustomerAllCart(map);
    }

    @Override
    public int addCart(Cart cart) {
        return cartDao.addCart(cart);
    }

    @Override
    public int addCartGoods(Map<String, Object> map) {
        return cartDao.addCartGoods(map);
    }

    @Override
    public int deleteCart(Map<String, Object> map) {
        return cartDao.deleteCart(map);
    }

    @Override
    public int deleteCartGoods(Map<String, Object> map) {
        return cartDao.deleteCartGoods(map);
    }

    @Override
    public int updateCartGoodsCount(Map<String, Object> map) {
        return cartDao.updateCartGoodsCount(map);
    }
}
