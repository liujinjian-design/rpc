package com.ljj.io.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @Author: liujinjian
 * @Date: 2020/8/7 12:54
 */
public class NIOServer {

    public static void main(String[] args) throws IOException {
        // 创建ServerSocketChannel
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        // 得到一个Selector对象
        Selector selector = Selector.open();
        // 绑定一个端口6666 在服务器端监听
        serverSocketChannel.socket().bind(new InetSocketAddress(6666));
        serverSocketChannel.configureBlocking(false);
        // 把serverSocketChannel注册到selector 关心时间 OP_ACCEPT
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);


        System.out.println("注册后的selectionKey 数量=" + selector.keys().size());

        // 循环等待客户端连接
        while (true) {
            // 等待一秒，如果没有事件发生，继续
            if (selector.select(1000) == 0) {
                System.out.println("服务器等待了1s，无连接");
                continue;
            }
            // 如果返回的>0 获取到相关的seletionKey集合
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            Iterator<SelectionKey> keyIterator = selectionKeys.iterator();
            while (keyIterator.hasNext()) {
                SelectionKey selectionKey = keyIterator.next();
                // 连接事件
                if (selectionKey.isAcceptable()) {
                    // 给该客户端生一个SocketChannel
                    SocketChannel socketChannel = serverSocketChannel.accept();
                    System.out.println("客户端连接成功 生成了一个socketChannel " + socketChannel.hashCode());
                    socketChannel.configureBlocking(false);
                    // 将SocketChannel 设置为非阻塞
                    socketChannel.register(selector, SelectionKey.OP_READ, ByteBuffer.allocate(1024));
                    System.out.println("客户端连接后，注册的selectionKey 数量=" + selector.keys().size());
                }
                // 读事件
                if (selectionKey.isReadable()) {
                    // 通过key 反向获取对应的channel
                    SocketChannel channle = (SocketChannel) selectionKey.channel();
                    // 获取到channel关联的buffer
                    ByteBuffer buffer = (ByteBuffer) selectionKey.attachment();
                    channle.read(buffer);
                    System.out.println("from 客户端 " + new String(buffer.array()));
                }

                // 手动从集合中移除当前的selectionKey,防止重复操作
                keyIterator.remove();
            }
        }


    }
}
