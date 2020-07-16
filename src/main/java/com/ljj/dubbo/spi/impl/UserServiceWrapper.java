package com.ljj.dubbo.spi.impl;

import com.ljj.dubbo.spi.UserService;

/**
 * @Author: liujinjian
 * @Date: 2020/7/16 17:52
 */
public class UserServiceWrapper implements UserService {

    private UserService userService;

    public UserServiceWrapper(UserService userService) {
        this.userService = userService;
    }

    @Override
    public String queryOrder(String userId, Long orderId) {
        System.out.println("这是一个包装类");
        return userService.queryOrder("fdafd", 1000L);
    }
}
