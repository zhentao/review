package com.zhentao.review.dp;

import java.util.HashMap;
import java.util.Map;

class LCS {
    // Function to find length of Longest Common Subsequence of substring
    // X[0..m-1] and Y[0..n-1]
    public static int LCSLength(String X, String Y, int m, int n, Map<String, Integer> lookup) {
        // return if we have reached the end of either string
        if (m == 0 || n == 0)
            return 0;

        // construct a unique map key from dynamic elements of the input
        String key = m + "|" + n;

        // if sub-problem is seen for the first time, solve it and
        // store its result in a map
        if (!lookup.containsKey(key)) {
            // if last character of X and Y matches
            if (X.charAt(m - 1) == Y.charAt(n - 1)) {
                lookup.put(key, LCSLength(X, Y, m - 1, n - 1, lookup) + 1);

            } else {
                // else if last character of X and Y don't match
                lookup.put(key, Integer.max(LCSLength(X, Y, m, n - 1, lookup), LCSLength(X, Y, m - 1, n, lookup)));
            }
        }

        // return the subproblem solution from the map
        return lookup.get(key);
    }

    // main function
    public static void main(String[] args) {
        String X = "ABCBDAB", Y = "BDCABA";

        // create a map to store solutions of subproblems
        Map<String, Integer> lookup = new HashMap<>();

        System.out.println("The length of LCS is " + LCSLength(X, Y, X.length(), Y.length(), lookup));

        System.out.println("The length of LCS is " + LCSLengthArray(X, Y));

        System.out.println("The length of LCS is " + lcsBottomUp(X, Y, X.length(), Y.length()));
    }

    public static int LCSLengthArray(String x, String y) {
        int m = x.length();
        int n = y.length();
        int[][] lookup = new int[m + 1][n + 1];

        LCSLengthArray(x, y, m, n, lookup);

        return lookup[m][n];
    }

    private static int LCSLengthArray(String X, String Y, int m, int n, int[][] lookup) {
        // return if we have reached the end of either string
        if (m == 0 || n == 0)
            return 0;


        // if sub-problem is seen for the first time, solve it and
        // store its result in an array
        if (lookup[m][n] == 0) {
            // if last character of X and Y matches
            if (X.charAt(m - 1) == Y.charAt(n - 1)) {
                lookup[m][n] = LCSLengthArray(X, Y, m - 1, n - 1, lookup) + 1;
            } else {
                // else if last character of X and Y don't match
                lookup[m][n] = Math.max(LCSLengthArray(X, Y, m, n - 1, lookup), LCSLengthArray(X, Y, m - 1, n, lookup));
            }
        }

        // return the subproblem solution from the array
        return lookup[m][n];
    }

    /**
     * bottom up iterative
     * @param X
     * @param Y
     * @param m
     * @param n
     * @return
     */
    public static int lcsBottomUp(String X, String Y, int m, int n) {
        int L[][] = new int[m + 1][n + 1];

        /*
         * Following steps build L[m+1][n+1] in bottom up fashion. Note that L[i][j] contains length
         * of LCS of X[0..i-1] and Y[0..j-1]
         */
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (X.charAt(i - 1) == Y.charAt(j - 1)) {
                    L[i][j] = L[i - 1][j - 1] + 1;
                }
                else
                    L[i][j] = Math.max(L[i - 1][j], L[i][j - 1]);
            }
        }
        return L[m][n];
    }
}
