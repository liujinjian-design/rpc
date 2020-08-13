package com.ljj.netty.groupchat;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author: LIUYUE
 * @Date: 2020/8/13 21:16
 */
public class GroupChatServerHandler extends SimpleChannelInboundHandler<String> {
    /**
     * 定义一个channel组,管理所有的channel
     */
    private static ChannelGroup channelGroup = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


    /**
     * 表示连接建立，一旦连接，第一个被执行
     * 将当前channel加入到channelGroup
     *
     * @param ctx
     * @throws Exception
     */
    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        // 将该客户端加入聊天的信息推送给其它在线的客户端
        /**
         * 该方法会将channelGroup中所有的channel遍历，并发送消息
         */
        channelGroup.writeAndFlush("【客户端】" + channel.remoteAddress() + " 加入聊天"+sdf.format(new Date())+"\n");
        channelGroup.add(channel);
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        // 获取当前channel
        Channel channel = ctx.channel();
        channelGroup.forEach(ch -> {
            // 不是当前channel,转发消息
            if (channel != ch) {
                ch.writeAndFlush("【客户】" + channel.remoteAddress() + " 发送了消息 " + msg + "\n");
            } else {
                ch.writeAndFlush("【自己发送了消息】" + msg + "\n");
            }
        });
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }

    /***
     * 表示channel处于一个活动状态
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println(ctx.channel().remoteAddress() + " 上线了");
    }

    /**
     * 表示channel处于不活动状态，提示xx离线了
     *
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        System.out.println(ctx.channel().remoteAddress() + "离线了！");
    }

    /**
     * 断开连接，将XX客户端下离开信息推送给当前在线的客户
     *
     * @param ctx
     * @throws Exception
     */
    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        channelGroup.writeAndFlush("【客户端】" + channel.remoteAddress() + "离开了\n");
        System.out.println("当前channelGroup size=" + channelGroup.size());
    }
}
