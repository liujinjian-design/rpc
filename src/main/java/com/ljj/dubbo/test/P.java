package com.ljj.dubbo.test;

import java.math.BigDecimal;

/**
 * @Author: liujinjian
 * @Date: 2020/7/23 15:11
 */
public class P {

    public static void main(String[] args) {

        BigDecimal bigDecimal = new BigDecimal("1.00");

        int m = 100;

        BigDecimal bd = new BigDecimal("100");

        boolean fds = AmountTransferUtil.transferYuanToFen(bigDecimal) * m == AmountTransferUtil.transferYuanToFen(bd);

        System.out.println(fds);


    }
}
