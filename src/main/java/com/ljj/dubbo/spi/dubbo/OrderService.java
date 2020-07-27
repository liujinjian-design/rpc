package com.ljj.dubbo.spi.dubbo;

import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.common.extension.Adaptive;
import com.alibaba.dubbo.common.extension.SPI;

/**
 * @Author: liujinjian
 * @Date: 2020/7/16 15:37
 */
@SPI
public interface OrderService {

    /**
     * 查询订单
     *
     * @param orderId
     * @return
     */
    @Adaptive(value = {"liujinjian"})
    String queryOrderById(Long orderId, URL url);
}
