package com.zhentao.review.cracking;

/**
 * <b>17 .16 The Masseuse</b>
 * <pre>
 * A popular masseuse receives a sequence of back-to-back appointment requests
and is debating which ones to accept. She needs a 15-minute break between appointments and
therefore she cannot accept any adjacent requests. Given a sequence of back-to-back appointment
requests (all multiples of 15 minutes, none overlap, and none can be moved), find the optimal
(highest total booked minutes) set the masseuse can honor. Return the number of minutes.
EXAMPLE
Input: {30, 15, 60, 75, 45, 15, 15, 45}
Output: 180 minutes ({30, 60, 45, 45}).
 * </pre>
 * @author zhentao
 *
 */
public class Masseuse {
    public static void main(String[] args) {
        int[] inputs = {30, 15, 60, 75, 45, 15, 15, 45};
        System.out.println(book(inputs));
        System.out.println(dp(inputs));
    }
    public static int book(int[] inputs) {
        int[] memo = new int[inputs.length];
         book(inputs, 0, memo);
         return memo[0];
    }
    
    private static int book(int[] inputs, int i, int[] memo) {
        if (i >= inputs.length) {
            return 0;
        }
        if (memo[i] > 0) {
            return memo[i];
        }
        int bestWithCurrElement = inputs[i] + book(inputs, i+2, memo);
        int bestWithoutCurrElement = book(inputs, i+1, memo);
        
        memo[i] = Math.max(bestWithCurrElement, bestWithoutCurrElement);
        return memo[i];
    }
    
    public static int dp(int[] inputs) {
        int bestWithoutPrev = 0;
        int bestWithPrev = 0;
        
        for (int i = 0; i  <inputs.length; i++) {
            bestWithoutPrev += inputs[i];
            int current = Math.max(bestWithoutPrev, bestWithPrev);
            bestWithoutPrev = bestWithPrev;
            bestWithPrev = current;
        }
        
        return bestWithPrev;
    }
}
