package com.ljj.dubbo.test;

import java.math.BigDecimal;

/**
 * @Author: liujinjian
 * @Date: 2020/7/27 11:20
 */
public class DubboTest {

    public static void main(String[] args) {

        long m = 100635127 % 8;
        long s = 100635127 / 8 % 64;
        System.out.println(m);
        System.out.println(s);

        long d = 920073118456002523L % 8;
        long b = 920073118456002523L / 8 % 64;
        System.out.println(d);
        System.out.println(b);


        BigDecimal bigDecimal = new BigDecimal("1.2");
        BigDecimal cc = new BigDecimal("0.6");

        System.out.println(bigDecimal.divide(new BigDecimal(2)).equals(cc));
        System.out.println(System.currentTimeMillis());

    }

    private static class C {
        private int c;

        public int getC() {
            return c;
        }

        public void setC(int c) {
            this.c = c;
        }
    }
}
