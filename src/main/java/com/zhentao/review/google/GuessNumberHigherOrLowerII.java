package com.zhentao.review.google;

/**
 * <b>375. Guess Number Higher or Lower II</b>
 * 
 * <pre>
 * We are playing the Guess Game. The game is as follows:

I pick a number from 1 to n. You have to guess which number I picked.

Every time you guess wrong, I'll tell you whether the number I picked is higher or lower.

However, when you guess a particular number x, and you guess wrong, you pay $x. You win the game when you guess the number I picked.

Example:

n = 10, I pick 8.

First round:  You guess 5, I tell you that it's higher. You pay $5.
Second round: You guess 7, I tell you that it's higher. You pay $7.
Third round:  You guess 9, I tell you that it's lower. You pay $9.

Game over. 8 is the number I picked.

You end up paying $5 + $7 + $9 = $21.
Given a particular n ≥ 1, find out how much money you need to have to guarantee a win.
 * </pre>
 * 
 * @author zhentao
 *
 */
public class GuessNumberHigherOrLowerII {
    public int getMoneyAmount(final int n) {
        final int[][] memo = new int[n+1][n+1];
        
        return getMoneyAmount(1, n, memo);
    }
    
    private int getMoneyAmount(final int i, final int j, final int[][] memo) {
        if (i >= j) {
            return 0;
        }
        if (memo[i][j] != 0) {
            return memo[i][j];
        }
        memo[i][j] = Integer.MAX_VALUE;
        for (int m = i; m <=j; m++) {
            final int tmp = m + Math.max(getMoneyAmount(i, m-1, memo), getMoneyAmount(m+1, j, memo));
            memo[i][j] = Math.min(tmp, memo[i][j]);
        }
        return memo[i][j];
    }
    
}
