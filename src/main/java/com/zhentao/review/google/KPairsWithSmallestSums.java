package com.zhentao.review.google;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 * <b>Find K Pairs with Smallest Sums</b>
 * 
 * <pre>
 * You are given two integer arrays nums1 and nums2 sorted in ascending order and an integer k.

Define a pair (u,v) which consists of one element from the first array and one element from the second array.

Find the k pairs (u1,v1),(u2,v2) ...(uk,vk) with the smallest sums.

Example 1:

Input: nums1 = [1,7,11], nums2 = [2,4,6], k = 3
Output: [[1,2],[1,4],[1,6]] 
Explanation: The first 3 pairs are returned from the sequence: 
             [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
Example 2:

Input: nums1 = [1,1,2], nums2 = [1,2,3], k = 2
Output: [1,1],[1,1]
Explanation: The first 2 pairs are returned from the sequence: 
             [1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]
Example 3:

Input: nums1 = [1,2], nums2 = [3], k = 3
Output: [1,3],[2,3]
Explanation: All possible pairs are returned from the sequence: [1,3],[2,3]
 * </pre>
 * 
 * @author zhentao
 *
 */
public class KPairsWithSmallestSums {
    public List<int[]> kSmallestPairs(final int[] nums1, final int[] nums2, int k) {
        final int length1 = nums1.length;
        final int length2 = nums2.length;
        if (length1 == 0 || length2 == 0 || k == 0) {
            return Collections.emptyList();
        }
        final List<int[]> list = new ArrayList<>();
        final PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> ( a[0] + a[1] - b[0] - b[1]));
        for (int i = 0; i < length1 && i < k; i++) {
            queue.add(new int[] { nums1[i], nums2[0], 0 });
        }
        while (k > 0 && !queue.isEmpty()) {
            final int[] node = queue.poll();
            list.add(new int[] { node[0], node[1] });
            k--;
            if (node[2] == length2 - 1) {
                continue;
            }
            queue.add(new int[] { nums1[0], nums2[node[2] + 1], node[2] + 1 });
        }
        return list;
    }
}
