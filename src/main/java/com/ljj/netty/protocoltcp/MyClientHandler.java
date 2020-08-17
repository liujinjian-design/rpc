package com.ljj.netty.protocoltcp;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.nio.charset.Charset;

/**
 * @Author: liujinjian
 * @Date: 2020/8/16 17:47
 */
public class MyClientHandler extends SimpleChannelInboundHandler<MessageProtocol> {

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        // 使用客户端发送十条数据 "今天天气冷，吃火锅"
        for (int i = 0; i < 5; i++) {
            String msg = "今天天气冷，吃火锅";
            byte[] content = msg.getBytes(Charset.forName("UTF-8"));
            int length = content.length;

            // 创建协议包
            MessageProtocol messageProtocol = new MessageProtocol();
            messageProtocol.setLen(length);
            messageProtocol.setContent(content);
            ctx.writeAndFlush(messageProtocol);
        }
    }


    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        System.out.println("异常消息=" + cause.getMessage());
        ctx.close();
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MessageProtocol msg) throws Exception {

    }
}
