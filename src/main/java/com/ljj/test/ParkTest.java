package com.ljj.test;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * @Author: liujinjian
 * @Date: 2020/8/12 10:46
 */
public class ParkTest {

    public static void main(String[] args) throws InterruptedException {


        Thread thread = new Thread(() -> {
            try {
                LockSupport.park();
                System.out.println("fdsafdsa");
            }catch (Exception e){

            }
        });

        thread.start();


        TimeUnit.SECONDS.sleep(5);
        thread.interrupt();

        System.out.println("hello");

    }
}
