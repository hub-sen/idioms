package com.shisen.aobing.juc;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * <pre>
 * Description
 * @author shishi
 * 2020/12/7 16:34
 * </pre>
 */
public class Test01 {
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();

        new Thread(() -> {
            lock.lock();

            try {
                System.out.println("顾客A");
                try {
                    TimeUnit.MINUTES.sleep(20);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } finally {
                lock.unlock();
            }
        }, "A").start();


        new Thread(()->{
            lock.lock();
            try {
                System.out.println("顾客B");

            }finally {
                lock.unlock();
            }
        },"B").start();


    }
}
