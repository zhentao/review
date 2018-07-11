package com.zhentao.review;

public class MaxSubArray {
    public static void main(String[] args) {
        int[] input = {-2, 3, -1, 2};
        System.out.println(maxSub(input));
        input = new int[] {-2, -1, -3};
        System.out.println(maxSub0(input));
        System.out.println(maxSub(input));
    }
    /**
     * return largest # if all are negative
     * @param A
     * @return
     */
    public static int maxSub(int[] A) {
        int maxNow = A[0];
        int maxAll = A[0];
        int size = A.length;
        for (int i = 1; i < size; i++) {
            maxNow = Math.max(A[i], maxNow + A[i]);
            maxAll = Math.max(maxAll, maxNow);
        }
        return maxAll;
    }

    /**
     * return 0 if all are negative
     * @param A
     * @return
     */
    public static int maxSub0(int[] A) {
        int maxNow = 0;
        int maxAll = 0;
        int size = A.length;
        for (int i = 0; i < size; i++) {
            maxNow = Math.max(0, maxNow + A[i]);
            maxAll = Math.max(maxAll, maxNow);
        }
        return maxAll;
    }
}
