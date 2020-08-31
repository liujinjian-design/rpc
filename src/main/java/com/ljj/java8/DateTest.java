package com.ljj.java8;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @Author: liujinjian
 * @Date: 2020/8/28 15:50
 */
public class DateTest {

    public static void main(String[] args) throws InterruptedException {


        Date currentDate = new Date();

        TimeUnit.SECONDS.sleep(1);

        System.out.println(new Date().after(currentDate));
    }
}
