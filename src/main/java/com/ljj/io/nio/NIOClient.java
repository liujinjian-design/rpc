package com.ljj.io.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * @Author: liujinjian
 * @Date: 2020/8/8 9:11
 */
public class NIOClient {

    public static void main(String[] args) throws IOException {
        // 得到一个网络通道
        SocketChannel socketChannel = SocketChannel.open();

        // 设置非阻塞模式
        socketChannel.configureBlocking(false);

        InetSocketAddress inetSocketAddress = new InetSocketAddress("127.0.0.1", 6666);

        // 连接服务器
        if (!socketChannel.connect(inetSocketAddress)) {
            while (!socketChannel.finishConnect()) {
                System.out.println("因为连接需要时间，客户端不需要阻塞，可以做其他工作");
            }
        }

        // 如果连接成功，就发送数据
        String str = "hello,尚硅谷--";

        ByteBuffer buffer = ByteBuffer.wrap(str.getBytes());
        // 发送数据，将buffer数据写入channel
        socketChannel.write(buffer);

        System.in.read();


    }
}
