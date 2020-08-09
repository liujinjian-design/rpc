package com.ljj.io.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @Author: liujinjian
 * @Date: 2020/8/4 22:40
 */
public class NIOFilechannel03 {

    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream("E:\\Project\\liujinjian\\rpc\\src\\main\\java\\com\\ljj\\io\\nio\\1.txt");
        FileChannel fileChannel = fileInputStream.getChannel();
        FileOutputStream fileOutputStream = new FileOutputStream("E:\\Project\\liujinjian\\rpc\\src\\main\\java\\com\\ljj\\io\\nio\\2.txt");
        FileChannel fileChannel02 = fileOutputStream.getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(512);
        while (true) {
            // 这里有一个重要的操作，一定不要忘了
            byteBuffer.clear();
            int read = fileChannel.read(byteBuffer);
            if (read == -1) {
                break;
            }
            // 将buffer中的数据写入到fileChannel02---2.txt
            byteBuffer.flip();
            fileChannel02.write(byteBuffer);
        }
        fileChannel.close();
        fileChannel02.close();
    }
}
