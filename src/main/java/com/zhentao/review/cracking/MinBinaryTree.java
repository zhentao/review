package com.zhentao.review.cracking;

/**
 * <b>4.2 Minimal Tree</b>
 * Given a sorted (increasing order) array with unique integer elements, write an algorithm 
 * to create a binary search tree with minimal height.
 * @author zhentao.li
 *
 */
public class MinBinaryTree {
	public static void main(String[] args) {
		int[] array = {1,2,3,4,5,6,7};
		BinaryNode<Integer> node = minTree(array);
		node.inOrder();
	}
	public static BinaryNode<Integer> minTree(int[] array) {
		return minTree(array, 0, array.length-1);
	}
	
	private static BinaryNode<Integer> minTree(int[] array, int start, int end) {
		if (start > end) {
			return null;
		}
		int mid = end - (end - start) / 2;
		BinaryNode<Integer> left = minTree(array, start, mid-1);
		BinaryNode<Integer> right = minTree(array, mid+1, end);
		return new BinaryNode<Integer>(array[mid], left, right);
	}
}
