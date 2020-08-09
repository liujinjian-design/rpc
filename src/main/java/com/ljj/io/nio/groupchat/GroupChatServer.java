package com.ljj.io.nio.groupchat;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;

/**
 * @Author: liujinjian
 * @Date: 2020/8/9 10:52
 */
public class GroupChatServer {

    private Selector selector;

    private ServerSocketChannel listenChannel;

    private static final int PORT = 6667;

    public GroupChatServer() {
        try {
            // 得到选择器
            this.selector = Selector.open();
            // ServerSocketChannel
            listenChannel = ServerSocketChannel.open();
            // 绑定端口
            listenChannel.socket().bind(new InetSocketAddress(PORT));
            listenChannel.configureBlocking(false);
            listenChannel.register(selector, SelectionKey.OP_ACCEPT);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void listen() throws IOException {
        while (true) {
            int count = selector.select(2000);
            // 有事件处理
            if (count > 0) {
                Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
                while (iterator.hasNext()) {
                    SelectionKey key = iterator.next();
                    // 连接事件
                    if (key.isAcceptable()) {
                        SocketChannel sc = listenChannel.accept();
                        sc.configureBlocking(false);
                        sc.register(selector, SelectionKey.OP_READ);
                        System.out.println(sc.getRemoteAddress() + "上线");
                    }
                    // 读事件
                    if (key.isReadable()) {
                        readData(key);
                    }
                    // 当前的key删除，防止重复处理
                    iterator.remove();
                }
            } else {
                System.out.println("等待....");
            }
        }

    }

    /**
     * 读取客户端消息
     *
     * @param selectionKey
     */
    private void readData(SelectionKey selectionKey) {
        SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        try {
            int count = socketChannel.read(byteBuffer);
            if (count > 0) {
                // 把缓冲区的数据转换成字符串
                String msg = new String(byteBuffer.array());
                System.out.println("from 客户端：" + msg);
                // 向其他客户端转发消息
                sendInfoToOtherClients(msg, socketChannel);
            }
        } catch (IOException e) {
            try {
                System.out.println(socketChannel.getRemoteAddress() + "离线了。。。 ");
                // 取消注册
                selectionKey.cancel();
                // 关闭通道
                socketChannel.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }


    /**
     * 转发消息给其它客户端
     *
     * @param msg
     * @param self
     */
    private void sendInfoToOtherClients(String msg, SocketChannel self) throws IOException {
        System.out.println("服务器转发消息中");
        Iterator<SelectionKey> iterator = selector.keys().iterator();
        while (iterator.hasNext()) {
            Channel targetChannel = iterator.next().channel();
            // 排除自己
            if (targetChannel instanceof SocketChannel && targetChannel != self) {
                ByteBuffer buffer = ByteBuffer.wrap(msg.getBytes());
                // 将buffer数据写入到通道中
                SocketChannel destChannel = (SocketChannel) targetChannel;
                destChannel.write(buffer);
            }
        }

    }

    public static void main(String[] args) throws IOException {
        // 创建服务端
        GroupChatServer server = new GroupChatServer();
        server.listen();
    }
}
