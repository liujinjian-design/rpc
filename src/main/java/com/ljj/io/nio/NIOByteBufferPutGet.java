package com.ljj.io.nio;

import java.nio.ByteBuffer;

/**
 * @Author: liujinjian
 * @Date: 2020/8/5 12:03
 */
public class NIOByteBufferPutGet {

    public static void main(String[] args) {

        ByteBuffer buffer = ByteBuffer.allocate(64);
        buffer.putInt(100);
        buffer.putLong(9L);
        buffer.putChar('刘');
        buffer.putShort((short) 4);

        buffer.flip();

        System.out.println(buffer.getLong());
        System.out.println(buffer.getLong());
        System.out.println(buffer.getChar());
        System.out.println(buffer.getShort());
    }
}
