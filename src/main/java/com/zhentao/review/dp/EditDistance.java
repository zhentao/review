package com.zhentao.review.dp;

public class EditDistance {
    public static void main(final String[] args) {
        String str1 = "geek", str2 = "gesek";
        System.out.println(calculateTopDown(str1, str2));
        System.out.println(calculateBottomUp(str1, str2));
        System.out.println();

        str1 = "cat";
        str2 = "cut";
        System.out.println(calculateTopDown(str1, str2));
        System.out.println(calculateBottomUp(str1, str2));
        System.out.println();

        str1 = "sunday";
        str2 = "saturday";
        System.out.println(calculateTopDown(str1, str2));
        System.out.println(calculateBottomUp(str1, str2));
        System.out.println();

        System.out.println(calculateTopDown("a", "bc"));
        System.out.println(calculateBottomUp("a", "bc"));
    }

    public static int calculateTopDown(final String str1, final String str2) {

        final int m = str1.length();
        final int n = str2.length();
        final int[][] memo = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                memo[i][j] = -1;
            }
        }
        return calculateTopDown(str1, m - 1, str2, n - 1, memo);
    }

    private static int calculateTopDown(final String str1, final int m, final String str2, final int n,
            final int[][] memo) {

        if (m < 0)
            return n + 1;
        if (n < 0)
            return m + 1;

        if (memo[m][n] != -1) {
            return memo[m][n];
        }
        if (str1.charAt(m) == str2.charAt(n)) {
            memo[m][n] = calculateTopDown(str1, m - 1, str2, n - 1, memo);

        } else {
            final int delete = calculateTopDown(str1, m - 1, str2, n, memo);
            final int insert = calculateTopDown(str1, m, str2, n - 1, memo);
            final int replace = calculateTopDown(str1, m - 1, str2, n - 1, memo);
            memo[m][n] = 1 + min(delete, insert, replace);
        }
        return memo[m][n];
    }

    public static int calculateBottomUp(final String str1, final String str2) {
        final int m = str1.length();
        final int n = str2.length();
        final int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int j = 1; j <= n; j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    final int delete = dp[i - 1][j];// delete from str2: keep i-1 and move to j
                    final int insert = dp[i][j - 1];// insert into str2: move from i - 1 to i, and keep j-1
                    final int replace = dp[i - 1][j - 1];
                    dp[i][j] = 1 + min(delete, replace, insert);
                }
            }
        }
        return dp[m][n];
    }

    private static int min(final int a, final int b, final int c) {
        if (a >= b) {
            return Math.min(b, c);
        } else {
            return Math.min(a, c);
        }
    }
}
