package com.zhentao.review;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

/**
 * This is the random set implementation which supports the following 3 operations in O(1) run time
 * add add an element
 * delete delete an element
 * get get a random element from the set
 *
 * @author liz
 *
 * @param <T>
 */
public class RandomSet<T> {
    private final Map<T, Integer> map = new HashMap<T, Integer>();
    private final ArrayList<T> list = new ArrayList<T>();

    public static void main(String[] args) {
        RandomSet<String> set = new RandomSet<>();
        set.add("a");
        set.remove("a");
        System.out.print(set.map.size());
    }
    public void add(T t) {
        if (!map.containsKey(t)) {
            list.add(t);
            map.put(t, list.size() - 1);
        }
    }

    public void remove(T t) {
        if (map.containsKey(t)) {
            replaceTargetByLast(t);
            map.remove(t);
            list.remove(list.size() - 1);
        }
    }

    private void replaceTargetByLast(final T t) {
        int index = map.get(t);
        T last = list.get(list.size() - 1);
        list.set(index, last);
        map.put(last, index);
    }

    public T get() {
        return list.isEmpty() ?  null : list.get(ThreadLocalRandom.current().nextInt(list.size()));
    }
}
