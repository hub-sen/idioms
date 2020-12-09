package com.shisen.aobing.juc;

import java.util.HashMap;
import java.util.Map;

/**
 * <pre>
 * Description
 * @author shishi
 * 2020/12/9 14:07
 * </pre>
 */
public class MyLRUCache {

    /**
     * 容量
     */
    private int capacity;
    private Map<Integer, Node<Integer, Integer>> map;
    private DoubleLinkHashMap<Integer, Integer> doubleLinkHashMap;

    public MyLRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.doubleLinkHashMap = new DoubleLinkHashMap<>();
    }

    public Integer get(Integer key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        Node<Integer, Integer> node = map.get(key);

        doubleLinkHashMap.remove(node);
        doubleLinkHashMap.add(node);

        return node.value;
    }

    public void put(Integer key, Integer value) {
        if (map.containsKey(key)) {
            Node<Integer, Integer> node = map.get(key);
            node.value = value;
            map.put(key, node);
            doubleLinkHashMap.remove(node);
            doubleLinkHashMap.add(node);
        } else {
            if (map.size() == capacity) {
                Node<Integer, Integer> lastNode = doubleLinkHashMap.getLast();
                map.remove(lastNode.key);
                doubleLinkHashMap.remove(lastNode);
            }
            Node<Integer, Integer> newNode = new Node<>(key,value);
            map.put(key, newNode);
            doubleLinkHashMap.add(newNode);
        }
    }


    private class Node<k, v> {
        k key;
        v value;
        Node<k, v> pre;
        Node<k, v> next;

        public Node() {
        }

        public Node(k key, v value) {
            this.key = key;
            this.value = value;
        }
    }

    private class DoubleLinkHashMap<k, v> {
        /**
         * 头节点
         */
        private Node<k, v> head;

        /**
         * 尾节点
         */
        private Node<k, v> tail;

        DoubleLinkHashMap() {
            head = new Node<>();
            tail = new Node<>();
            head.next = tail;
            tail.pre = head;
        }

        /**
         * 头插
         *
         * @param node
         */
        void add(Node<k, v> node) {
            node.next = head.next;
            node.pre = head;
            head.next.pre = node;
            head.next = node;
        }

        /**
         * 删除
         *
         * @param node
         */
        void remove(Node<k, v> node) {
            node.pre.next = node.next;
            node.next.pre = node.pre;
            node.pre = null;
            node.next = null;
        }

        Node<k, v> getLast() {
            return tail.pre;
        }

    }


    public static void main(String[] args) {
        MyLRUCache lruCache = new MyLRUCache(3);
        lruCache.put(1, 1);
        System.out.println("lruCache.map.keySet() = " + lruCache.map.keySet());
        lruCache.put(2, 2);
        System.out.println("lruCache.map.keySet() = " + lruCache.map.keySet());
        lruCache.put(3, 3);
        System.out.println("lruCache.map.keySet() = " + lruCache.map.keySet());
        lruCache.put(4, 4);
        System.out.println("lruCache.map.keySet() = " + lruCache.map.keySet());
        lruCache.put(5, 5);
        System.out.println("lruCache.map.keySet() = " + lruCache.map.keySet());
        lruCache.get(4);
        System.out.println("lruCache.map.keySet() = " + lruCache.map.keySet());
        lruCache.put(6, 6);
        System.out.println("lruCache.map.keySet() = " + lruCache.map.keySet());

    }

}
