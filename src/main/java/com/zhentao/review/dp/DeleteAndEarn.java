package com.zhentao.review.dp;

/**
 * <b>740. Delete and Earn</b>
 * <pre>
 *  Given an array nums of integers, you can perform operations on the array.

In each operation, you pick any nums[i] and delete it to earn nums[i] points. After, you must delete every element equal to nums[i] - 1 or nums[i] + 1.

You start with 0 points. Return the maximum number of points you can earn by applying such operations.

Example 1:

Input: nums = [3, 4, 2]
Output: 6
Explanation: 
Delete 4 to earn 4 points, consequently 3 is also deleted.
Then, delete 2 to earn 2 points. 6 total points are earned.

Example 2:

Input: nums = [2, 2, 3, 3, 3, 4]
Output: 9
Explanation: 
Delete 3 to earn 3 points, deleting both 2's and the 4.
Then, delete 3 again to earn 3 points, and 3 again to earn 3 points.
9 total points are earned.

Note:
The length of nums is at most 20000.
Each element nums[i] is an integer in the range [1, 10000].
 * </pre>
 * @author zhentao.li
 *
 */

/**
 * 1- System Design，design chat system，聊了很久的message怎么存，DB table怎么
 * 设计，以及聊了一些的socket，面试官问一台server可以连接多少socket connection
 * ，竟然可以有上million，我以为只能65535这个order的
 * 
 * 2- 一个很长的数组，random的，求[s, e]之间的最大值的index，可以任何形式的预处 理，最终是用segment
 * tree做的，没准备到这个，提示之后才想到segment tree
 * 
 * 3- 两个字符串只有一个不同，找出那个，要求O(1) space, 逐个相加求差或者逐个XOR 就可以了 24点游戏，基本上是next
 * permutation和add operator的结合
 * 
 * 4- 汇率的那个题，给出很多汇率的比，LC399的变形，这题没刷到，写了个DFS，看来 给过了
 * 
 * 5- LC549 和 binary tree里找出和某node距离为k的所有node
 * 
 * 总结就是 Google这么喜欢出DFS/BFS类的search的题目。。。
 * 
 * @author zhentao.li
 *
 */
public class DeleteAndEarn {
	public static int earn(int[] nums) {
		int[] memo = new int[10001];
		int length = nums.length;
		for (int i = 0; i < length; i++) {
			memo[nums[i]]++;
		}
		int avoid = 0, using = 0, prev = -1;

		for (int k = 0; k <= 10000; ++k) {
			if (memo[k] > 0) {
				int m = Math.max(avoid, using);
				if (k - 1 != prev) {
					using = k * memo[k] + m;
					avoid = m;
				} else {
					using = k * memo[k] + avoid;
					avoid = m;
				}
				prev = k;
			}
		}
		return Math.max(avoid, using);
	}

}
