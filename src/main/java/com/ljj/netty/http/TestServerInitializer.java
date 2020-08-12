package com.ljj.netty.http;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpServerCodec;

/**
 * @Author: liujinjian
 * @Date: 2020/8/11 22:32
 */
public class TestServerInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        // 向管道加入处理器
        // 得到管道
        ChannelPipeline pipeline = ch.pipeline();
        // 加入一个netty提供的httpServerCodec codec = [coder - decoder]
        // HttpServerCodec netty 提供的处理http的编码解码器
        pipeline.addLast("MyHttpServerCodec", new HttpServerCodec());
        // 增加一个自定义的handler
        pipeline.addLast("MyTestHttpServerHandler", new TestHttpServerHandler());

    }
}
