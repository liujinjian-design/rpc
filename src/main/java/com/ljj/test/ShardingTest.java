package com.ljj.test;

/**
 * @Author: liujinjian
 * @Date: 2020/9/10 10:19
 */
public class ShardingTest {

    public static void main(String[] args) {

        int i = (int) (12000000318L % 8);
        int j = (int) (12000000318L / 8 % 12);

        System.out.println(i);

        System.out.println(j);

    }
}
