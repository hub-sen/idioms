package com.shisen.aobing.hashmap;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * <pre>
 * Description
 * @author shishi
 * 2020/11/30 10:03
 * </pre>
 */
public class HashMapThread extends Thread {
    private static AtomicInteger a = new AtomicInteger();

    private static Map<Integer, Integer> map = new HashMap<>();


    @Override
    public void run() {
        while (a.get() < 100000) {
            map.put(a.get(), a.get());
            a.incrementAndGet();
        }
    }
}
