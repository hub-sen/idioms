package com.shi.sen.queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * <pre>
 * Description
 * @author shishi
 * 2020/12/11 15:31
 * </pre>
 */
public class BlockingQueueDemo {
    public static void main(String[] args) {
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);


        System.out.println("blockingQueue.add(\"a\") = " + blockingQueue.add("a"));
        System.out.println("blockingQueue.add(\"b\") = " + blockingQueue.add("b"));
        System.out.println("blockingQueue.add(\"c\") = " + blockingQueue.add("c"));
        System.out.println("blockingQueue.element() = " + blockingQueue.element());
        System.out.println("blockingQueue.remove() = " + blockingQueue.remove());
        System.out.println("blockingQueue.remove() = " + blockingQueue.remove());
        System.out.println("blockingQueue.remove() = " + blockingQueue.remove());


    }
}
