package com.ljj.dubbo.service.impl;

import com.ljj.dubbo.service.DemoService;

public class DemoServiceImpl implements DemoService {
    @Override
    public String sayHello(String name) {
        return "Hello " + name;
    }
}
