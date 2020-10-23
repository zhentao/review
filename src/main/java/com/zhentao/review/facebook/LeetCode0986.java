package com.zhentao.review.facebook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <b>986. Interval List Intersections</b> Given two lists of closed intervals,
 * each list of intervals is pairwise disjoint and in sorted order.
 *
 * Return the intersection of these two interval lists.
 *
 * (Formally, a closed interval [a, b] (with a <= b) denotes the set of real
 * numbers x with a <= x <= b. The intersection of two closed intervals is a set
 * of real numbers that is either empty, or can be represented as a closed
 * interval. For example, the intersection of [1, 3] and [2, 4] is [2, 3].)
 *
 * Input: A = [[0,2],[5,10],[13,23],[24,25]], B = [[1,5],[8,12],[15,24],[25,26]]
 * Output: [[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]
 *
 * Note:
 *
 * 0 <= A.length < 1000 0 <= B.length < 1000 0 <= A[i].start, A[i].end,
 * B[i].start, B[i].end < 10^9
 *
 * @author zhentao.li
 *
 */
public class LeetCode0986 {
    public static void main(String[] args) {
        LeetCode0986 lc = new LeetCode0986();
        int[][] A = {{0,2},{5,10},{13,23},{24,25}};
        int[][] B = {{1,5},{8,12},{15,24},{25,26}};
        System.out.println(Arrays.deepToString(lc.intervalIntersection(A, B)));
    }

    public int[][] intervalIntersection(int[][] A, int[][] B) {
        List<int[]> answer = new ArrayList<>();

        int i = 0;
        int j = 0;
        while (i < A.length && j < B.length) {
            int low = Math.max(A[i][0], B[j][0]);
            int high = Math.min(A[i][1], B[j][1]);

            if (low <= high) {
                answer.add(new int[]{low, high});
            }
            if (A[i][1] > B[j][1]) {
                j++;
            } else {
                i++;
            }
        }
        return answer.toArray(new int[0][0]);
    }
}
