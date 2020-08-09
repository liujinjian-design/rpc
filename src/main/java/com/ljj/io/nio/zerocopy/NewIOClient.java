package com.ljj.io.nio.zerocopy;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;

/**
 * @Author: liujinjian
 * @Date: 2020/8/9 16:42
 */
public class NewIOClient {

    public static void main(String[] args) throws IOException {

        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.connect(new InetSocketAddress("localhost", 7001));
        String filename = "1.txt";
        // 得到一个文件channel
        FileChannel fileChannel = new FileInputStream(filename).getChannel();

        // 准备发送
        long start = System.currentTimeMillis();
        // 在linux下一个transfer方法就可以完成传输
        // 在windows下一次调用transferTo只能发送8M文件 需要分段传输文件 而且要传输时的位置
        // transferTo底层使用的零拷贝
        long transferCount = fileChannel.transferTo(0, fileChannel.size(), socketChannel);

        System.out.println("发送的总的字节数 = " + transferCount + "耗时 = " + (System.currentTimeMillis() - start));

        fileChannel.close();


    }
}
