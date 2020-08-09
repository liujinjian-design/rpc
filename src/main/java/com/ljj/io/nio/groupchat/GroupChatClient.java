package com.ljj.io.nio.groupchat;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 * @Author: liujinjian
 * @Date: 2020/8/9 11:28
 */
public class GroupChatClient {

    private final String HOST = "127.0.0.1";

    private final int PORT = 6667;

    private Selector selector;

    private SocketChannel socketChannel;

    private String usename;

    public GroupChatClient() {
        try {
            this.selector = Selector.open();
            socketChannel = SocketChannel.open();
            socketChannel.connect(new InetSocketAddress(HOST, PORT));
            socketChannel.configureBlocking(false);
            socketChannel.register(selector, SelectionKey.OP_READ);
            usename = socketChannel.getLocalAddress().toString().substring(1);
            System.out.println(usename + " is ok....");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 发送消息
     *
     * @param info
     */
    public void sendInfo(String info) {
        info = usename + "说：" + info;
        try {
            socketChannel.write(ByteBuffer.wrap(info.getBytes()));
        } catch (IOException e) {

        }
    }

    public void readInfo() {
        try {
            int readChannels = selector.select(2000);
            // 有可用的通道
            if (readChannels > 0) {
                Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
                while (iterator.hasNext()) {
                    SelectionKey key = iterator.next();
                    if (key.isReadable()) {
                        // 得到相关通道
                        SocketChannel sc = (SocketChannel) key.channel();
                        ByteBuffer buffer = ByteBuffer.allocate(1024);
                        sc.read(buffer);
                        String msg = new String(buffer.array());
                        System.out.println(msg.trim());
                    }
                    // 删除当前的selectionKey 防止重复操作
                    iterator.remove();
                }
            } else {
                //
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        // 启动一个客户端
        GroupChatClient chatClient = new GroupChatClient();

        // 启动一个线程 每隔三秒 读取数据
        new Thread(() -> {
            while (true) {
                chatClient.readInfo();
                try {
                    TimeUnit.SECONDS.sleep(3);
                } catch (Exception e) {

                }
            }
        }).start();

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String s = scanner.next();
            chatClient.sendInfo(s);
        }
    }
}
