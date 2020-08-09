package com.ljj.dubbo;

import com.ljj.dubbo.service.DemoService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author: liujinjian
 * @Date: 2020/7/22 19:24
 */
public class Consumer {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("consumer.xml");
        DemoService demoService = (DemoService) classPathXmlApplicationContext.getBean("demoService");
        System.out.println(demoService.sayHello("刘金剑"));
    }
}
