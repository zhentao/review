package com.zhentao.review.cracking;

import java.util.PriorityQueue;

public class ContinuousMedian {
    private final PriorityQueue<Integer> minHeap;
    private final PriorityQueue<Integer> maxHeap;
    
    public ContinuousMedian() {
        minHeap = new PriorityQueue<>();//the least element is the head. store the elements greater than median
        maxHeap = new PriorityQueue<>((x,y)-> y.compareTo(x)); //the largest element is the head. store the elements less than median
    }
    public void addNum(final int n) {
        if (minHeap.size() == maxHeap.size()) {
            if (minHeap.size() == 0 || n <= minHeap.peek()) {
                maxHeap.add(n);
            } else {
                maxHeap.add(minHeap.remove());
                minHeap.add(n);
            }
        } else {
            if (n >= maxHeap.peek()) {
                minHeap.add(n);
            } else {
                minHeap.add(maxHeap.remove());
                maxHeap.add(n);
            }
        }
    }
    
    public double getMedian() {
        if (maxHeap.size() == 0) {
            throw new RuntimeException("Please add nubmer first before calling getMedian");
        }
        if (maxHeap.size() == minHeap.size()) {
            return ((double)maxHeap.peek() + minHeap.peek()) / 2.0;
        } else {
            return maxHeap.peek();
        }
    }
}
