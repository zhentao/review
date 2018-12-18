package com.zhentao.review;

public class MaxSubArray {
    public static void main(String[] args) {
        int[] input = {-2, 3, -1, 2};
        System.out.println(maxSub(input));
        System.out.println(maxSubDp(input));
        System.out.println(solve(input));
        input = new int[] {-2, -1, -3};
        System.out.println(maxSub(input));
        System.out.println(maxSubDp(input));

        int[] a = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubDp(a));

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
//            System.out.println("i = " + i + ": max now:" + maxNow);
            maxAll = Math.max(maxAll, maxNow);
//            System.out.println("i = " + i + ": max all:" + maxAll);
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

    public static int maxSubDp(int[] A) {
        int length = A.length;
        int[][] memo = new int[length][length];
        int max = A[length -1];
        for (int j = length - 1; j >= 0; j--) {
            for (int i = j; i >= 0; i--) {
                if (i == j) {
                    memo[i][i] = A[i];
                } else {
                    memo[i][j] = memo[i+1][j] + A[i];
                }
                max = Math.max(max, memo[i][j]);
            }
        }
        return max;
    }

    public static int solve(int [] a){
        int [] solution = new int[a.length+1];
        solution[0] = 0;

        for (int j = 1; j <solution.length ; j++) {
            solution[j] = Math.max(solution[j-1]+a[j-1],a[j-1]);
        }
        //this will print the solution matrix
        //System.out.println(Arrays.toString(solution));
        //now return the maximum in the solution arrayyy
        int result = solution[0];
        for (int j = 1; j <solution.length ; j++) {
            if(result<solution[j])
                result = solution[j];
        }

        return result;
}
}
