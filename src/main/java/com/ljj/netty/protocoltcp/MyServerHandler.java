package com.ljj.netty.protocoltcp;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.nio.charset.Charset;

/**
 * @Author: liujinjian
 * @Date: 2020/8/16 17:51
 */
public class MyServerHandler extends SimpleChannelInboundHandler<MessageProtocol> {
    private int count;

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MessageProtocol msg) throws Exception {
        // 接收到数据并处理
        int len = msg.getLen();
        byte[] content = msg.getContent();

        System.out.println("服务端接收到信息如下");
        System.out.println("长度=" + len);
        System.out.println("内容=" + new String(content, Charset.forName("UTF-8")));

        System.out.println("服务器接收到信息包数量" + (this.count++));
    }
}
