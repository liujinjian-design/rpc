package com.ljj.netty.inboundhandlerandoutboundhandler;

import io.netty.buffer.ByteBuf;
import io.netty.handler.codec.ReplayingDecoder;

import java.util.List;


/**
 * @Author: liujinjian
 * @Date: 2020/8/16 17:10
 */
public class MyByteToLongDecoder2 extends ReplayingDecoder<Void> {


    @Override
    protected void decode(io.netty.channel.ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        System.out.println("MyByteToLongDecoder2 被调用");
        out.add(in.readLong());
    }
}
