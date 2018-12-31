package com.zhentao.review.cracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * <b>10.11 Peaks and Valleys:</b>
 * 
 * <pre>
 * In an array of integers, a "peak" is an element which is greater than or equal
to the adjacent integers and a "valley" is an element which is less than or equal to the adjacent
integers. For example, in the array {S, 8, 6, 2, 3, 4, 6}, {8, 6} are peaks and {S, 2} are valleys. Given an
array of integers, sort the array into an alternating sequence of peaks and valleys.
EXAMPLE
Input: {S, 3, 1,2, 3}
Output: {S, 1,3,2, 3}
 * </pre>
 * 
 * @author zhentao
 *
 */
public class PeakAndValley {
    public static void main(String[] args) {
        int a = 11;
        int b = 5;
        System.out.println(a|b|b);
        int[] array = { 9, 5, 0, 4, 8, 7 };
        sort(array);
        System.out.println(Arrays.toString(array));

        array = new int[] { 5, 8, 6, 2, 3, 6, 1 };
        sort(array);
        System.out.println(Arrays.toString(array));
        
        Random rand = new Random();
        ArrayList<Integer> list = new ArrayList<>();    
        list.add(1);
        list.add(2);
        list.add(3);
        List<Integer> subset = list.stream().filter(k -> rand.nextBoolean()).collect(Collectors.toList());
        System.out.println(subset);
        
    }

    public static void sort(int[] array) {
        for (int i = 1; i < array.length - 1; i++) {
            if (i % 2 == 1) {//for valley
                if (array[i] > array[i-1]) {
                    swap(array, i, i-1);
                }
                if (array[i] > array[i + 1]) {
                    swap(array, i, i + 1);
                }
            }
            if (i%2 == 0) {//for peak
                if (array[i] < array[i+1]) {
                    swap(array, i, i+1);
                }
            }
        }
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
