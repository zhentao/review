package com.zhentao.review.dp;

/**
 * <b>494. Target Sum</b>
 * <pre>
 *  You are given a list of non-negative integers, a1, a2, ..., an, and a target, S. Now you have 2 symbols + and -. For each integer, you should choose one from + and - as its new symbol.

Find out how many ways to assign symbols to make sum of integers equal to target S.

Example 1:

Input: nums is [1, 1, 1, 1, 1], S is 3. 
Output: 5
Explanation: 

-1+1+1+1+1 = 3
+1-1+1+1+1 = 3
+1+1-1+1+1 = 3
+1+1+1-1+1 = 3
+1+1+1+1-1 = 3

There are 5 ways to assign symbols to make the sum of nums be target 3.

Note:

    The length of the given array is positive and will not exceed 20.
    The sum of elements in the given array will not exceed 1000.
    Your output answer is guaranteed to be fitted in a 32-bit integer.

 * </pre>
 * @author zhentao.li
 *
 */
public class TargetSum {
	public static void main(String[] args) {
		System.out.println(findTargetSumWays(new int[]{1,1,1,1,1}, 3));
	}
    public static int findTargetSumWays(int[] nums, int S) {
    	int[] count = new int[1];
        calculate(nums, 0, 0, S, count);
        return count[0];
    }
    private static void calculate(int[] nums, int i, int sum, int S, int[] count) {
        if (i == nums.length) {
            if (sum == S)
                count[0]++;
        } else {
            calculate(nums, i + 1, sum + nums[i], S, count);
            calculate(nums, i + 1, sum - nums[i], S, count);
        }
    }
	
	
//	int count = 0;
//    public int findTargetSumWays(int[] nums, int S) {
//        int[][] memo = new int[nums.length][2001];
//        for (int[] row: memo)
//            Arrays.fill(row, Integer.MIN_VALUE);
//        return calculate(nums, 0, 0, S, memo);
//    }
//    public int calculate(int[] nums, int i, int sum, int S, int[][] memo) {
//        if (i == nums.length) {
//            if (sum == S)
//                return 1;
//            else
//                return 0;
//        } else {
//            if (memo[i][sum + 1000] != Integer.MIN_VALUE) {
//                return memo[i][sum + 1000];
//            }
//            int add = calculate(nums, i + 1, sum + nums[i], S, memo);
//            int subtract = calculate(nums, i + 1, sum - nums[i], S, memo);
//            memo[i][sum + 1000] = add + subtract;
//            return memo[i][sum + 1000];
//        }
//    }
}
