package com.zhentao.review;

import java.util.ArrayList;
import java.util.List;

/**
 * <b>300. Longest Increasing Subsequence</b>
 * 
 * <pre>
 * Given an unsorted array of integers, find the length of longest increasing subsequence.

Example:

Input: [10,9,2,5,3,7,101,18]
Output: 4 
Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4. 
Note:

There may be more than one LIS combination, it is only necessary for you to return the length.
Your algorithm should run in O(n2) complexity.
Follow up: Could you improve it to O(n log n) time complexity?
 * </pre>
 * 
 * @author zhentao
 *
 */
public class LongestIncreasingSubsequence {

    public static int memo(int[] array) {
        int[][] memo = new int[array.length][array.length];
        return memo(array, -1, 0, memo);
    }

    /**
     * memo[i][j] represents the length of the LIS possible using nums[i]nums[i] as
     * the previous element considered to be included/not included in the LIS, with
     * nums[j]nums[j] as the current element considered to be included/not included
     * in the LIS
     * 
     * @param array
     * @param prevIndex
     * @param currIndex
     * @param memo
     * @return
     */
    private static int memo(int[] array, int prevIndex, int currIndex, int[][] memo) {
        if (currIndex == array.length) {
            return 0;
        }
        if (memo[prevIndex + 1][currIndex] > 0) {
            return memo[prevIndex + 1][currIndex];
        }
        int taken = 0;
        if (prevIndex == -1 || array[currIndex] > array[prevIndex]) {
            taken = 1 + memo(array, currIndex, currIndex + 1, memo);
        }
        int notTaken = memo(array, prevIndex, currIndex + 1, memo);
        memo[prevIndex + 1][currIndex] = Math.max(taken, notTaken);
        return memo[prevIndex + 1][currIndex];
    }

    /**
     * this implementation is slow
     * 
     * @param array
     * @return
     */
    public static int find(int[] array) {

        if (array == null || array.length == 0) {
            return 0;
        }
        int length = array.length;
        List<List<Integer>> lists = new ArrayList<>(length);

        for (int i = 0; i < length; i++) {
            List<Integer> list = findValidLongestList(lists, array[i]);
            list.add(array[i]);
            lists.add(list);
        }
        return maxLength(lists);
    }

    private static List<Integer> findValidLongestList(List<List<Integer>> lists, int value) {
        List<Integer> longestList = new ArrayList<>();
        for (List<Integer> list : lists) {
            int listSize = list.size();
            if (list.get(listSize - 1) < value) {
                if (listSize > longestList.size()) {
                    longestList = list;
                }
            }
        }
        return new ArrayList<Integer>(longestList);
    }

    private static int maxLength(List<List<Integer>> lists) {
        int max = 0;
        for (List<Integer> list : lists) {
            int size = list.size();
            if (size > max) {
                max = size;
            }
        }
        return max;
    }
}
