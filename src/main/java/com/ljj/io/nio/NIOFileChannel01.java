package com.ljj.io.nio;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @Author: liujinjian
 * @Date: 2020/8/4 21:13
 */
public class NIOFileChannel01 {

    public static void main(String[] args) throws IOException {
        String str = "Hello,尚硅谷";
        // 创建一个输出流->channel
        FileOutputStream filterOutputStream = new FileOutputStream("E:\\Project\\liujinjian\\rpc\\src\\main\\java\\com\\ljj\\io\\nio\\file01.txt");
        // 通过fileOutputStream获取对应的FileChannel
        // 这个fileChannel真实类型是FileChannelImpl
        FileChannel fileChannel = filterOutputStream.getChannel();
        // 创建一个缓冲区 ByteBuffer
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        // 将str放入byteBuffer
        byteBuffer.put(str.getBytes());
        //
        byteBuffer.flip();
        fileChannel.write(byteBuffer);
        fileChannel.close();

    }
}
