package com.zhentao.review;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class PowerSet {
    public static void main(String[] args) {
        Set<String> input = new LinkedHashSet<String>();
        input.add("a");
        input.add("b");
        input.add("c");
        //input.add("d");
        Set<Set<String>> set = myPowerSet(input);
        System.out.println(set.size());
//        for (Set<String> child : set) {
//            System.out.println(child);
//        }
        System.out.println(5 & 3);
    }


    public static <T> Set<Set<T>> myPowerSet(Set<T> originalSet) {
        Set<Set<T>> sets = new HashSet<Set<T>>();
        if (originalSet.isEmpty()) {
            sets.add(Collections.<T>emptySet());
            return sets;
        }
        Iterator<T> iter = originalSet.iterator();
        System.out.println("original: " + originalSet);
        T head = iter.next();
        //iter.remove();//remove head
        originalSet.remove(head);

        for (Set<T> set : myPowerSet(originalSet)) {
            Set<T> newSet = new HashSet<T>();
            newSet.add(head);
            newSet.addAll(set);
            sets.add(newSet);
            sets.add(set);
        }
        return sets;
    }

    public static <T> Set<Set<T>> myPowerSet2(Set<T> originalSet) {
        @SuppressWarnings("unchecked")
        T[] array = (T[])originalSet.toArray();
        int size = originalSet.size();
        Set<Set<T>> sets = new LinkedHashSet<Set<T>>();
        int power = 1 << size; //2^size
        sets.add(Collections.<T>emptySet());
        for (int i = 1; i < power; i++) {
            Set<T> subset = new LinkedHashSet<T>();
            for (int shift = 0; shift < size; shift++) {
                if ((i & (1 << shift)) != 0) {//if the bit is 1 or not
                    subset.add(array[shift]);
                }
            }
            sets.add(subset);
        }

        return sets;
    }
}
