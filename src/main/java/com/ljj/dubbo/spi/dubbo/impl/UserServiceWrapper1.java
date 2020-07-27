package com.ljj.dubbo.spi.dubbo.impl;

import com.ljj.dubbo.spi.dubbo.UserService;

/**
 * @Author: liujinjian
 * @Date: 2020/7/16 17:59
 */
public class UserServiceWrapper1 implements UserService {

    private UserService userService;

    public UserServiceWrapper1(UserService userService) {
        this.userService = userService;
    }

    @Override
    public String queryOrder(String userId, Long orderId) {
        System.out.println("包装类111111");
        return userService.queryOrder(userId, orderId);
    }
}
