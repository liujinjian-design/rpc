package com.ljj.netty.simple;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelPipeline;
import io.netty.util.CharsetUtil;

/**
 * @Author: liujinjian
 * 我们自定义一个handler，需要继承netty规定好的handlerAdapter
 * 这时我们自定义的一个handler,才能称为一个handler
 * @Date: 2020/8/11 0:12
 */
public class NettyServerHandler extends ChannelInboundHandlerAdapter {

    /**
     * 读取实际数据（这里我们可以读取客户端发送的信息）
     * 1、ChannelHandlerContext ctx:上下文对象，含有管道pipeline,通道channel,地址
     *
     * @param ctx
     * @param msg 客户端发送的数据u，默认Object
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("服务器读取线程 = " + Thread.currentThread().getName());
        System.out.println("server ctx = " + ctx);
        System.out.println("看看chanel 和 pipeline的关系");
        Channel channel = ctx.channel();
        // channelPipeline 本质是一个双向链表 出站入战
        ChannelPipeline pipeline = ctx.pipeline();
        // 将msg转成一个ByteBuf
        // ByteBuf netty提供的 不是NIO的 ByteBuffer
        ByteBuf buf = (ByteBuf) msg;
        System.out.println("客户端发送消息是：" + buf.toString(CharsetUtil.UTF_8));
        System.out.println("客户端地址：" + ctx.channel().remoteAddress());
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) {
        // writeAndFlush 是write + flush
        // 将数据写到缓存并刷新
        // 一般讲，我们对这个发送的数据进行编码
        ctx.writeAndFlush(Unpooled.copiedBuffer("Hello,客户端", CharsetUtil.UTF_8));
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        ctx.close();
    }


}
