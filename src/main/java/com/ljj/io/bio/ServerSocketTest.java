package com.ljj.io.bio;

import java.io.IOException;
import java.net.ServerSocket;

/**
 * @Author: liujinjian
 * @Date: 2020/8/12 16:45
 */
public class ServerSocketTest {

    public static void main(String[] args) throws IOException, InterruptedException {

        ServerSocket serverSocket = new ServerSocket(8888, 8);
        serverSocket.accept();
        System.in.read();


    }
}
