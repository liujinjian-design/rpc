package com.ljj.io.bio;

import java.io.IOException;
import java.net.Socket;

/**
 * @Author: liujinjian
 * @Date: 2020/8/12 16:46
 */
public class SocketClient {


    private static Socket[] clients = new Socket[30];

    public static void main(String[] args) throws IOException {
        for (int i = 0; i < 30; i++) {
            clients[i++] = new Socket("127.0.0.1", 8888);
            System.out.println("client connection:" + i);
        }
    }
}
