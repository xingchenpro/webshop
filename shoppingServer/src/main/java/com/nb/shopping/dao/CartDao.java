package com.nb.shopping.dao;

import com.nb.shopping.entity.Cart;

import java.util.List;
import java.util.Map;

/**
 * @author :hly
 * @github :https://github.com/huangliangyun
 * @blog :http://www.javahly.com/
 * @CSDN :blog.csdn.net/Sirius_hly
 * @date :2019/1/8
 */
public interface CartDao {

    //查询某客户所有购物车
    public List<Cart> getCustomerAllCart(Map<String,Object> map);

    //添加购物车
    public int addCart(Cart cart);

    //添加购物车商品
    public int addCartGoods(Map<String,Object> map);

    //删除购物车
    public int deleteCart(Map<String,Object> map);

    //删除购物车里面的商品
    public int deleteCartGoods(Map<String,Object> map);

    //修改购物车商品状态
    public int updateCartGoodsCount(Map<String,Object> map);



}
