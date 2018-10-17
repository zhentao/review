package com.zhentao.review;

public class FindWaysToTarget {

    public static void main(String[] args) {
        int[] a = {1, 2};
        int sum = 5;
        System.out.println(ways(a, sum));
    }
    /**
     *
     * @param a an array with all positive #
     * @param sum a positive #
     * @return
     */
    public static int ways(int a[], int sum) {
        int size = a.length;
        int[] dp = new int[sum + 1];
        dp[0] = 1;

        for (int i = 0; i < size; i++)
            for (int x = 1; x <= sum; x++)
                if (x - a[i] >= 0)
                    dp[x] = dp[x - a[i]] + dp[x];

        return dp[sum];
    }
}
