package com.ljj.netty.buf;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

/**
 * @Author: liujinjian
 * @Date: 2020/8/13 12:21
 */
public class NettyByteBuf01 {

    public static void main(String[] args) {

        // 创建一个ByteBuf
        // 说明
        // 1、创建对象，该对象包含一个数组arr,是一个byte[10]
        // 2、在netty 的buffer中 不需要使用flip进行反转
        // 底层维护了readerIndex writeIndex
        // 0<=readIndex<=writeIndex<=capacity

        // 通过readIndex 和writerIndex 和capacity,将buffer分成了三个区域
        ByteBuf buffer = Unpooled.buffer(10);

        for (int i = 0; i < 10; i++) {
            buffer.writeByte(i);
        }

        System.out.println("capacity = " + buffer.capacity());
        for (int i = 0; i < buffer.capacity(); i++) {
            //
//            System.out.println(buffer.getByte(i));
            System.out.println(buffer.readByte());
        }
    }
}
