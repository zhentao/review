package com.zhentao.review.dp;

public class MinMatrixMultiplication {

    public static void main(String[] args) {
        int arr[] = new int[] {10, 20, 30, 40, 50,60,70,80,90,100,110,120,130,140,150,160,170,180,190,200,210,220,230,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40};
        long start = System.nanoTime();
        int count = MatrixChainOrder(arr, arr.length); //rescursive(arr);
        long cost = System.nanoTime() - start;
        System.out.println(count + " : " + cost);

        start = System.nanoTime();
        count = memo(arr);
        cost = System.nanoTime() - start;
        System.out.println(count + " : " + cost);
    }
    public static int rescursive(int[] array) {
        return recursive(array, 1, array.length-1);
    }
    private static int recursive(int[] array, int i, int j) {
        if (i == j) return 0;
        int min = Integer.MAX_VALUE;
        for (int m = i; m < j; m++) {
            int count = recursive(array, i, m) + recursive(array, m+1, j) + array[i-1] * array[m] *array[j];
            if (count < min) {
                min = count;
            }
        }
        return min;
    }

    public static int memo(int[] array) {
        int[][] dp = new int[array.length][array.length];

        return memo(array, 1, array.length-1, dp);
    }
    private static int memo(int[] array, int i, int j, int[][] dp) {
        if (i == j) return 0;
        int min = Integer.MAX_VALUE;
        if (dp[i][j] != 0) return dp[i][j];
        for (int m = i; m < j; m++) {

            dp[i][j] = memo(array, i, m, dp) + memo(array, m+1, j, dp) + array[i-1] * array[m] *array[j];
            if (dp[i][j] < min) {
                min = dp[i][j];
            } else {
                //overwrite with the min from previous run
                dp[i][j] = min;
            }
        }
        return min;
    }



    static int MatrixChainOrder(int p[], int n)
    {
        /* For simplicity of the program, one extra row and one
        extra column are allocated in m[][].  0th row and 0th
        column of m[][] are not used */
        int m[][] = new int[n][n];

        int i, j, k, L, q;

        /* m[i,j] = Minimum number of scalar multiplications needed
        to compute the matrix A[i]A[i+1]...A[j] = A[i..j] where
        dimension of A[i] is p[i-1] x p[i] */

        // cost is zero when multiplying one matrix.
        for (i = 1; i < n; i++)
            m[i][i] = 0;

        // L is chain length.
        for (L=2; L<n; L++)
        {
            for (i=1; i<n-L+1; i++)
            {
                j = i+L-1;
                if(j == n) continue;
                m[i][j] = Integer.MAX_VALUE;
                for (k=i; k<=j-1; k++)
                {
                    // q = cost/scalar multiplications
                    q = m[i][k] + m[k+1][j] + p[i-1]*p[k]*p[j];
                    if (q < m[i][j])
                        m[i][j] = q;
                }
            }
        }

        return m[1][n-1];
    }
}
