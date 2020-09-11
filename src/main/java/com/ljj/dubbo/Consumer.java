package com.ljj.dubbo;

import com.ljj.dubbo.service.DemoService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.concurrent.CountDownLatch;

/**
 * @Author: liujinjian
 * @Date: 2020/7/22 19:24
 */
public class Consumer {

    public static void main(String[] args) throws InterruptedException {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("consumer.xml");
        DemoService demoService = (DemoService) classPathXmlApplicationContext.getBean("demoService");

        CountDownLatch countDownLatch = new CountDownLatch(1);
        CountDownLatch end = new CountDownLatch(201);

        for (int i = 0; i < 201; i++) {
            Thread thread = new Thread(() -> {
                try {
                    try {
                        countDownLatch.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(demoService.sayHello("刘雪梅"));
                } finally {
                    end.countDown();
                }

            });
            thread.start();
        }

        countDownLatch.countDown();
        end.await();

    }
}
