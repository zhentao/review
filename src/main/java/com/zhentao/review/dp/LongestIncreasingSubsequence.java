package com.zhentao.review.dp;

public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        int[] array = {10, 22, 9, 33, 21, 50, 41, 60, 80};
        System.out.println(find(array));
        array = new int[] {3, 10, 2, 1, 20};
        System.out.println(find(array));
        array = new int[] {3, 2};
        System.out.println(find(array));
        array = new int[] {0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15};
        System.out.println(find(array));
        array = new int[] {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(find(array));

    }

    public static int find(int[] array) {

        if (array == null || array.length == 0) {
            return 0;
        }
        int length = array.length;
        int[] memo = new int[length];
        memo[0] = 1;
        int maxAll = 1;
        for (int i = 1; i < length; i++) {
            int maxLocal = 0;
            for (int j = 0; j < i; j++) {
                if (array[i] > array[j]) {
                    //find the max memo value from 0 to j
                    maxLocal = Math.max(maxLocal, memo[j]);
                }
            }
            //add 1 for current element at index i
            //if array[i] is less than every element before it, maxLocal is 0
            //if array[i] is greater than 1 or elements before it, maxLocal is the max of memo[j], need to add 1
            memo[i] = maxLocal + 1;
            maxAll = Math.max(memo[i], maxAll);
        }
        return maxAll;
    }

}
