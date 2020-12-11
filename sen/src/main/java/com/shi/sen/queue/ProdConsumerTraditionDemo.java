package com.shi.sen.queue;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * <pre>
 * Description
 * @author shishi
 * 2020/12/11 16:15
 * </pre>
 */
public class ProdConsumerTraditionDemo {

    public static void main(String[] args) {
        ShareData shareData = new ShareData();
        new Thread(()->{
            for (int i = 0; i < 5; i++) {
                shareData.increment();
            }

        },"AAA").start();

        new Thread(()->{
            for (int i = 0; i < 5; i++) {
                shareData.decrement();

            }
        },"BBB").start();
    }
}

class ShareData{
    private int data = 0;

    private ReentrantLock reentrantLock = new ReentrantLock();
    private Condition condition = reentrantLock.newCondition();


    /**
     * 生产
     */
    public void increment() {
        reentrantLock.lock();
        try {
            while (data != 0) {
                condition.await();
            }
            data++;
            System.out.println(Thread.currentThread().getName() + "data = " + data);
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            reentrantLock.unlock();
        }
    }

    /**
     * 消费
     */
    public void decrement() {
        reentrantLock.lock();
        try {
            while (data == 0) {
                condition.await();
            }
            data--;
            System.out.println(Thread.currentThread().getName() + "data = " + data);
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            reentrantLock.unlock();
        }
    }


}