package com.nb.shopping.dao;

import com.nb.shopping.entity.Customer;
import com.nb.shopping.entity.Goods;
import com.nb.shopping.entity.Seller;

import java.util.List;
import java.util.Map;

/**
 * @author :hly
 * @github :https://github.com/huangliangyun
 * @blog :http://www.javahly.com/
 * @CSDN :blog.csdn.net/Sirius_hly
 * @date :2019/1/8
 */
public interface SellerDao {

    //得到商家
    public List<Seller> getSeller(Map<String,Object> map);

    //得到商家商品
    public List<Goods> getSellerGoods(Map<String,Object> map);

    //商家删除商品
    public int deleteSellerGoods(Map<String,Object> map);

    //商家添加商品
    public int addSellerGoods(Map<String,Object> map);

    //商家添加新商品
    public int addNewGoods(Goods goods);

    //商品审核状态
    public List<Goods> getGoodsCheckStatus(Map<String,Object> map);

    //由货物Id得到商家Id
    public Seller getSellerMsgByGoods(Map<String,Object> map);


    //添加商家
    public int insertSeller(Seller seller);

    //修改商家信息
    public int updateSellerInfo(Seller seller);


}
