package com.ljj.dubbo.spi;

import com.alibaba.dubbo.common.extension.SPI;

/**
 * @Author: liujinjian
 * @Date: 2020/7/16 16:13
 */
@SPI
public interface UserService {

    /**
     * 查询用户订单
     *
     * @param userId
     * @param orderId
     * @return
     */
    String queryOrder(String userId, Long orderId);
}
