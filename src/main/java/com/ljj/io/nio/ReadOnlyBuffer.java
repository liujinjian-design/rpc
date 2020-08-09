package com.ljj.io.nio;

import java.nio.ByteBuffer;

/**
 * @Author: liujinjian
 * @Date: 2020/8/5 12:09
 */
public class ReadOnlyBuffer {

    public static void main(String[] args) {

        ByteBuffer byteBuffer = ByteBuffer.allocate(64);

        for (int i = 0; i < 64; i++) {
            byteBuffer.put((byte) i);
        }
        byteBuffer.flip();
        byteBuffer =  byteBuffer.asReadOnlyBuffer();


        while (byteBuffer.hasRemaining()) {
            System.out.println(byteBuffer.get());
        }

        byteBuffer.put((byte) 1);
    }
}
