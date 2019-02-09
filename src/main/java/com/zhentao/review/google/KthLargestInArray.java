package com.zhentao.review.google;

import java.util.PriorityQueue;

/**
 * <b>215. Kth Largest Element in an Array</b>
 * 
 * <pre>
 * Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.

Example 1:

Input: [3,2,1,5,6,4] and k = 2
Output: 5
Example 2:

Input: [3,2,3,1,2,4,5,5,6] and k = 4
Output: 4
Note: 
You may assume k is always valid, 1 ≤ k ≤ array's length.
 * </pre>
 * 
 * @author zhentao
 *
 */
public class KthLargestInArray {
    public int findKthLargest(final int[] nums, final int k) {
        final PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (final int i : nums) {
            if (queue.size() == k) {
                if (i > queue.peek()) {
                    queue.remove();
                    queue.add(i);
                }
            } else {
                queue.add(i);
            }
        }
        return queue.peek();
    }
}
