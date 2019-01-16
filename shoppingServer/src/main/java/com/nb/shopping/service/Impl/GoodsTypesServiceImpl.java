package com.nb.shopping.service.Impl;

import com.nb.shopping.dao.GoodsTypesDao;
import com.nb.shopping.entity.GoodsTypes;
import com.nb.shopping.service.GoodsTypesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author :hly
 * @github :https://github.com/huangliangyun
 * @blog :http://www.javahly.com/
 * @CSDN :blog.csdn.net/Sirius_hly
 * @date :2019/1/9
 */

@Service
public class GoodsTypesServiceImpl implements GoodsTypesService {

    @Autowired
    GoodsTypesDao goodsTypesDao;


    @Override
    public int addGoodsTypes(GoodsTypes goodsTypes) {
        goodsTypesDao.addGoodsTypes(goodsTypes);
        return 1;
    }

    @Override
    public List<GoodsTypes> findGoodsTypes() {
        return goodsTypesDao.findGoodsTypes();
    }

    @Override
    public List<GoodsTypes> findGoodsAndTypes() {
        return goodsTypesDao.findGoodsAndTypes();
    }
}
