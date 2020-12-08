package com.shisen.aobing.hashmap;

/**
 * <pre>
 * Description
 * @author shishi
 * 2020/11/30 10:02
 * </pre>
 */
public class HashMapTest {
    public static void main(String[] args) {
        HashMapThread hashMapThread0 = new HashMapThread();
        HashMapThread hashMapThread1 = new HashMapThread();
        HashMapThread hashMapThread2 = new HashMapThread();
        HashMapThread hashMapThread3 = new HashMapThread();
        HashMapThread hashMapThread4 = new HashMapThread();
        hashMapThread0.start();
        hashMapThread1.start();
        hashMapThread2.start();
        hashMapThread3.start();
        hashMapThread4.start();
    }
}
