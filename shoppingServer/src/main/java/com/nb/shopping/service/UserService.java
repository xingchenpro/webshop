package com.nb.shopping.service;
import com.nb.shopping.entity.User;

/**
 * @author :hly
 * @github :https://github.com/huangliangyun
 * @blog :http://www.javahly.com/
 * @CSDN :blog.csdn.net/Sirius_hly
 * @date :2018/12/21
 */

public interface UserService {
    /**
     * 查询用户
     * @param username
     * @return
     */
    public User getUserByUsername(String username);

    //用户注册
    public int insertUser(User user);



}
