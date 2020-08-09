package com.ljj.io.nio;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @Author: liujinjian
 * @Date: 2020/8/4 22:22
 */
public class NIOFileChannel02 {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream("E:\\Project\\liujinjian\\rpc\\src\\main\\java\\com\\ljj\\io\\nio\\file01.txt");
        FileChannel fileChannel = fileInputStream.getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        fileChannel.read(byteBuffer);
        String s = new String(byteBuffer.array());
        System.out.println(s);
        fileChannel.close();
    }
}
