package com.ljj.netty.groupchat;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

import java.util.Scanner;

/**
 * @Author: LIUYUE
 * @Date: 2020/8/13 21:49
 */
public class GroupChatClient {

    /**
     * 主机
     */
    private final String host;
    /**
     * 端口
     */
    private final int port;

    public GroupChatClient(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public void run() throws InterruptedException {
        NioEventLoopGroup eventLoopGroup = new NioEventLoopGroup();
        Bootstrap bootstrap = new Bootstrap();
        try {
            bootstrap.group(eventLoopGroup).channel(NioSocketChannel.class).handler(new ChannelInitializer<SocketChannel>() {
                @Override
                protected void initChannel(SocketChannel ch) throws Exception {
                    ChannelPipeline pipeline = ch.pipeline();
                    // 向pipeline加入解码器
                    pipeline.addLast("decoder", new StringDecoder());
                    // 向pipeline加入编码器
                    pipeline.addLast("encoder", new StringEncoder());
                    pipeline.addLast(new GroupChatClientHandler());
                }
            });
            ChannelFuture future = bootstrap.connect(host, port).sync();
            // 得到channel
            Channel channel = future.channel();
            System.out.println("---------------" + channel.localAddress() + "已经准备好了");
            Scanner scanner = new Scanner(System.in);
            while (scanner.hasNextLine()) {
                String msg = scanner.nextLine();
                // 通过channel发送到服务器端
                channel.writeAndFlush(msg);
            }
        } finally {
            eventLoopGroup.shutdownGracefully();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new GroupChatClient("localhost", 7000).run();
    }
}
