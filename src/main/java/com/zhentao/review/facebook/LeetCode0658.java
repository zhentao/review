package com.zhentao.review.facebook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 658. Find K Closest Elements
 *
 * Given a sorted array arr, two integers k and x, find the k closest elements
 * to x in the array. The result should also be sorted in ascending order. If
 * there is a tie, the smaller elements are always preferred.
 *
 * <pre>
Example 1:

Input: arr = [1,2,3,4,5], k = 4, x = 3
Output: [1,2,3,4]

Example 2:

Input: arr = [1,2,3,4,5], k = 4, x = -1
Output: [1,2,3,4]

Constraints:

    1 <= k <= arr.length
    1 <= arr.length <= 10^4
    Absolute value of elements in the array and x will not exceed 10^4
 *
 * </pre>
 *
 * @author zhentao.li
 *
 */
public class LeetCode0658 {

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11 };
        int k = 4;
        int x = 6;
        List<Integer> res = new LeetCode0658().findClosestElements2(arr, k, x);
        System.out.println(res);
        System.out.println(new LeetCode0658().findClosestElements(arr, k, x));
    }

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int lo = 0;
        int hi = arr.length - k-1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (x - arr[mid] > arr[mid + k] - x) {
                lo = mid + 1;
            } else {
                hi = mid-1;
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int i = lo; i < lo +k; i++) {
            res.add(arr[i]);
        }
        return res;
    }

    /**
     * Stream seems slower than the above.
     *
     * @param arr
     * @param k
     * @param x
     * @return
     */
    public List<Integer> findClosestElementsStream(int[] arr, int k, int x) {

        List<Integer> list = Arrays.stream(arr).boxed()
                .sorted((a, b) -> Integer.compare(Math.abs(a - x), Math.abs(b - x))).collect(Collectors.toList())
                .subList(0, k);
        list.sort(null);

        return list;
    }

    /**
     * sliding window k
     *
     * @param arr
     * @param k
     * @param x
     * @return
     */
    public List<Integer> findClosestElements2(int[] arr, int k, int x) {
        int lo = 0;
        int hi = arr.length - k;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (x - arr[mid] > arr[mid + k] - x) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }

        return Arrays.stream(arr, lo, lo + k).boxed().collect(Collectors.toList());
    }
}
