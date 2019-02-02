package com.zhentao.review.dp;

/**
 * <b>121. Best Time to Buy and Sell Stock</b>
 * Input: [7,1,5,3,6,4] Output: 5 Explanation: Buy on day 2 (price = 1) and sell on day 5 (price =
 * 6), profit = 6-1 = 5. Not 7-1 = 6, as selling price needs to be larger than buying price.
 *
 * Input: [7,6,4,3,1] Output: 0 Explanation: In this case, no transaction is done, i.e. max profit =
 * 0.
 *
 * @author zhentao.li
 *
 */
public class MaxStockProfit {
    public static void main(String[] args) {
        int[] prices = new int[] {7,1,5,3,6,4, 10, 9,6};
        System.out.println(profitBrute(prices));
        System.out.println(profit(prices));
        prices = new int[] {7,6,3,3,2, 10, 1, 10};
        System.out.println(profitBrute(prices));
        System.out.println(profit(prices));
    }
    public static int profitBrute(int[] prices) {
        int size = prices.length;
        int maxProfit = 0;
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                int profit = prices[j] - prices[i];
                if (maxProfit < profit) {
                    maxProfit = profit;
                }
            }
        }
        return maxProfit;

    }

    public static int profit(int[] prices) {
        if (prices == null) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        int profit = 0;

        for (int price : prices) {
            min = Math.min(min, price);
            profit = Math.max(profit, price - min);
        }
        return profit;
    }
}
