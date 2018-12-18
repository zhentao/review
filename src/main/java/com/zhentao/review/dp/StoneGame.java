package com.zhentao.review.dp;

/**
 * <b> 877. Stone Game </b>
 * <pre>
 * Alex and Lee play a game with piles of stones. There are an even number
 * of piles arranged in a row, and each pile has a positive integer number of stones piles[i].
 *
 * The objective of the game is to end with the most stones. The total number of stones is odd, so
 * there are no ties.
 *
 * Alex and Lee take turns, with Alex starting first. Each turn, a player takes the entire pile of
 * stones from either the beginning or the end of the row. This continues until there are no more
 * piles left, at which point the person with the most stones wins.
 *
 * Assuming Alex and Lee play optimally, return True if and only if Alex wins the game.
 *</pre>
 *<pre>
 *Example 1:

    Input: [5,3,4,5]
    Output: true
    Explanation:
    Alex starts first, and can only take the first 5 or the last 5.
    Say he takes the first 5, so that the row becomes [3, 4, 5].
    If Lee takes 3, then the board is [4, 5], and Alex takes 5 to win with 10 points.
    If Lee takes the last 5, then the board is [3, 4], and Alex takes 4 to win with 9 points.
    This demonstrated that taking the first 5 was a winning move for Alex, so we return true.
 *</pre>
 *<pre>
 *
 *Note:

    1. 2 <= piles.length <= 500
    2. piles.length is even.
    3. 1 <= piles[i] <= 500
    4. sum(piles) is odd
 *
 *</pre>
 * @author zhentao.li
 *
 */
public class StoneGame {

    public static void main(String[] args) {
        System.out.println(move(new int[]{5,3,4,5}));
    }
    public static int move(int[] piles) {
    	//return true;
        return move(piles, 0, piles.length - 1);
    }

    private static int move(int[] piles, int start, int end) {
        if (start > end) {
            return 0;
        }
        if (end - start == 1) {
            return Math.max(piles[start], piles[end]);
        }
        int a = move(piles, start + 1, end) + piles[start];
        int b = Math.max(move(piles, start + 2, end) + piles[start + 1], move(piles, start + 1, end -1) + piles[end]);
        if (a > b) {
            return a;
        }
        int aa = move(piles, start, end-1) + piles[end];
        int bb = Math.max(move(piles, start + 1, end-1) + piles[start], move(piles, start, end - 2)+piles[end-1]);

        return aa;
    }
}
