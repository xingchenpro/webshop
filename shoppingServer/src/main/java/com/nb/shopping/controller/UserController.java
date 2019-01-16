package com.nb.shopping.controller;

import com.nb.shopping.entity.Customer;
import com.nb.shopping.entity.Seller;
import com.nb.shopping.entity.User;
import com.nb.shopping.service.CustomerService;
import com.nb.shopping.service.GoodsService;
import com.nb.shopping.service.SellerService;
import com.nb.shopping.service.UserService;
import com.nb.shopping.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
/**
 * @author :hly
 * @github :https://github.com/huangliangyun
 * @blog :http://www.javahly.com/
 * @CSDN :blog.csdn.net/Sirius_hly
 * @date :2018/12/21
 */
@RestController
@RequestMapping(value = "/")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    GoodsService goodsService;

    @Autowired
    CustomerService customerService;

    @Autowired
    SellerService sellerService;

    //登录
    @RequestMapping(value = "/login", produces = {"application/json;charset=UTF-8"})
    public Result login(User user, HttpServletRequest request) {
        //System.err.println(user);
        Result result = new Result();
        HttpSession session = request.getSession();
        try {
            if (user.getPassword().equals(userService.getUserByUsername(user.getUsername()).getPassword())) {
                session.setAttribute("username", user.getUsername());
                result.setResult(user);
            } else {
                result.setParaErrInfos("用户名或者密码错误!!!");
            }
        } catch (Exception e) {
            result.setParaErrInfos("用户名或密码错误！");
            e.printStackTrace();
        }
        System.err.println(result);
        return result;
    }
    //注销
    @RequestMapping(value = "/logout", produces = {"application/json;charset=UTF-8"})
    public Result login(HttpSession session, String username) {
        Result result = new Result();
        try {
            if (session.getAttribute("username") != null)
                session.removeAttribute("username");
            session.invalidate();
        } catch (Exception e) {
            result.setBusErrInfos("注销失败!!!");
            e.printStackTrace();
        }
        return result;
    }

    //注册
    @RequestMapping(value = "/register", produces = {"application/json;charset=UTF-8"})
    public Result register(HttpSession session, String sellerName,String nickName,String desc,String location,String phoneNum,String role,String username,String password) {
        Result result = new Result();
        //如果是商家
        try {
            if(Integer.parseInt(role)==2){
                User user = new User();
                user.setUsername(username);
                user.setPassword(password);
                userService.insertUser(user);
                int userId = user.getId();
                Seller seller = new Seller();
                seller.setId(userId);
                seller.setDesc(desc);
                seller.setName(sellerName);
                seller.setLocation(location);
                seller.setPhoneNum(phoneNum);
                sellerService.insertSeller(seller);

            }else{
                User user = new User();
                user.setUsername(username);
                user.setPassword(password);
                userService.insertUser(user);
                int userId = user.getId();
                Customer customer = new Customer();
                customer.setId(userId);
                customer.setNickName(nickName);
                customerService.insertCustomer(customer);
            }
        } catch (Exception e) {
            result.setBusErrInfos("注册失败!!!");
            e.printStackTrace();
        }
        return  result;
    }
}
