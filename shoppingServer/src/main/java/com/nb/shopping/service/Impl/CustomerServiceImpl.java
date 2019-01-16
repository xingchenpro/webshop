package com.nb.shopping.service.Impl;

import com.nb.shopping.dao.CustomerDao;
import com.nb.shopping.entity.Customer;
import com.nb.shopping.entity.Seller;
import com.nb.shopping.service.CustomerService;
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
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerDao customerDao;

    @Override
    public List<Customer> getCustomer(Map<String, Object> map) {
        return customerDao.getCustomer(map);
    }

    @Override
    public int insertCustomer(Customer customer) {
        return customerDao.insertCustomer(customer);
    }

    @Override
    public int updateCustomer(Customer customer) {
        return customerDao.updateCustomer(customer);
    }
}
