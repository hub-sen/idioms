package com.shi.sen.queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * <pre>
 * Description
 * @author shishi
 * 2020/12/11 17:04
 * </pre>
 */
public class ProdConsumerBlockQueueDemo {

    public static void main(String[] args) {

        ShareResource shareResource = new ShareResource(new ArrayBlockingQueue<>(3));

        new Thread(()->{
            try {
                shareResource.prod();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"prod").start();

        new Thread(()->{
            try {
                shareResource.consumer();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"consumer").start();

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        shareResource.stop();

    }

}

class ShareResource {
    private volatile boolean FLAG = true;
    private AtomicInteger atomicInteger = new AtomicInteger();
    private BlockingQueue<String> blockingQueue = null;

    public ShareResource(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    public void prod() throws InterruptedException {

        String data;

        boolean flag;
        while (FLAG) {
            data = atomicInteger.incrementAndGet() + "";

            TimeUnit.SECONDS.sleep(1);

            flag = blockingQueue.offer(data, 2L, TimeUnit.SECONDS);

            if (flag) {
                System.out.println(Thread.currentThread().getName() + "生产者生产成功 = " + data);
            } else {
                System.out.println(Thread.currentThread().getName() + "生产者生产失败 = " + data);
            }

        }
    }

    public void consumer() throws InterruptedException {
        String poll;
        while (FLAG) {
            TimeUnit.SECONDS.sleep(1);
            poll = blockingQueue.poll(2L, TimeUnit.SECONDS);
            if (null == poll || "".equalsIgnoreCase(poll)) {
                System.out.println(Thread.currentThread().getName() + "消费者消费失败 = " + poll);
            }
            System.out.println(Thread.currentThread().getName() + "消费者消费成功 = " + poll);
        }
    }

    public void stop() {
        this.FLAG = false;
    }

}
