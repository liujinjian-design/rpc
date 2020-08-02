package com.ljj.dubbo.test;

import java.math.BigDecimal;

/**
 * @Author: liujinjian
 * @Date: 2020/7/20 15:54
 */
public class R {

    public static void main(String[] args) {

        BigDecimal bigDecimal = new BigDecimal("1005.51");

        System.out.println(bigDecimal.multiply(new BigDecimal("100")).intValue());
        System.out.println((int) (bigDecimal.floatValue() * 100.0F));
        System.out.println(bigDecimal);

        bigDecimal.max(new BigDecimal("100")).intValue();

        System.out.println(bigDecimal.intValue());

        int m = 114310;
        System.out.println(114310%8);

        System.out.println(114310/8%64);
    }
}
