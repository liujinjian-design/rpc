package com.ljj.dubbo.spi.jdk;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * @Author: liujinjian
 * @Date: 2020/7/26 12:13
 */
public class SpiTest {
    public static void main(String[] args) {
        ServiceLoader<SpiService> serviceLoader = ServiceLoader.load(SpiService.class);
        Iterator<SpiService> iterator = serviceLoader.iterator();
        while (iterator.hasNext()) {
            SpiService spiService = iterator.next();
            spiService.sayHello();
        }
    }
}
