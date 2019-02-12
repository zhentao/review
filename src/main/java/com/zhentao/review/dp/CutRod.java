package com.zhentao.review.dp;

/**
 * You have to cut a wood stick into pieces. The most affordable company, The
 * Analog Cutting Machinery, Inc. (ACM), charges money according to the length
 * of the stick being cut. Their procedure of work requires that they only make
 * one cut at a time. It is easy to notice that different selections in the
 * order of cutting can led to different prices. For example, consider a stick
 * of length 10 meters that has to be cut at 2, 4 and 7 meters from one end.
 * There are several choices. One can be cutting first at 2, then at 4, then at
 * 7. This leads to a price of 10 + 8 + 6 = 24 because the first stick was of 10
 * meters, the resulting of 8 and the last one of 6. Another choice could be
 * cutting at 4, then at 2, then at 7. This would lead to a price of 10 + 4 + 6
 * = 20, which is a better price. Your boss trusts your computer abilities to
 * find out the minimum cost for cutting a given stick. Input The input will
 * consist of several input cases. The first line of each test case will contain
 * a positive number l that represents the length of the stick to be cut. You
 * can assume l < 1000. The next line will contain the number n (n < 50) of cuts
 * to be made. The next line consists of n positive numbers ci (0 < ci < l)
 * representing the places where the cuts have to be done, given in strictly
 * increasing order. An input case with l = 0 will represent the end of the
 * input. Output You have to print the cost of the optimal solution of the
 * cutting problem, that is the minimum cost of cutting the given stick. Format
 * the output as shown below.
 *
 * <pre>
 * Sample Input
 *
 * 100
 * 3
 * 25 50 75
 * 10
 * 4
 * 4 5 7 8
 * 0
 * Sample Output
 *
 * The minimum cutting is 200.
 * The minimum cutting is 22.
 * </pre>
 *
 * @author zhentao
 *
 */
public class CutRod {
    /**
     *
     * @param length
     * @param places a sorted array in increasing order
     * @return the minimum cutting price
     */
    public int cutBruteForce(final int length, final int numberOfCuts, final int[] places) {
        return cutBruteForce(length, numberOfCuts, places, 0, places.length - 1, 0);
    }

    private int cutBruteForce(final int length, final int numberOfCuts, final int[] places, final int start, final int end,
            final int startPlace) {
        if (numberOfCuts == 0) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < numberOfCuts; i++) {
            min = Math.min(min,
                    length + cutBruteForce(places[start + i] - startPlace, i, places, start, start + i - 1, startPlace)
                            + cutBruteForce(length - places[start + i] + startPlace, numberOfCuts - i - 1, places, start + i + 1,
                                    end, places[start + i]));
        }
        return min;
    }

    public int memo(final int length, final int numberOfCuts, final int[] places) {
        final int[][] memo = new int[places.length][places.length];
        return memo(length, numberOfCuts, places, 0, places.length - 1, 0, memo);
    }

    private int memo(final int length, final int numberOfCuts, final int[] places, final int start, final int end,
            final int startPlace, final int[][] memo) {
        if (numberOfCuts == 0) {
            return 0;
        }
        if (memo[start][end] != 0) {
            return memo[start][end];
        }
        memo[start][end] = Integer.MAX_VALUE;
        for (int i = 0; i < numberOfCuts; i++) {
            memo[start][end] = Math.min(memo[start][end],
                    length + memo(places[start + i] - startPlace, i, places, start, start + i - 1, startPlace, memo)
                            + memo(length - places[start + i] + startPlace, numberOfCuts - i - 1, places, start + i + 1,
                                    end, places[start + i], memo));
        }
        return memo[start][end];
    }
}
