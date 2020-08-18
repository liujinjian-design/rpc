package com.ljj.netty.dubborpc.provider;

import com.ljj.netty.dubborpc.netty.NettyServer;

/**
 * @Author: liujinjian
 * @Date: 2020/8/18 21:53
 */
public class ServerBootStrap {

    public static void main(String[] args) {
        NettyServer.startServer("127.0.0.1", 7000);
    }
}
