package com.nb.shopping.service;

import com.nb.shopping.entity.Customer;
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
public interface CustomerService {

    public List<Customer> getCustomer(Map<String,Object> map);
    //添加会员
    public int insertCustomer(Customer customer);

    //修改会员信息
    public int updateCustomer(Customer customer);

}
