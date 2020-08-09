package com.ljj.io.nio;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @Author: liujinjian
 * MappedByteBuffer 可以让文件直接在内存（对外内存）中修改，操作系统不需要copy一次
 * @Date: 2020/8/5 12:16
 */
public class MappedByteBufferTest {


    public static void main(String[] args) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile("E:\\Project\\liujinjian\\rpc\\src\\main\\java\\com\\ljj\\io\\nio\\1.txt", "rw");

        // 获取对应的通道
        FileChannel fileChannel = randomAccessFile.getChannel();

        // 参数说明 1-读写模式 2-可以直接修改的位置 3-映射内存的大小，即将1.txt的多少个字节映射到内存 可以直接修改的范围0-5
        MappedByteBuffer mappedByteBuffer = fileChannel.map(FileChannel.MapMode.READ_WRITE, 0, 5);

        mappedByteBuffer.put(0, (byte) 'H');
        mappedByteBuffer.put(3, (byte) '9');

        mappedByteBuffer.force();

        randomAccessFile.close();


    }

}
