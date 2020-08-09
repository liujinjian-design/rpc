package com.ljj.io.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * @Author: liujinjian
 * @Date: 2020/8/3 13:32
 */
public class DemoNettyServer {


    public void bind(int port) throws InterruptedException {
        // 主线程组
        EventLoopGroup bossGroup = new NioEventLoopGroup();

        // 从线程组
        EventLoopGroup workerGroup = new NioEventLoopGroup();

        try {
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            serverBootstrap.group(bossGroup, workerGroup).channel(NioServerSocketChannel.class)
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ch.pipeline().addLast(new DemoNettyServerHandler());
                        }
                    });
            ChannelFuture channelFuture = serverBootstrap.bind(8088).sync();
            System.out.println("Server start");

            channelFuture.channel().closeFuture().sync();
        } finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }

    public static void main(String[] args) throws Exception {
        int port = 8080;
        new DemoNettyServer().bind(port);
    }

}
