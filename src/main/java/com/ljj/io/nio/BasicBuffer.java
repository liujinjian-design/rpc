package com.ljj.io.nio;

import java.nio.IntBuffer;

/**
 * @Author: liujinjian
 * @Date: 2020/8/3 22:03
 */
public class BasicBuffer {

    public static void main(String[] args) {
        // 举例说明 创建一个buffer

        // 创建一个buffer,大小为5，可以存放五个int
        IntBuffer intBuffer = IntBuffer.allocate(5);
//
//        // 像buffer中存放数据
//        intBuffer.put(10);
//        intBuffer.put(11);
//        intBuffer.put(12);
//        intBuffer.put(13);
//        intBuffer.put(14);
//        intBuffer.put(16);

        for (int i = 0; i < intBuffer.capacity(); i++) {
            intBuffer.put(i * 2);
        }

        intBuffer.flip();

        intBuffer.position(1);
        intBuffer.limit(3);
        while (intBuffer.hasRemaining()) {
            System.out.println(intBuffer.get());
        }

        System.out.println(intBuffer);

    }
}
