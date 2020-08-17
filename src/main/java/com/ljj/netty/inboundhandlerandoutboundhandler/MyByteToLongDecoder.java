package com.ljj.netty.inboundhandlerandoutboundhandler;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

/**
 * @Author: liujinjian
 * @Date: 2020/8/16 14:50
 */
public class MyByteToLongDecoder extends ByteToMessageDecoder {

    /**
     * decode会根据接收到的数据，被调用多次，直到确定没有新的元素被添加到list,后者是ByteBuf没有更多的可读字节为止
     * 如果list out不为空，就会将list的内容传递给下一个channelInboundhandler处理，该处理方法也会被调用多次
     *
     * @param ctx 上下文对象
     * @param in  入站ButeBuf
     * @param out list集合，将解码后的数据传给下一个handler
     * @throws Exception
     */
    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {

        System.out.println("MyByteToLongDecoder 被调用");
        // 因为Long 是八个字节
        if (in.readableBytes() >= 8) {
            out.add(in.readLong());
        }
    }
}
