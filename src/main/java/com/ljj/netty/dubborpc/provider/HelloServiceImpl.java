package com.ljj.netty.dubborpc.provider;

import com.ljj.netty.dubborpc.publicinterface.HelloService;

/**
 * @Author: liujinjian
 * @Date: 2020/8/18 21:50
 */
public class HelloServiceImpl implements HelloService {

    private int count = 0;

    @Override
    public String hello(String msg) {
        System.out.println("收到客户端消息=" + msg);
        if (msg != null) {
            return "您好客户端，我已收到你的消息【" + msg + "】第" + (++count) + "";
        } else {
            return "你好客户端，我已收到你的消息";
        }
    }
}
