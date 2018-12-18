package com.zhentao.review.dp;

/**
 * <b>650. 2 Keys Keyboard</b>
 * 
 * <pre>
 *  Initially on a notepad only one character 'A' is present. You can perform two operations on this notepad for each step:

    Copy All: You can copy all the characters present on the notepad (partial copy is not allowed).
    Paste: You can paste the characters which are copied last time.

Given a number n. You have to get exactly n 'A' on the notepad by performing the minimum number of steps permitted. Output the minimum number of steps to get n 'A'.

Example 1:

Input: 3
Output: 3
Explanation:
Intitally, we have one character 'A'.
In step 1, we use Copy All operation.
In step 2, we use Paste operation to get 'AA'.
In step 3, we use Paste operation to get 'AAA'.

Note:

    The n will be in the range [1, 1000].
 * 
 * </pre>
 * 
 * @author zhentao.li
 *
 */
public class TwoKeysKeyboard {

	public static void main(String[] args) {
//		System.out.println(minSteps(1));
//		System.out.println(minSteps(2));
//		System.out.println(minSteps(3));
//		System.out.println(minSteps(4));
		System.out.println(minSteps(9));
		System.out.println(minSteps2(9));
		System.out.println(minSteps(12));
		System.out.println(minSteps2(12));
	}

	public static int minSteps(int m) {
//		if (n == 1) {
//			return 0;
//		} else if(n == 2) {
//			return 1;
//		}
//		int m = n;
		int steps = 0;
		for (int i = 2; i <= Math.sqrt(m); i++) {
			while (m % i == 0) {
				m = m / i;
				steps += i;
			}
		}
		if (m == 1) {
			return steps;
		} else {
			return steps + m;
		}

//		int ans = 0, d = 2;
//        while (n > 1) {
//            while (n % d == 0) {
//                ans += d;
//                n /= d;
//                System.out.println(d);
//            }
//            d++;
//        }
//        return ans;
	}

	public static int minSteps2(int n) {
		int ans = 0, d = 2;
		while (n > 1) {
			while (n % d == 0) {
				ans += d;
				n /= d;
			}
			d++;
		}
		return ans;
	}

}
