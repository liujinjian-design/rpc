package com.ljj.dubbo.service.impl;

import com.ljj.dubbo.service.DemoService;

import java.util.concurrent.TimeUnit;

public class DemoServiceImpl implements DemoService {
    @Override
    public String sayHello(String name) {
        try {
            TimeUnit.MINUTES.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Hello " + name;
    }
}
