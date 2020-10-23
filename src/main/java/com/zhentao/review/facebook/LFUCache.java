package com.zhentao.review.facebook;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;

/**
 * <b>460. LFU Cache</b> Design and implement a data structure for Least
 * Frequently Used (LFU) cache. It should support the following operations: get
 * and put.
 *
 * get(key) - Get the value (will always be positive) of the key if the key
 * exists in the cache, otherwise return -1. put(key, value) - Set or insert the
 * value if the key is not already present. When the cache reaches its capacity,
 * it should invalidate the least frequently used item before inserting a new
 * item. For the purpose of this problem, when there is a tie (i.e., two or more
 * keys that have the same frequency), the least recently used key would be
 * evicted.
 *
 * Note that the number of times an item is used is the number of calls to the
 * get and put functions for that item since it was inserted. This number is set
 * to zero when the item is removed.
 *
 *
 *
 * Follow up: Could you do both operations in O(1) time complexity?
 *
 * @author zhentao.li
 *
 */
public class LFUCache {

    public static void main(String[] args) {

    }

    private Map<Integer, Integer> kv;
    private Map<Integer, Integer> keyToCount;
    private Map<Integer, LinkedHashSet<Integer>> countToKey;
    private int capacity;
    private int min;

    public LFUCache(int capacity) {
        kv = new HashMap<>();
        keyToCount = new HashMap<>();
        countToKey = new HashMap<>();
        this.capacity = capacity;
        min = 0;
    }

    public int get(int key) {
        if (!kv.containsKey(key)) {
            return -1;
        }
        Integer value = kv.get(key);
        put(key, value);
        return value;
    }

    public void put(int key, int value) {

        if (kv.containsKey(key)) {
            kv.put(key, value);
            int count = keyToCount.get(key);
            keyToCount.put(key, count + 1);

            countToKey.get(count).remove(key);
            if (min == count && countToKey.get(min).isEmpty()) {
                countToKey.remove(min);
                min++;
            }
            countToKey.computeIfAbsent(count + 1, k -> new LinkedHashSet<>()).add(key);
        } else {
            if (kv.size() == capacity) {
                Iterator<Integer> iter = countToKey.get(min).iterator();
                Integer remove = iter.next();
                iter.remove();
                if (countToKey.get(min).isEmpty()) {
                    countToKey.remove(min);
                }
                kv.remove(remove);
            }
            kv.put(key, value);
            keyToCount.put(key, 1);
            countToKey.computeIfAbsent(1, k -> new LinkedHashSet<>()).add(key);
            min = 1;
        }
    }
}
