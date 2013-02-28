package com.test.review;

public class MaxSubArray {
    public static void main(String[] args) {
        int[] input = {-2, 3, -1, 2};
        System.out.println(maxSub(input));
    }
    public static int maxSub(int[] A) {
        int maxNow = 0;
        int maxAll = A[0];
        int size = A.length;
        for (int i = 0; i < size; i++) {
            maxNow = Math.max(A[i], maxNow + A[i]);
            maxAll = Math.max(maxAll, maxNow);
        }
        return maxAll;
    }
}
