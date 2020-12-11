package com.shi.sen.juc;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * <pre>
 * Description
 * @author shishi
 * 2020/12/11 10:14
 * </pre>
 */
public class ReadWriteLockDemo {


    public static void main(String[] args) {
        MyCache myCache = new MyCache();

        for (int i = 0; i < 5; i++) {
            int finalI = i;
            new Thread(() -> myCache.put(finalI + "", finalI + ""), "" + i).start();
        }

        for (int i = 0; i < 5; i++) {
            int finalI = i;
            new Thread(() -> myCache.get(finalI + ""), "" + i).start();
        }
    }


}


class MyCache {
    private volatile Map<String, Object> cache = new HashMap<>();

    private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    public void put(String key, Object val) {

        readWriteLock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + "\t开始写入: " + key);
            TimeUnit.MILLISECONDS.sleep(300);
            cache.put(key, val);
            System.out.println(Thread.currentThread().getName() + "\t写入完成");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            readWriteLock.writeLock().unlock();
        }

    }


    public void get(String key) {

        readWriteLock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + "\t开始读取");
            TimeUnit.MILLISECONDS.sleep(300);
            Object result = cache.get(key);
            System.out.println(Thread.currentThread().getName() + "\t读取完成: " + result);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            readWriteLock.readLock().unlock();
        }

    }
}