package com.zhentao.review.dp;

/**
 * <b>931. Minimum Falling Path Sum</b>
 * <pre>
 * Given a square array of integers A, we want the minimum sum of a falling path through A.

 A falling path starts at any element in the first row, and chooses one element from each row.  
 The next row's choice must be in a column that is different from the previous row's column by at most one.

 

Example 1:

Input: [[1,2,3],[4,5,6],[7,8,9]]
Output: 12
Explanation: 
The possible falling paths are:

    [1,4,7], [1,4,8], [1,5,7], [1,5,8], [1,5,9]
    [2,4,7], [2,4,8], [2,5,7], [2,5,8], [2,5,9], [2,6,8], [2,6,9]
    [3,5,7], [3,5,8], [3,5,9], [3,6,8], [3,6,9]

The falling path with the smallest sum is [1,4,7], so the answer is 12.

Note:
    <li>1 <= A.length == A[0].length <= 100
    <li>-100 <= A[i][j] <= 100

 * </pre>
 * @author zhentao.li
 *
 */
public class MinimumFallingPathSum {

	public static void main(String[] args) {
		int[][] input = {{1,2,3},{4,5,6},{7,8,9}};
		System.out.println(find(input));
	}
	public static int find(int[][] input) {
		int length = input.length;
		int[][] result = new int[length][length];
		for (int i = 0; i < length; i++) {
			result[length-1][i] = input[length-1][i];
		}
		for (int i = length - 2; i >= 0; i--) {
			for (int j = 0; j < length; j++) {
				if (j == 0) {
					result[i][j] = input[i][j] + Math.min(result[i+1][j], result[i+1][j+1]);
				} else if (j == length -1) {
					result[i][j] = input[i][j] + Math.min(result[i+1][j], result[i+1][j-1]);
				} else {
					result[i][j] = input[i][j] + min(result[i+1][j-1], result[i+1][j], result[i+1][j+1]);
				}
			}
		}
		int min = Integer.MAX_VALUE;
		for (int j = 0; j < length; j++) {
			if (min > result[0][j]) {
				min = result[0][j];
			}
		}
		return min;
	}
	
	private static int min(int a, int b, int c) {
		return Math.min(Math.min(a, b), c);
	}
}
