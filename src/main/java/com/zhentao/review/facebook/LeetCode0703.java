package com.zhentao.review.facebook;

import java.util.PriorityQueue;

/**
 * 703. Kth Largest Element in a Stream
 *
 *
 * Design a class to find the kth largest element in a stream. Note that it is
 * the kth largest element in the sorted order, not the kth distinct element.
 *
 * Your KthLargest class will have a constructor which accepts an integer k and
 * an integer array nums, which contains initial elements from the stream. For
 * each call to the method KthLargest.add, return the element representing the
 * kth largest element in the stream.
 *
 * <pre>
Example:

int k = 3;
int[] arr = [4,5,8,2];
KthLargest kthLargest = new KthLargest(3, arr);
kthLargest.add(3);   // returns 4
kthLargest.add(5);   // returns 5
kthLargest.add(10);  // returns 5
kthLargest.add(9);   // returns 8
kthLargest.add(4);   // returns 8
 * </pre>
 *
 * Note: You may assume that nums' length ≥ k-1 and k ≥ 1.
 *
 * @author zhentao.li
 *
 */
public class LeetCode0703 {
    private PriorityQueue<Integer> heap;
    private final int size;

    public LeetCode0703(int k, int[] nums) {
        heap = new PriorityQueue<>(k);
        size = k;
        for (int n : nums) {
            heap.add(n);
        }
    }

    public int add(int val) {
        if (heap.size() < size) {
            heap.add(val);
            //heap.offer(val)
        } else if (val > heap.peek()) {
            heap.remove();
            //heap.poll();
            heap.add(val);
        }
        return heap.peek();
    }
}
