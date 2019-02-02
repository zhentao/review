package com.zhentao.review.google;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ThreadLocalRandom;

public class RandomizedSet {
    // key: val, value: index in arraylist
    private final HashMap<Integer, Integer> map;
    private final ArrayList<Integer> list;

    /** Initialize your data structure here. */
    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain
     * the specified element.
     */
    public boolean insert(final int val) {
        final boolean result = map.containsKey(val);

        if (!result) {
            map.put(val, list.size());
            list.add(val);
        }
        return !result;
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified
     * element.
     */
    public boolean remove(final int val) {
        final boolean result = map.containsKey(val);
        if (result) {
            final int index = map.remove(val);
            swapAndRemove(index);
        }
        return result;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        final int randomIndex = ThreadLocalRandom.current().nextInt(list.size());
        return list.get(randomIndex);
    }

    private void swapAndRemove(final int index) {
        final int size = list.size();
        if (index != size - 1) {
            final Integer value = list.get(size-1);
            list.set(index, value);
            map.put(value, index);
        }
        list.remove(size-1);
    }
}
