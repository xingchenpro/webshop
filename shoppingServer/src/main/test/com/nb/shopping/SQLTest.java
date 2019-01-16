package com.nb.shopping;

import com.nb.shopping.entity.GoodsTypes;
import com.nb.shopping.service.GoodsTypesService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;

/**
 * @author :hly
 * @github :https://github.com/huangliangyun
 * @blog :http://www.javahly.com/
 * @CSDN :blog.csdn.net/Sirius_hly
 * @date :2019/1/9
 */
public class SQLTest {

    @Resource
    GoodsTypesService goodsTypesService;

    /*@Test
    public void addGoodsTypes(){

        String goodsType [] = {"电视","咖啡粉", "热风机", "黑咖啡", "电压锅","暖风机", "电暖器", "咖啡","取暖器", "电暖气", "电饭煲", "暖风机", "取暖", "饮水机", "电饭锅" };
        for(int i=0;i<goodsType.length;i++){
            GoodsTypes goodsTypes = new GoodsTypes();
            goodsTypes.setName(goodsType[i]);
            goodsTypesService.addGoodsTypes(goodsTypes);
        }
    }
*/

}
