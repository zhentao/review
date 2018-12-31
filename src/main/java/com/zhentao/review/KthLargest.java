package com.zhentao.review;

import java.util.PriorityQueue;

/**
 * <b>703. Kth Largest Element in a Stream</b>
 * 
 * <pre>
 * Design a class to find the kth largest element in a stream. Note that it is the kth largest element in the sorted order, not the kth distinct element.

Your KthLargest class will have a constructor which accepts an integer k and an integer array nums, which contains initial elements from the stream. For each call to the method KthLargest.add, return the element representing the kth largest element in the stream.

Example:

int k = 3;
int[] arr = [4,5,8,2];
KthLargest kthLargest = new KthLargest(3, arr);
kthLargest.add(3);   // returns 4
kthLargest.add(5);   // returns 5
kthLargest.add(10);  // returns 5
kthLargest.add(9);   // returns 8
kthLargest.add(4);   // returns 8
Note: 
You may assume that nums' length ≥ k-1 and k ≥ 1.
 * </pre>
 * 
 * @author zhentao
 *
 */
public class KthLargest {
    final PriorityQueue<Integer> heap;
    final int k;

    public KthLargest(int k, int[] a) {
        this.k = k;
        //This creates a min heap, which means the smallest element is the root.
        heap = new PriorityQueue<>(k);
        for (int n : a) {
            add(n);
        }
    }

    /**
     * just keep the k largest elements in the heap. 
     * @param n
     * @return
     */
    public int add(int n) {
        if (heap.size() < k) {
            heap.add(n);
        }
        else if (heap.peek() < n) {
            heap.remove();
            heap.add(n);
        }
        return heap.peek();
    }
    public static void main(String[] args) {
        int[] array = {4,5,8,2};
        KthLargest kLargest = new KthLargest(3, array);
        System.out.println(kLargest.add(3));
        System.out.println(kLargest.add(5));
        System.out.println(kLargest.add(10));
        System.out.println(kLargest.add(9));
        System.out.println(kLargest.add(4));
        
        kLargest = new KthLargest(1, new int[]{}) ;
        System.out.println(kLargest.add(3));
        System.out.println(kLargest.add(5));
        System.out.println(kLargest.add(10));
        System.out.println(kLargest.add(9));
        System.out.println(kLargest.add(4));
    }
}
