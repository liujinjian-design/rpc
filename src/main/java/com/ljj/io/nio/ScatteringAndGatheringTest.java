package com.ljj.io.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Arrays;

/**
 * Scattering在蒋数据写入到Buffer时，可以采用buffer数组，依次写入
 * <p>
 * Gathering:从buffer读数据时，可以采用buffer数组，依次读
 *
 * @Author: liujinjian
 * @Date: 2020/8/5 12:30
 */
public class ScatteringAndGatheringTest {

    public static void main(String[] args) throws IOException {

        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        InetSocketAddress inetSocketAddress = new InetSocketAddress(7000);
        serverSocketChannel.socket().bind(inetSocketAddress);

        ByteBuffer[] byteBuffers = new ByteBuffer[2];
        byteBuffers[0] = ByteBuffer.allocate(5);
        byteBuffers[1] = ByteBuffer.allocate(3);
        SocketChannel socketChannel = serverSocketChannel.accept();

        int messageLength = 8;
        while (true) {
            int byteRead = 0;
            while (byteRead < messageLength) {
                Long i = socketChannel.read(byteBuffers);
                // 累计读取的字节数
                byteRead += i;
                System.out.println("byteRead=" + byteRead);

                // 使用流打印 查看当前的这个buffer的position 和limit
                Arrays.asList(byteBuffers).stream().map(byteBuffer -> "position=" + byteBuffer.position() +
                        "limit=" + byteBuffer.limit()).forEach(System.out::println);

            }
            // 蒋所有的数组flip
            Arrays.asList(byteBuffers).forEach(byteBuffer -> byteBuffer.flip());

            // 蒋数据读出 显示到客户端
            long byteWrite = 0;
            while (byteRead < messageLength) {
                long i = socketChannel.write(byteBuffers);
                byteWrite += i;
            }

            // 蒋所有的buffer
            Arrays.asList(byteBuffers).stream().forEach(byteBuffer -> byteBuffer.clear());

            System.out.println("byteRead=" + byteRead + "byteWrite=" + byteWrite);

        }

    }
}
