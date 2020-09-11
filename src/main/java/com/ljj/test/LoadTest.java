package com.ljj.test;

/**
 * @Author: liujinjian
 * @Date: 2020/9/6 9:50
 */
public class LoadTest {


    static {
        System.out.println("n你好");
    }


    {
        System.out.println("代码块");
    }

    public static void main(String[] args) {

        LoadTest loadTest = new LoadTest();
        LoadTest loadTest1 = new LoadTest();

    }
}
