package com.zhentao.review.google;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.ThreadLocalRandom;

/**
 * <b>381. Insert Delete GetRandom O(1) - Duplicates allowed</b>
 * 
 * <pre>
 * Design a data structure that supports all following operations in average O(1) time.

Note: Duplicate elements are allowed.
insert(val): Inserts an item val to the collection.
remove(val): Removes an item val from the collection if present.
getRandom: Returns a random element from current collection of elements. The probability of each element being returned is linearly related to the number of same value the collection contains.
Example:

// Init an empty collection.
RandomizedCollection collection = new RandomizedCollection();

// Inserts 1 to the collection. Returns true as the collection did not contain 1.
collection.insert(1);

// Inserts another 1 to the collection. Returns false as the collection contained 1. Collection now contains [1,1].
collection.insert(1);

// Inserts 2 to the collection, returns true. Collection now contains [1,1,2].
collection.insert(2);

// getRandom should return 1 with the probability 2/3, and returns 2 with the probability 1/3.
collection.getRandom();

// Removes 1 from the collection, returns true. Collection now contains [1,2].
collection.remove(1);

// getRandom should return 1 and 2 both equally likely.
collection.getRandom();
 * </pre>
 * 
 * @author zhentao
 *
 */
public class RandomizedCollection {
    private final HashMap<Integer, HashSet<Integer>> map;
    private final ArrayList<Integer> list;

    /** Initialize your data structure here. */
    public RandomizedCollection() {
        map = new HashMap<>();
        list = new ArrayList<>();
    }

    /**
     * Inserts a value to the collection. Returns true if the collection did not
     * already contain the specified element.
     */
    public boolean insert(final int val) {
        final boolean result = map.containsKey(val);

        HashSet<Integer> set;
        if (!result) {
            set = new HashSet<>();
            map.put(val, set);
        } else {
            set = map.get(val);
        }
        set.add(list.size());
        list.add(val);
        return !result;
    }

    /**
     * Removes a value from the collection. Returns true if the collection contained
     * the specified element.
     */
    public boolean remove(final int val) {
        final boolean result = map.containsKey(val);
        if (result) {
            final Iterator<Integer> iter = map.get(val).iterator();
            final int index = iter.next();
            if (!iter.hasNext()) {
                map.remove(val);
            } else {
                iter.remove();
            }
            swapAndRemove(index);
        }
        return result;
    }

    private void swapAndRemove(final int index) {
        final int size = list.size();
        if (index != size - 1) {
            final Integer value = list.get(size - 1);
            list.set(index, value);
            final HashSet<Integer> set = map.get(value);
            set.remove(size - 1);
            set.add(index);
        }
        list.remove(size - 1);
    }

    /** Get a random element from the collection. */
    public int getRandom() {
        final int randomIndex = ThreadLocalRandom.current().nextInt(list.size());
        return list.get(randomIndex);
    }
}
