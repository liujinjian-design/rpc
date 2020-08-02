package com.ljj.test;

import java.math.BigDecimal;

/**
 * @Author: liujinjian
 * @Date: 2020/7/29 21:05
 */
public class Test {


    public static void main(String[] args) {

        BigDecimal amount = new BigDecimal(1.00);
        int m = amount.multiply(new BigDecimal("100")).intValue();

        System.out.println(m);
        Thread thread = new Thread();

        System.out.println(thread.getContextClassLoader());
    }
}
