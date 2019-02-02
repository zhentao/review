package com.zhentao.review.leetcode;

/**
 * <b>374. Guess Number Higher or Lower</b>
 * 
 * <pre>
 * We are playing the Guess Game. The game is as follows:

I pick a number from 1 to n. You have to guess which number I picked.

Every time you guess wrong, I'll tell you whether the number is higher or lower.

You call a pre-defined API guess(int num) which returns 3 possible results (-1, 1, or 0):

-1 : My number is lower
 1 : My number is higher
 0 : Congrats! You got it!
Example :

Input: n = 10, pick = 6
Output: 6
 * </pre>
 * 
 * @author zhentao
 *
 */
public class GuessNumberHighOrLow extends GuessGame {
    public int guessNumber(final int n) {
        return guessNumber(1, n);
    }
    
    private int guessNumber(final int start, final int end) {
        if (start > end) {
            throw new RuntimeException("start=" + start + " end="+end);
        }
        final int mid = start + (end-start)/2;
        final int result = guess(mid);
        if (result < 0) {
            return guessNumber(start, mid-1);
        } else if (result > 0){
            return guessNumber(mid+1, end);
        } else {
            return mid;
        }
    }
}

class GuessGame {

    private int pick;

    public void setPick(final int pick) {
        this.pick = pick;
    }

    /**
     * 
     * @param num your guess
     * @return -1 if pick is lower, 1 if my number is higher, otherwise return
     *         0
     */
    int guess(final int num) {
        return num > pick ? -1 : num < pick ? 1 : 0;
    }
}
