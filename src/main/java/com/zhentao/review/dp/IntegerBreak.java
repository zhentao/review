package com.zhentao.review.dp;

import java.util.ArrayList;

/**
 * <b>343. Integer Break</b>
 * 
 * <pre>
 *  
 *Given a positive integer n, break it into the sum of at least two positive integers and maximize the product 
 *of those integers. Return the maximum product you can get.

Example 1:

Input: 2
Output: 1
Explanation: 2 = 1 + 1, 1 × 1 = 1.

Example 2:

Input: 10
Output: 36
Explanation: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36.

Note: You may assume that n is not less than 2 and not larger than 58.
 * </pre>
 * 
 * @author zhentao.li
 *
 */
public class IntegerBreak {
	public static void main(String[] args) {
		System.out.println(find(5));
		System.out.println(find(10));
	}
	public static int find(int n) {
		if (n == 2) return 1;
		if (n == 3) return 2;
		if (n == 4) return 4;
		int prodWithoutLast2 = 1;
		int last = 2;
		int nextToLast = 2;
		for (int i = 5; i <= n; i++) {
			if (last == 2) {
				last = 3;
			} else if (last == 3 && nextToLast == 2) {
				nextToLast = 3;
			} else {
				prodWithoutLast2 *= 3;
				last = 2;
				nextToLast = 2;
			}
		}
		return prodWithoutLast2 * last * nextToLast;
	}
}
