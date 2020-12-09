package com.shisen.aobing.juc;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * <pre>
 * Description
 * @author shishi
 * 2020/12/9 13:41
 * </pre>
 */
public class LRUCache extends LinkedHashMap<Integer, Integer> {

    int capacity;

    public LRUCache(int capacity){
        super(capacity, 0.75f, true);
        this.capacity = capacity;
    }

    public int get(int key) {
        return getOrDefault(key, -1);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return super.size() > capacity;
    }
}
