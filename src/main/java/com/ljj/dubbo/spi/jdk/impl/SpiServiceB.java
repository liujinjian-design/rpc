package com.ljj.dubbo.spi.jdk.impl;

import com.ljj.dubbo.spi.jdk.SpiService;

/**
 * @Author: liujinjian
 * @Date: 2020/7/26 12:11
 */
public class SpiServiceB implements SpiService {
    @Override
    public void sayHello() {
        System.out.println("SpiServiceB.Hello");
    }
}
