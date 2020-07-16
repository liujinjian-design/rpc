package com.ljj.dubbo.spi.impl;

import com.alibaba.dubbo.common.URL;
import com.ljj.dubbo.spi.OrderService;

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
