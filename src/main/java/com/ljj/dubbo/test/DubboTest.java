package com.ljj.dubbo.test;

import java.math.BigDecimal;

/**
 * @Author: liujinjian
 * @Date: 2020/7/27 11:20
 */
public class DubboTest {

    public static void main(String[] args) {

        long m = 100000487515L % 8;
        long s = 100000487515L / 8 % 12;
        System.out.println(m);
        System.out.println(s);

        long d = 3400 % 8;
        long b = 3400 / 8 % 12;
        System.out.println(d);
        System.out.println(b);


        long d2 = 9200901421262390718L % 8;
        long b2 = 9200901421262390718L / 8 % 4;
        System.out.println(d2);
        System.out.println(b2);



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
