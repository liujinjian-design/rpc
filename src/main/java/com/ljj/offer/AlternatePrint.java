package com.ljj.offer;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: liujinjian
 * @Date: 2020/8/26 16:24
 */
public class AlternatePrint {

    public static void main(String[] args) {

        final Object lock = new Object();

        final AtomicInteger atomicInteger = new AtomicInteger();

        AtomicBoolean atomicBoolean = new AtomicBoolean();

        new Thread(() -> {
            while (true) {
                synchronized (lock) {
                    while (atomicBoolean.get()) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println(Thread.currentThread().getName() + ":" + atomicInteger.incrementAndGet());
                    atomicBoolean.set(true);
                    lock.notifyAll();
                }
            }
        }, "A").start();

        new Thread(() -> {
            while (true) {
                synchronized (lock) {
                    while (!atomicBoolean.get()) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println(Thread.currentThread().getName() + ":" + atomicInteger.incrementAndGet());
                    atomicBoolean.set(false);
                    lock.notifyAll();
                }
            }
        }, "B").start();
    }
}
