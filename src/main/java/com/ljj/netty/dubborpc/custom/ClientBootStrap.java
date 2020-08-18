package com.ljj.netty.dubborpc.custom;


import com.ljj.netty.dubborpc.netty.NettyClient;
import com.ljj.netty.dubborpc.publicinterface.HelloService;

/**
 * @Author: liujinjian
 * @Date: 2020/8/18 22:46
 */
public class ClientBootStrap {

    public static final String providerName = "HelloService#hello#";

    public static void main(String[] args) throws InterruptedException {
        // 创建一个消费者
        NettyClient customer = new NettyClient();
        // 创建一个代理对象
        HelloService helloService = (HelloService) customer.getBean(HelloService.class, providerName);

        for (; ; ) {
            Thread.sleep(10 * 1000);
            // 通过d代理对象调用服务提供者的方法（服务）
            String res = helloService.hello("你好 dubbo");
            System.out.println("调用结果 res = " + res);
        }

    }
}
