package com.zhentao.review.dp;

/**
 * <b>413. Arithmetic Slices</b>
 * <pre>
 * A sequence of number is called arithmetic if it consists of at least three elements and if the difference between any two consecutive elements is the same.

For example, these are arithmetic sequence:

1, 3, 5, 7, 9
7, 7, 7, 7
3, -1, -5, -9

The following sequence is not arithmetic.

1, 1, 2, 5, 7


A zero-indexed array A consisting of N numbers is given. A slice of that array is any pair of integers (P, Q) such that 0 <= P < Q < N.

A slice (P, Q) of array A is called arithmetic if the sequence:
A[P], A[p + 1], ..., A[Q - 1], A[Q] is arithmetic. In particular, this means that P + 1 < Q.

The function should return the number of arithmetic slices in the array A.

Example:

A = [1, 2, 3, 4]

return: 3, for 3 arithmetic slices in A: [1, 2, 3], [2, 3, 4] and [1, 2, 3, 4] itself.


 * </pre>
 * @author zhentao.li
 *
 */
public class ArithmeticSlices {
	
	public static void main(String[] args) {
		int[] input = {1, 2, 3, 5, 7, 9, 10, 12, 13, 14};
		System.out.println(find(input));
	}
	public static int find(int[] input) {
		if (input == null) {
			return 0;
		}
		int length = input.length;
		if (length < 3) {
			return 0;
		}
		int count = 0;
		int start = 0;
		int diff = input[1] - input[0];
		for (int i = 2; i < length; i++) {
			int newDiff = input[i] - input[i-1];
			if (newDiff == diff) {
				//(i - 1) - start is the number of slices with new element
				count += (i - 1) - start;
			} else {
				start = i - 1;
				diff = newDiff;
			}
		}
		return count;
	}

}
