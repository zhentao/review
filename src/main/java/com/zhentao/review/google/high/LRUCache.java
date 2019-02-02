package com.zhentao.review.google.high;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * <b>146. LRU Cache</b>
 * 
 * <pre>
 * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.

Follow up:
Could you do both operations in O(1) time complexity?

Example:

LRUCache cache = new LRUCache( 2 );

cache.put(1, 1);
cache.put(2, 2);
cache.get(1);       // returns 1
cache.put(3, 3);    // evicts key 2
cache.get(2);       // returns -1 (not found)
cache.put(4, 4);    // evicts key 1
cache.get(1);       // returns -1 (not found)
cache.get(3);       // returns 3
cache.get(4);       // returns 4
 * 
 * </pre>
 * 
 * @author zhentao
 *
 */
public class LRUCache {
    private final ListNode head;
    private final ListNode tail;
    private final HashMap<Integer, Integer> map;
    private final HashMap<Integer, ListNode> keyToNode;
    private final int capacity;

    public LRUCache(final int capacity) {
        this.capacity = capacity;
        head = new ListNode(0);
        tail = new ListNode(0);
        head.next = tail;
        tail.prev = head;
        keyToNode = new HashMap<>();
        map = new HashMap<>();
    }

    public int get(final int key) {

        if (map.containsKey(key)) {
            moveToLast(key);
            return map.get(key);
        }
        return -1;
    }

    public void put(final int key, final int value) {
        if (capacity > 0) {
            if (map.containsKey(key)) {
                moveToLast(key);
            } else {
                if (map.size() == capacity) {
                    map.remove(head.next.key);
                    keyToNode.remove(head.next.key);
                    head.next = head.next.next;
                    head.next.prev = head;
                }

                final ListNode node = new ListNode(key);
                keyToNode.put(key, node);
                insertBeforeLast(node);
            }
            map.put(key, value);
        }
    }

    private void moveToLast(final int key) {
        final ListNode node = keyToNode.get(key);
        node.prev.next = node.next;
        node.next.prev = node.prev;

        insertBeforeLast(node);
    }

    private void insertBeforeLast(final ListNode node) {
        node.prev = tail.prev;
        node.next = tail;
        tail.prev.next = node;
        tail.prev = node;
    }

    private static class ListNode {
        ListNode prev;
        ListNode next;
        int key;

        public ListNode(final int key) {
            this.key = key;
        }

        @Override
        public int hashCode() {
            return key;
        }

        @Override
        public boolean equals(final Object other) {
            if (!(other instanceof ListNode)) {
                return false;
            }
            final ListNode that = (ListNode) other;
            return this.key == that.key;
        }

        @Override
        public String toString() {
            return String.valueOf(key);
        }
    }
}

/**
 * <pre>
 * 8. Key有过期时间的hashmap 高频 6次
题目：
面试官是个安卓组的小姐姐，45分钟，感觉答得一般，求过o 0
Create a map with expiring entries:
Example
12:00:00 - put(10, 25, 5000) 
12:00:04 - get(10) -> 25 
12:00:06 - get(10) -> null

思路：两个hash map，一个记录key，value pair，一个记录key的过期时间，get的时候检查key是否过期，如果过期了，删除key返回null
Put方法有三个参数，除了key，value还有个duration

Follow up: 采用更主动的策略删除过期的Key
思路；创建后台线程定期清理过期的Key。
用两个map，一个装<key, value>一个装<key, expiredTime>
在get中采用lazy deletion，get的时候检查key是否过期，如果过期的话两个map中都删除key，返回null。put的时候每次都更新key的expiredTime。
后台线程每过一段时间遍历所有key，调用get方法删除过期key。此处为了避免多线程冲突，Map用ConcurrentHashMap实现。
 * 
 * </pre>
 */
class MyMap<K, V> {
    Map<K, V> map;
    Map<K, Long> time;
    private static final int DEFAULT_CAPACITY = 16;
    private static final float DEFAULT_LOAD_FACTOR = 0.75f;
    private final Thread clearThread = new Thread(new Runnable() {
        @Override
        public void run() {
            while(true) {
                try {
                    Thread.sleep(5000);
                }catch(final Exception e) {
                    e.printStackTrace();
                }
                for(final K key : map.keySet()) get(key);
            }
        }
        
    });
    public MyMap() {
        this(DEFAULT_CAPACITY, DEFAULT_LOAD_FACTOR);
    }
    public MyMap(final int capacity) {
        this(capacity, DEFAULT_LOAD_FACTOR);
    }
    public MyMap(final int capacity, final float loadFactor) {
        map = new ConcurrentHashMap<>(capacity, loadFactor);
        time = new ConcurrentHashMap<>(capacity, loadFactor);
        clearThread.start();
    }
    public synchronized V get(final K key) {
        final long now = System.currentTimeMillis();
        final Long expired = time.get(key);
        if(expired == null) return null;
        if(Double.compare(now, expired) > 0) {
            map.remove(key);
            time.remove(key);
            return null;
        } else {
            return map.get(key);
        }
    }
    public V put(final K key, final V value, final long duration) {
        final long now = System.currentTimeMillis();
        final long expired = now + duration;
        time.put(key, expired);
        return map.put(key, value);
    }
}
