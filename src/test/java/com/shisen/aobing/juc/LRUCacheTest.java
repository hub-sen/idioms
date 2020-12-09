package com.shisen.aobing.juc;

import org.junit.Test;

/**
 * <pre>
 * Description
 * @author shishi
 * 2020/12/9 13:49
 * </pre>
 */
public class LRUCacheTest {
    @Test
    public void testLRUCache() {
        LRUCache lruCache = new LRUCache(3);
        lruCache.put(1, 1);
        System.out.println("lruCache = " + lruCache.keySet());
        lruCache.put(2,2);
        System.out.println("lruCache = " + lruCache.keySet());
        lruCache.put(3,3);
        System.out.println("lruCache = " + lruCache.keySet());
        lruCache.put(4,4);
        System.out.println("lruCache = " + lruCache.keySet());
        lruCache.get(3);
        System.out.println("lruCache = " + lruCache.keySet());
        lruCache.get(2);
        System.out.println("lruCache = " + lruCache.keySet());
        int i = lruCache.get(1);
        System.out.println("i = " + i);
        System.out.println("lruCache = " + lruCache.keySet());
        lruCache.put(4,4);
        System.out.println("lruCache = " + lruCache.keySet());
    }
}
