package com.ljj.netty.dubborpc.netty;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.util.concurrent.Callable;

/**
 * @Author: liujinjian
 * @Date: 2020/8/18 22:15
 */
public class NettyClientHandler extends ChannelInboundHandlerAdapter implements Callable {

    /**
     * 上下文
     */
    private ChannelHandlerContext context;
    /**
     * 返回的结果
     */
    private String result;
    /**
     * 客户端调用方法传入的参数
     */
    private String para;

    /**
     * 与服务器的连接创建后，就会被调用,这个方法是第一个被调用的
     *
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        /**
         * 因为在其他方法会使用到ctx
         */
        System.out.println("channelActive被调用");
        context = ctx;
    }

    /**
     * 收到服务器的数据后，调用方法
     *
     * @param ctx
     * @param msg
     * @throws Exception
     */
    @Override
    public synchronized void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("channelRead被调用");
        result = msg.toString();
        /**
         * 唤醒等待的线程
         */
        notify();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }

    /**
     * 被代理对象调用，发送数据给服务器，->wait ->等待被唤醒（channelRead）->返回结果
     *
     * @return
     * @throws Exception
     */
    @Override
    public synchronized Object call() throws Exception {
        System.out.println(" call1被调用 ");
        context.writeAndFlush(para);
        // 等待channelRead 方法获取到服务器的结果后，唤醒
        wait();
        System.out.println(" call2被调用 ");
        // 服务器返回的结果
        return result;
    }

    public void setPara(String para) {
        this.para = para;
    }
}
