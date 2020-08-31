package com.ljj.offer;

/**
 * @Author: liujinjian
 * @Date: 2020/8/26 16:20
 */
public class DeadLock {

    public static void main(String[] args) {

        final Object lockObjectA = new Object();
        final Object lockObjectB = new Object();

        new Thread(() -> {
            synchronized (lockObjectA) {
                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lockObjectB) {
                    System.out.println("lockObjectA->lockObjectB");
                }
            }
        }).start();

        new Thread(() -> {
            synchronized (lockObjectB) {
                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lockObjectA) {
                    System.out.println("lockObjectB->lockObjectA");
                }
            }
        }).start();

    }
}
