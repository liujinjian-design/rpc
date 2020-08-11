package com.ljj.netty.simple;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * @Author: liujinjian
 * @Date: 2020/8/10 23:33
 */
public class NettyServer {
    public static void main(String[] args) throws InterruptedException {

        // 创建BossGroup 和 workerGroup
        // bossGroup只是处理连接请求 真正的客户端业务处理会交给workerGroup处理
        // 两个都是无限循环
        // bossGroup 和 workerGroup含有的子线程（NioEventLoop）个的数 默认cpu核数*2
        EventLoopGroup bossGroup = new NioEventLoopGroup(1);
        NioEventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            // 创建服务端的启动对象，配置启动参数
            ServerBootstrap bootstrap = new ServerBootstrap();
            // 设置两个线程组 使用NioSockerChannel 作为服务端的通道实现
            bootstrap.group(bossGroup, workerGroup)
                    // 使用NioServerSocketChannel作为服务器的通道实现
                    .channel(NioServerSocketChannel.class)
                    // 设置线程队列得到连接个数
                    .option(ChannelOption.SO_BACKLOG, 128)
                    // 设置保持活动连接状态
                    .childOption(ChannelOption.SO_KEEPALIVE, true)
                    // 给我们的workerGroup的EventLoop设置对应的处理器
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        //
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ch.pipeline().addLast(new NettyServerHandler());
                        }
                    })
            ;
            System.out.println(".......服务器 is ready.....");

            // 绑定一个端口并且同步，生成了一个ChannelFuture对象
            // 启动服务器（并绑定端口）
            ChannelFuture cf = bootstrap.bind(6668).sync();

            // 对关闭通道进行监听
            cf.channel().closeFuture().sync();
        } finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }
}
