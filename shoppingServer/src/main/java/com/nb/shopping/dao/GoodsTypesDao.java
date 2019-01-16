package com.nb.shopping.dao;

import com.nb.shopping.entity.GoodsTypes;

import java.util.List;

/**
 * @author :hly
 * @github :https://github.com/huangliangyun
 * @blog :http://www.javahly.com/
 * @CSDN :blog.csdn.net/Sirius_hly
 * @date :2019/1/9
 */
public interface GoodsTypesDao {

    //添加分类
    public int addGoodsTypes(GoodsTypes goodsTypes);

    //查询分类
    public List<GoodsTypes> findGoodsTypes();

    //查询分类和商品
    public List<GoodsTypes> findGoodsAndTypes();


}
