package com.zhentao.review.google;

/**
 * <b>774. Minimize Max Distance to Gas Station</b>
 * 
 * <pre>
 * On a horizontal number line, we have gas stations at positions stations[0], stations[1], ..., stations[N-1], where N = stations.length.

Now, we add K more gas stations so that D, the maximum distance between adjacent gas stations, is minimized.

Return the smallest possible value of D.

Example:

Input: stations = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10], K = 9
Output: 0.500000
Note:

stations.length will be an integer in range [10, 2000].
stations[i] will be an integer in range [0, 10^8].
K will be an integer in range [1, 10^6].
Answers within 10^-6 of the true value will be accepted as correct.
 * </pre>
 * 
 * @author zhentao
 *
 */
public class MinimizeMaxDistanceToGasStation {
    double minMaxGasDist(final int[] stations, final int k) {
        double left = 0;
        double right = 1e8;
        while (right - left > 1e-6) {
            final double mid = left + (right - left) / 2;
            int cnt = 0;
            final int n = stations.length;
            for (int i = 0; i < n - 1; ++i) {
                // 我们折半计算出来的mid就是一个candidate，我们要去验证个candidate是否符合题意。
                //验证的方法其实也不难，我们计算每两个加油站之间的距离，如果此距离大于candidate，
                //则计数器累加1，如果大于candidate距离的个数小于等于k，则说明我们的candidate偏大了，
                //那么right赋值为mid；反之若大于candidate距离的个数大于k，则说明我们的candidate偏小了，
                //那么left赋值为mid。最后left和right都会收敛为所要求的最小的任意两个加油站间的最大距离
                cnt += (stations[i + 1] - stations[i]) / mid;
            }
            if (cnt <= k)
                right = mid;
            else
                left = mid;
        }
        return left;
    }
}
