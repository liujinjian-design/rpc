package com.ljj.netty.inboundhandlerandoutboundhandler;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;

/**
 * @Author: liujinjian
 * @Date: 2020/8/16 14:48
 */
public class MyServerInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();

//        // 入站handler进行解码MyByteToLongDecoder
//        pipeline.addLast(new MyByteToLongDecoder());

        pipeline.addLast(new MyByteToLongDecoder2());

        // 出站handler编码器
        pipeline.addLast(new MyLongToByteEncoder());

        // handler
        pipeline.addLast(new MyServerHandler());

        System.out.println("xx");
    }
}
