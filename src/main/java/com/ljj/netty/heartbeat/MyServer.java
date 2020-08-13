package com.ljj.netty.heartbeat;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import io.netty.handler.timeout.IdleStateHandler;

import java.util.concurrent.TimeUnit;

/**
 * @Author: LIUYUE
 * @Date: 2020/8/13 22:29
 */
public class MyServer {

    public static void main(String[] args) throws InterruptedException {
        NioEventLoopGroup bossGroup = new NioEventLoopGroup(1);
        NioEventLoopGroup workerGroup = new NioEventLoopGroup(8);
        try {
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            serverBootstrap.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)
                    // 在bossGroup增加一个日志处理器
                    .handler(new LoggingHandler(LogLevel.INFO))
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ChannelPipeline pipeline = ch.pipeline();
                            /**
                             * 加入netty提供的IdleStateHandler
                             * netty提供的处理空闲状态的处理器
                             * Long readerIdleTime 表示多长时间没有读了,就会发送一个心跳检测包 检测是否还是连接的状态
                             * Long writerIdleTime 表示多长时间没有写了，也会发送一个心跳检测包检测是否连接
                             * Long allIdleTime 表示多长时间是否没有读写 也会发送一个心跳检测包检测是否连接
                             * 当IdleStataEvent触发后，就会传递给管道的下一个handler去处理，通过调用下一个handler的userEventTriggered,在该方法中
                             * 处理IdleStateEvent(读空闲，写空闲，读写空闲)
                             */
                            pipeline.addLast(new IdleStateHandler(13, 5, 7, TimeUnit.SECONDS));

                            // 加入一个对空闲检测进一步处理的handler(自定义)
                            pipeline.addLast(new MyServerHandler());

                        }
                    });
            ChannelFuture future = serverBootstrap.bind(7000).sync();
            future.channel().closeFuture().sync();
        } finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }
}
