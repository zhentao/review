package com.zhentao.review.facebook;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Given an array of n elements, where each element is at most k away from its
 * target position, devise an algorithm that sorts in O(n log k) time. For
 * example, let us consider k is 2, an element at index 7 in the sorted array,
 * can be at indexes 5, 6, 7, 8, 9 in the given array.
 *
 * <pre>
Examples:

Input : arr[] = {6, 5, 3, 2, 8, 10, 9}
            k = 3
Output : arr[] = {2, 3, 5, 6, 8, 9, 10}

Input : arr[] = {10, 9, 8, 7, 4, 70, 60, 50}
         k = 4
Output : arr[] = {4, 7, 8, 9, 10, 50, 60, 70}
 * </pre>
 *
 * @author zhentao.li
 *
 */
public class AlmostSortedArray {
    public static void main(String[] args) {
        System.out.println(Long.toBinaryString(5917390538L).length());
        System.out.println(ThreadLocalRandom.current().nextLong(3_650_000_000_000L));
        System.out.println(Integer.bitCount(-3));
        int[] array = new int[] {6, 5, 3, 2, 8, 10, 9};
        int k = 3;
        AlmostSortedArray sorted = new AlmostSortedArray();
        sorted.heapSort(array, k);
        System.out.println(Arrays.toString(array));

        array = new int[] {10, 9, 8, 7, 4, 70, 60, 50};
        k = 4;
        sorted.heapSort(array, k);
        System.out.println(Arrays.toString(array));
    }

    /**
     * the loop iterates n/k times.  The running time for sort is klogk [2klog(2k)].
     * The run times is nlogk, and O(1) space.
     * @param array
     * @param k
     */
    public void specialSort(int[] array, int k) {
        int groups = array.length / k;
        for (int i = 0; i <= groups; i++) {
            int start = i * k;
            int end = start + 2 * k;
            end = end > array.length ? array.length : end;
            Arrays.sort(array, start, end);
        }
    }

    /**
     * run time nlogk but O(k) space
     * @param array
     * @param k
     */
    public void heapSort(int[] array, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        //add k + 1 elements, since the correct index of the first element could be at k
        for (int i = 0; i <= k; i++ ) {
            heap.add(array[i]);
        }
        int index = 0;
        for (int i = k+1; i < array.length; i++) {
            array[index] = heap.poll();
            index++;
            heap.add(array[i]);
        }

        while(!heap.isEmpty()) {
            array[index] = heap.poll();
            index++;
        }
    }
    /**
     * run time O(nk)
     * @param array
     */
    public void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int key = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
        }
    }
}
