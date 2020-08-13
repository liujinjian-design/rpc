package com.ljj.netty.http;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.*;
import io.netty.util.CharsetUtil;

/**
 * 1、SimpleChannelInBoundHandler 是 ChannelInBoundHandlerAdapter
 * 2、HttpObject 客户端和服务器端相互通讯的数据被封装成HttpObject
 *
 * @Author: liujinjian
 * @Date: 2020/8/11 22:30
 */
public class TestHttpServerHandler extends SimpleChannelInboundHandler<HttpObject> {

    /**
     * 读取客户端数据
     *
     * @param ctx
     * @param msg
     * @throws Exception
     */
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, HttpObject msg) throws Exception {
        System.out.println("对应的channel = " + ctx.channel() + " pipeline = " + ctx.pipeline()
                + " 通过pipeline获取channel " + ctx.pipeline().channel());

        System.out.println("当前ctx的handler=" + ctx.handler());

        if (msg instanceof HttpRequest) {
            System.out.println("msg类型= " + msg.getClass());
            System.out.println("客户端地址 " + ctx.channel().remoteAddress());
            // 回复信息给浏览器【http协议】
            ByteBuf content = Unpooled.copiedBuffer("hello,我是服务器", CharsetUtil.UTF_8);
            // 构造一个http的响应 即httpResponse
            DefaultFullHttpResponse response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.OK, content);
            response.headers().set(HttpHeaderNames.CONTENT_TYPE, "text/plain");
            response.headers().set(HttpHeaderNames.CONTENT_LENGTH, content.readableBytes());

            // 将构建好response返回
            ctx.writeAndFlush(response);
        }
    }
}
