package com.ljj.dubbo.spi.dubbo.impl;

import com.alibaba.dubbo.common.URL;
import com.ljj.dubbo.spi.dubbo.OrderService;

/**
 * @Author: liujinjian
 * @Date: 2020/7/16 15:38
 */
public class OrderServiceImpl implements OrderService {

    @Override
    public String queryOrderById(Long orderId, URL url) {
        return "liujinjian购买的小巫婆";
    }
}
