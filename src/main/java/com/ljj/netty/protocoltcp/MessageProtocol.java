package com.ljj.netty.protocoltcp;

/**
 * @Author: liujinjian
 * 协议包
 * @Date: 2020/8/17 12:27
 */
public class MessageProtocol {

    private int len;

    private byte[] content;

    public int getLen() {
        return len;
    }

    public void setLen(int len) {
        this.len = len;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }
}
