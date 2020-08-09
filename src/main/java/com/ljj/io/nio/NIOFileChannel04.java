package com.ljj.io.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

/**
 * @Author: liujinjian
 * @Date: 2020/8/4 22:56
 */
public class NIOFileChannel04 {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream("E:\\Project\\liujinjian\\rpc\\src\\main\\java\\com\\ljj\\io\\nio\\picture.png");
        FileOutputStream fileOutputStream = new FileOutputStream("E:\\Project\\liujinjian\\rpc\\src\\main\\java\\com\\ljj\\io\\nio\\picture1111.png");
        FileChannel sourceChannel = fileInputStream.getChannel();
        FileChannel destChannel = fileOutputStream.getChannel();
        destChannel.transferFrom(sourceChannel, 0, sourceChannel.size());
        sourceChannel.close();
        destChannel.close();
        fileInputStream.close();
        fileOutputStream.close();

    }
}
