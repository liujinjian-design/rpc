package com.ljj.io.netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.util.Scanner;

/**
 * @Author: liujinjian
 * @Date: 2020/8/3 17:48
 */
public class DemoNettyClient {


    public void connect(String host, int port) throws InterruptedException {
        EventLoopGroup worker = new NioEventLoopGroup();
        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(worker);

            bootstrap.channel(NioSocketChannel.class);

            bootstrap.option(ChannelOption.SO_KEEPALIVE, true);

            bootstrap.handler(new ChannelInitializer<SocketChannel>() {
                @Override
                protected void initChannel(SocketChannel ch) throws Exception {
                    ch.pipeline().addLast(new DemoNettyClientHandler());
                }
            });

            ChannelFuture channelFuture = bootstrap.connect(host, port).sync();

            channelFuture.channel().closeFuture().sync();
        } finally {
            worker.shutdownGracefully();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        while (true) {
            Scanner content = new Scanner(System.in);
            System.out.println("请输入您要发送的内容：");
            Message.CLIENT_MESSAGE = content.nextLine();
            DemoNettyClient client = new DemoNettyClient();
            client.connect("127.0.0.1", 8088);
        }
    }
}
