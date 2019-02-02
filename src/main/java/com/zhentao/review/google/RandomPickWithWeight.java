package com.zhentao.review.google;

import java.util.TreeMap;
import java.util.concurrent.ThreadLocalRandom;

/**
 * <b>528. Random Pick with Weight</b>
 * 
 * <pre>
 * Given an array w of positive integers, where w[i] describes the weight of index i, 
 * write a function pickIndex which randomly picks an index in proportion to its weight.

Note:

1 <= w.length <= 10000
1 <= w[i] <= 10^5
pickIndex will be called at most 10000 times.
Example 1:

Input: 
["Solution","pickIndex"]
[[[1]],[]]
Output: [null,0]
Example 2:

Input: 
["Solution","pickIndex","pickIndex","pickIndex","pickIndex","pickIndex"]
[[[1,3]],[],[],[],[],[]]
Output: [null,0,1,1,1,0]
Explanation of Input Syntax:
 * 
 * </pre>
 * 
 * @author zhentao
 *
 */
public class RandomPickWithWeight {
    private final TreeMap<Integer, Integer> map;
    private int totalWeight;
    public RandomPickWithWeight(final int[] w) {
        map = new TreeMap<>();
        totalWeight = 0;
        for (int i = 0; i < w.length; i++) {
            totalWeight += w[i];
            map.put(totalWeight, i);
        }
    }

    public int pickIndex() {
        final int random = ThreadLocalRandom.current().nextInt(totalWeight) + 1;
        final int key = map.ceilingKey(random);
        return map.get(key);
    }
}
