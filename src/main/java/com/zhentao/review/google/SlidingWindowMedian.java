package com.zhentao.review.google;

import java.util.PriorityQueue;

/**
 * <b>480. Sliding Window Median</b>
 * 
 * <pre>
 * Median is the middle value in an ordered integer list. If the size of the list is even, 
 * there is no middle value. So the median is the mean of the two middle value.

Examples: 
[2,3,4] , the median is 3

[2,3], the median is (2 + 3) / 2 = 2.5

Given an array nums, there is a sliding window of size k which is moving from the very left of 
the array to the very right. You can only see the k numbers in the window. Each time the sliding 
window moves right by one position. Your job is to output the median array for each window in 
the original array.

For example,
Given nums = [1,3,-1,-3,5,3,6,7], and k = 3.

Window position                Median
---------------               -----
[1  3  -1] -3  5  3  6  7       1
 1 [3  -1  -3] 5  3  6  7       -1
 1  3 [-1  -3  5] 3  6  7       -1
 1  3  -1 [-3  5  3] 6  7       3
 1  3  -1  -3 [5  3  6] 7       5
 1  3  -1  -3  5 [3  6  7]      6
Therefore, return the median sliding window as [1,-1,-1,3,5,6].

Note: 
You may assume k is always valid, ie: k is always smaller than input array's size for non-empty array.
 * </pre>
 * 
 * @author zhentao
 *
 */
public class SlidingWindowMedian {

    public double[] medianSlidingWindow(final int[] nums, final int k) {
        final double[] medians = new double[nums.length - k + 1];
        //it means all elements in min heap is greater than or equal to max heap
        final PriorityQueue<Integer> minHeap = new PriorityQueue<>(); // min heap: the smallest element is the root
        final PriorityQueue<Integer> maxHeap = new PriorityQueue<>((x, y) -> y.compareTo(x)); // max heap: the largest element is the root
        for (int i = 0; i < k; i++) {
            addNumber(nums[i], minHeap, maxHeap);
        }
        
        medians[0] = getMedian(minHeap, maxHeap);
        
        for (int i = k; i < nums.length; i++) {
            removeNumber(nums[i-k],minHeap,maxHeap);
            addNumber(nums[i], minHeap, maxHeap);
            medians[i-k+1] = getMedian(minHeap, maxHeap);
        }
        return medians;
    }

    private void addNumber(final int num, final PriorityQueue<Integer> minHeap, final PriorityQueue<Integer> maxHeap) {
        //max heap has same size of min heap, or 1 more
        if (minHeap.size() == maxHeap.size()) {
            if (maxHeap.size() == 0 || minHeap.peek() >= num) {
                maxHeap.add(num);
            } else {
                maxHeap.add(minHeap.remove());
                minHeap.add(num);
            }
        } else {
            if (num >= maxHeap.peek()) {
                minHeap.add(num);
            } else {
                minHeap.add(maxHeap.remove());
                maxHeap.add(num);
            }
        }
    }
    
    private void removeNumber(final int num, final PriorityQueue<Integer> minHeap, final PriorityQueue<Integer> maxHeap) {
        if (maxHeap.size()> minHeap.size()) {
            if (num <= maxHeap.peek()) {
                maxHeap.remove(num);
            } else {
                minHeap.remove(num);
                minHeap.add(maxHeap.remove());
            }
        } else {
            if (num >= minHeap.peek()) {
                minHeap.remove(num);
            } else {
                maxHeap.remove(num);
                maxHeap.add(minHeap.remove());
            }
        }
    }
    private double getMedian(final PriorityQueue<Integer> minHeap, final PriorityQueue<Integer> maxHeap) {
        if (minHeap.size() == maxHeap.size()) {
            return ((double)minHeap.peek() + maxHeap.peek()) / 2.0;
        } else {
            return maxHeap.peek();
        }
    }
}
