package com.zhentao.review.google.high;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <b>62. Unique Paths</b>
 * 
 * <pre>
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

How many possible unique paths are there?

Note: m and n will be at most 100.

Example 1:

Input: m = 3, n = 2
Output: 3
Explanation:
From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
1. Right -> Right -> Down
2. Right -> Down -> Right
3. Down -> Right -> Right

Example 2:

Input: m = 7, n = 3
Output: 28
 * 
 * 
 * </pre>
 * 
 * <pre>
 * |---------
 * |1|1|1| 1|
 * |1|2|3| 4| ==> m[i][j] = m[i][j-1] + m[i-1][j]
 * |1|3|6|10|
 * |---------
 * 
 * </pre>
 * 
 * @author zhentao.li
 *
 */
public class UniquePaths {

    public static void main(final String[] args) {
        System.out.println(count(3, 2));
        System.out.println(count(7, 3));
    }

    /**
     * 2 dimensional array
     * 
     * @param m
     * @param n
     * @return
     */
    public static int count(final int m, final int n) {
        final int[][] memo = new int[m][n];
        memo[0][0] = 1;
        for (int i = 1; i < m; i++) {
            memo[i][0] = 1;
        }
        for (int i = 1; i < n; i++) {
            memo[0][i] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                memo[i][j] = memo[i][j - 1] + memo[i - 1][j];
            }
        }
        return memo[m - 1][n - 1];
    }

    /**
     * <pre>
     * Rules： 1. 从左上角走到右上角 2. 机器人只能走右上，右和右下 思路： 
     * 按照列dp, dp[i][j] = dp[i - 1][j - 1] + dp[i][j - 1] + dp[i + 1][j - 1]， 
     * 注意i-1，i+1需要存在
     * </pre>
     * 
     * one dimensional array
     * 
     * @param rows
     * @param cols
     * @return
     */
    public int uniquePaths(final int rows, final int cols) {
        final int[] dp = new int[rows];
        final int[] tmp = new int[rows];
        dp[0] = 1;
        for (int j = 1; j < cols; j++) {
            for (int i = 0; i < rows; i++) {
                final int val1 = i - 1 >= 0 ? dp[i - 1] : 0;
                final int val2 = dp[i];
                final int val3 = i + 1 < rows ? dp[i + 1] : 0;
                tmp[i] = val1 + val2 + val3;
            }
            System.arraycopy(tmp, 0, dp, 0, tmp.length);
        }
        return dp[0];
    }

    /**
     * <pre>
     * followup2: 给定矩形里的三个点，判断是否存在遍历这三个点的路径 
     * 思路： 假设三个点坐标为(x1, y1) (x2, y2) (x3, y3)
     * 1：从(0,0)出发，如果后一个点在前一个点展开的扇形区域内，则可以被达到 
     * 2：先对三个点按照纵坐标y排序，如果一个y上有一个以上的点，则返回false
     * 3：对于(xi, yi)，得到前一个点在该列的可达范围 
     * len = yi - y(i-1) upper = x(i-1) - len lower = x(i-1) + len 如果[xi]在这个范围内，则可达
     * </pre>
     */
    public boolean canReach(final int[][] points) {
        final List<int[]> list = new ArrayList<>();
        list.add(new int[] { 0, 0 });
        for (final int[] point : points)
            list.add(point);
        Collections.sort(list, (a, b) -> a[1] - b[1]);
        for (int i = 1; i < list.size(); i++) {
            final int[] curr = list.get(i);
            final int[] prev = list.get(i - 1);
            if (curr[1] == prev[1])
                return false;
            final int len = curr[1] - prev[1];
            final int upper = prev[0] - len;
            final int lower = prev[0] + len;
            if (curr[0] <= lower && curr[0] >= upper)
                continue;
            else
                return false;
        }
        return true;
    }

    /**
     * followup3: 给定矩形里的三个点，找到遍历这三个点的所有路径数
     * 
     * <pre>
     * 思路：
    1：还是按照follow up 1的思路用滚动数组dp，但是如果当前列有需要到达的点时，只对该点进行dp，其他格子全部置零，
    表示我们只care这一列上经过目标点的路径
    2：如果一列上有多个需要达到的点，直接返回0；
     * 
     * </pre>
     */
    public int uniquePaths(final int rows, final int cols, final int[][] points) {
        final int[] dp = new int[rows];
        final int[] tmp = new int[rows];
        final Map<Integer, Integer> map = new HashMap<>();
        for (final int[] point : points) {
            if (map.containsKey(point[1])) {
                return 0;
            } else {
                map.put(point[1], point[0]);
            }
        }
        int res = 0;
        dp[0] = 1;
        for (int j = 1; j < cols; j++) {
            for (int i = 0; i < rows; i++) {
                final int val1 = i - 1 >= 0 ? dp[i - 1] : 0;
                final int val2 = dp[i];
                final int val3 = i + 1 < rows ? dp[i + 1] : 0;
                tmp[i] = val1 + val2 + val3;
            }
            System.arraycopy(tmp, 0, dp, 0, tmp.length);
            if (map.containsKey(j)) {
                final int row = map.get(j);
                for (int i = 0; i < rows; i++) {
                    if (i != row)
                        dp[i] = 0;
                    else
                        res = dp[i];
                }
            }
        }
        return res;
    }

    /**
     * followup4: 给定一个下界 (x == H)，找到能经过给定下界的所有从左上到右上的路径数量 (x >= H) TODO
     * 
     * <pre>
     * 思路：
    1：先dp一遍，得到所有到右上的路径数量
    2：然后在 0<=x<=H, 0<=y<=cols 这个小矩形中再DP一遍得到不经过下界的所有路径数量
    3：两个结果相减得到最终路径数量
    Code
    重用follow up 1的代码
    public int uniquePaths(int rows, int cols, int H) {
    return uniquePaths(rows, cols) - uniquePaths(H, cols);
    }
     * 
     * </pre>
     */

    /**
     * followup5: 起点和终点改成从左上到左下，每一步只能 ↓↘↙，求所有可能的路径数量 TODO
     * 
     * <pre>
     * 按照 行 dp，其他地方不变
     * </pre>
     */

    public int uniquePaths5(final int rows, final int cols) {
        final int[] dp = new int[cols];
        final int[] tmp = new int[cols];
        dp[0] = 1;
        for (int i = 1; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                final int val1 = j - 1 >= 0 ? dp[j - 1] : 0;
                final int val2 = dp[j];
                final int val3 = j + 1 < cols ? dp[j + 1] : 0;
                tmp[i] = val1 + val2 + val3;
            }
            System.arraycopy(tmp, 0, dp, 0, tmp.length);
        }
        return dp[0];
    }

    /**
     * <pre>
     * 补充一个该题目变种：
    Given a N*N matrix with random amount of money in each cell, you start from top-left, and can only move from left to right, or top to bottom one step at a time until you hit the bottom right cell. Find the path with max amount of money on its way.
    Sample data:
    start
    |
    v
    5,   15,20,  ...
    10, 15,  5,   ...
    30,  5,  5,    ...
    … 
                 ^end here.
    
    思路：LC 62带上权值，思路差不多，只是求和变成求相加后的最大值
     * 
     * </pre>
     */

    /**
     * <pre>
     * Follow up 1：要求重建从end 到 start的路径
    思路：用另一个额外数组记录每一步选择的parent，dp结束后，从end依次访问它的parent重建路径
    
    Follow up 2: 现在要求空间复杂度为O（1），dp且重建路径
    空间复杂度不算返回路径时需要的空间
    思路：直接修改原数组，而且带上符号，负号表示从当前cell的左边过来，正号表示从当前cell的上边过来，dp结束后从end 依次访问它的parent重建路径
    
    数组全是零(或者左上角一块是零)的话就没有办法通过正负号判断来的方向了吧，这样在重构path的时候可能会index out of bound，觉得还是check左边和右边哪个更大就是从那边来的更好，然后注意第一行和第一列的特殊情况，这样不会出问题
    （这个方法是面试官给的hit提示的，原数组应该都是正整数。如果全是0，用正负号表示也可以特殊处理一下第一行和第一列的情况即可，即遇到i为0时候总是往左走，j为0的时候总是往上走。）
     * 
     * </pre>
     */
    // TODO
    public List<List<Integer>> maxMoney(final int[][] moneys) {
        // assume: moneys is not null, width and length are equal
        final int n = moneys.length;
        if (n == 0)
            return new ArrayList<>();
        // base case
        for (int j = 1; j < n; j++) {
            moneys[0][j] = -(Math.abs(moneys[0][j - 1]) + moneys[0][j]);
        }
        for (int i = 1; i < n; i++) {
            moneys[i][0] = moneys[i - 1][0] + moneys[i][0];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                final int top = Math.abs(moneys[i - 1][j]) + moneys[i][j];
                final int left = Math.abs(moneys[i][j - 1]) + moneys[i][j];
                if (top >= left)
                    moneys[i][j] = top;
                else
                    moneys[i][j] = -left;
            }
        }
        System.out.println("Max path sum = " + Math.abs(moneys[n - 1][n - 1]));
        final List<List<Integer>> path = new ArrayList<>();
        int curri = n - 1;
        int currj = n - 1;
        while (curri > 0 || currj > 0) {
            path.add(Arrays.asList(curri, currj));
            if (moneys[curri][currj] < 0) {
                currj -= 1;
            } else {
                curri -= 1;
            }
        }
        path.add(Arrays.asList(0, 0));
        return path;
    }
}
