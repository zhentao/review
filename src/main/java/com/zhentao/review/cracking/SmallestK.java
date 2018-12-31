package com.zhentao.review.cracking;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * <b>17.14 Smallest K</b>
 * 
 * <pre>
 * Design an algorithm to find the smallest K numbers in an array
 * </pre>
 * 
 * @author zhentao
 *
 */
public class SmallestK {

    public static void main(String[] args) {
        //int[] array = { 100, 90, 80, 70, 60, 50, 40, 30, 20, 10 };
        int[] array = {40, 10, 30, 30, 80, 90, 30, 70, 30, 20};
        //[40, 10, 20, 50, 60, 70, 30, 90, 80, 100]
        //new ShuffleArray().shuffle(array);
        //System.out.println(Arrays.toString(array));
        int k = 5;
        
        System.out.println(Arrays.toString(heap(array, k)));
        //selection(array, k);
        System.out.println(Arrays.toString(selection(array, k)));
    }

    public static Integer[] heap(int[] array, int k) {
        PriorityQueue<Integer> heap = heap(k, array);
        return heap.toArray(Integer[]::new);
    }
    private static PriorityQueue<Integer> heap(int k, int[] array) {
        //build a max heap: the largest element is the root
        PriorityQueue<Integer> heap = new PriorityQueue<>(k, (x, y) -> y - x);
        for (int a : array) {
            if (heap.size() < k) {
                heap.add(a);
            } else if (a < heap.peek()) {
                heap.poll();
                //heap.remove(); throws exception if queue is empty
                heap.add(a);
            }
        }
        return heap;
    }
    
    public static int[] selection(int[] array, int k) {
        return selection(array, k, 0, array.length-1);
    }
    private static int[] selection(int[] array, int k, int start, int end) {
        int pivotIndex = partition(array, start, end);
        if (pivotIndex == k || pivotIndex == k+1) {
            return Arrays.copyOf(array, k);
        } else if (pivotIndex > k+1){
            return selection(array, k, start, pivotIndex-1);
        } else {//less than k
            return selection(array, k, pivotIndex+1, end);
        }
    }
    
    private static int partition(int[] array, int start, int end) {
        int pivot = array[start + (end-start) / 2];
        int i = start;
        int j = end;
        while (i <= j) {
            //find the index from the left which is less than pivot
//            if (array[i] > pivot) {
//                swap(array, i, j);
//                j--;
//            } else if (array[j] <= pivot) {
//                swap(array, i, j);
//                i++;
//            } else {
//                i++;
//                j--;
//            }
            while (array[i] < pivot) {
                i++;
            }
            while (array[j] > pivot) {
                j--;
            }
            if (i <= j) {
                swap(array, i, j);
                i++;
                j--;
            }
        }
        return i;
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
        
    }
    
}
