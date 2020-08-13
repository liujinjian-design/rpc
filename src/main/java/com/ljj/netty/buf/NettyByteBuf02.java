package com.ljj.netty.buf;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.util.CharsetUtil;

import static java.nio.charset.Charset.forName;

/**
 * @Author: liujinjian
 * @Date: 2020/8/13 12:36
 */
public class NettyByteBuf02 {

    public static void main(String[] args) {
        // 创建byteBuf
        ByteBuf byteBuf = Unpooled.copiedBuffer("Hello world", CharsetUtil.UTF_8);

        // 使用相关的api
        if (byteBuf.hasArray()) {
            byte[] content = byteBuf.array();

            // 将content 转成字符串
            System.out.println(new String(content, forName("UTF-8")));

            System.out.println("byteBuf=" + byteBuf);

            // 0
            System.out.println(byteBuf.arrayOffset());
            // 0
            System.out.println(byteBuf.readerIndex());
            // 11
            System.out.println(byteBuf.writerIndex());
            System.out.println(byteBuf.capacity());

            System.out.println(byteBuf.readByte());

            // 可读的字节数
            int len = byteBuf.readableBytes();
            System.out.println(len);

            // 使用for循环取出各个字节
            for (int i = 0; i < len; i++) {
                System.out.println((char) byteBuf.getByte(i));
            }

            // 按照某个范围读取
            System.out.println(byteBuf.getCharSequence(0, 4, CharsetUtil.UTF_8));
            System.out.println(byteBuf.getCharSequence(4, 6, CharsetUtil.UTF_8));
        }
    }
}
