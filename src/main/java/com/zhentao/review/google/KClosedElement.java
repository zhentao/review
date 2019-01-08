package com.zhentao.review.google;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * <b>658. Find K Closest Elements</b>
 * 
 * <pre>
 *  Given a sorted array, two integers k and x, find the k closest elements to x in the array. The result should also be sorted in ascending order. If there is a tie, the smaller elements are always preferred.

Example 1:

Input: [1,2,3,4,5], k=4, x=3
Output: [1,2,3,4]

Example 2:

Input: [1,2,3,4,5], k=4, x=-1
Output: [1,2,3,4]

Note:

    The value k is positive and will always be smaller than the length of the sorted array.
    Length of the given array is positive and will not exceed 10^4
    Absolute value of elements in the array and x will not exceed 10^4
 * 
 * </pre>
 * 
 * @author zhentao.li
 *
 */
public class KClosedElement {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> list = new ArrayList<Integer>(k);
        int length = arr.length;
        
        if (x < arr[0]) {
            for (int i = 0; i < k; i++) {
                list.add(arr[i]);
            }
        } else if (x > arr[length-1]) {
            for (int i = length - k; i < length; i++) {
                list.add(arr[i]);
            }
        } else {
            int index = Arrays.binarySearch(arr, x);
            ArrayList<Integer> small = new ArrayList<>();
            ArrayList<Integer> large = new ArrayList<>();
            int count = 0;
            int i = index;
            int j = index;
            if (index < 0) {// x is not in the array
                j = -index - 1;
                //find the first element greater than x
                while (j >= 1 && arr[j-1] == arr[j]) {
                    j--;
                }
                i = j-1;
                
            } else {
                small.add(arr[i]);
                count++;
                i--;
                j++;
                //The following 2 while loops handle the duplicates of x in array
                while(i >= 0 && x == arr[i] && count < k) {
                    small.add(arr[i]);
                    i--;
                    count++;
                }
                while(j < length && x == arr[j] && count < k) {
                    small.add(arr[j]);
                    j++;
                    count++;
                }
            }
            //add the closest element to the list
            while(count < k && i >= 0 && j < length) {
                if (x-arr[i] > arr[j] - x) {
                    large.add(arr[j]);
                    j++;
                } else {
                    small.add(arr[i]);
                    i--;
                }
                count++;
            }
            
            //handle leftover: reach left side first
            if (count < k && i < 0) {
                while(count < k) {
                    large.add(arr[j]);
                    j++;
                    count++;
                }
            } else if (count < k && j == length){
                while(count < k) {
                    small.add(arr[i]);
                    i--;
                    count++;
                }
            }
            Collections.reverse(small);
            list.addAll(small);
            list.addAll(large);
        }

        return list;
    }
}
