package com.ljj.io.netty;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * @Author: liujinjian
 * @Date: 2020/8/3 13:36
 */
public class DemoNettyServerHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        System.out.println("收到来自客户端的一条信息");
        ByteBuf result = (ByteBuf) msg;
        byte[] byteMsg = new byte[result.readableBytes()];
        result.readBytes(byteMsg);
        String resultStr = new String(byteMsg);
        // 接受并打印客户端消息
        System.out.println("客户端内容：" + resultStr);
        result.release();
        String response = "我是server,已经收到你的消息：" + resultStr;
        ByteBuf encoded = ctx.alloc().buffer(4 * response.length());
        encoded.writeBytes(response.getBytes());
        ctx.writeAndFlush(encoded);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause){
        cause.printStackTrace();
        ctx.close();
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx){
        ctx.flush();
    }
}
