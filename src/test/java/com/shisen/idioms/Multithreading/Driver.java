package com.shisen.idioms.Multithreading;

import org.junit.Test;

import java.util.concurrent.CountDownLatch;

public class Driver { // ...

    @Test
    public void start()  throws InterruptedException {
        CountDownLatch startSignal = new CountDownLatch(1);
        CountDownLatch doneSignal = new CountDownLatch(5);

        for (int i = 0; i < 5; ++i) // create and start threads
            new Thread(()->{
                /*try {
                    startSignal.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }*/
                doWork();
                doneSignal.countDown();
            }).start();

        startSignal.countDown();      // let all threads proceed
        doneSignal.await();           // wait for all to finish
    }

    void doWork() {
        System.out.println("worker");
    }
}