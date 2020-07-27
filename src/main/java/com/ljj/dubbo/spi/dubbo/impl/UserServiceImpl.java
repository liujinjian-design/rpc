package com.ljj.dubbo.spi.dubbo.impl;

import com.alibaba.dubbo.common.URL;
import com.ljj.dubbo.spi.dubbo.OrderService;
import com.ljj.dubbo.spi.dubbo.UserService;

/**
 * @Author: liujinjian
 * @Date: 2020/7/16 16:14
 */
public class UserServiceImpl implements UserService {

    private OrderService orderService;

    @Override
    public String queryOrder(String userId, Long orderId) {
        URL url = new URL("dubbo", "localhost", 8080);
        url = url.addParameter("liujinjian", "defaultImp");
        return userId + "购买了：" + orderId + orderService.queryOrderById(orderId, url);
    }

    public OrderService getOrderService() {
        return orderService;
    }

    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }
}
