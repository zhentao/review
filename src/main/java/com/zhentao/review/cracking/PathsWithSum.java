package com.zhentao.review.cracking;

public class PathsWithSum {
	public static void main(String[] args) {
		System.out.println(~1);
		BinaryNode<Integer> n1 = new BinaryNode<Integer>(1, null, null);
		BinaryNode<Integer> n3 = new BinaryNode<Integer>(3, null, null);
		BinaryNode<Integer> n2 = new BinaryNode<Integer>(2, n1, n3);
		BinaryNode<Integer> n6 = new BinaryNode<Integer>(6, null, null);
		BinaryNode<Integer> n7 = new BinaryNode<Integer>(7, n6, null);
		BinaryNode<Integer> n5 = new BinaryNode<Integer>(5, null, n7);
		BinaryNode<Integer> n4 = new BinaryNode<Integer>(4, n2, n5);
		System.out.println(countPaths(n4, 9));
		System.out.println(countPaths(n4, 3));
		System.out.println(countPaths(n4, 5));
	}
	
	public static int countPaths(BinaryNode<Integer> node, int target) {
		
		if (node == null) {
			return 0;
		}
		return countPaths(node.left, target) + countPathsFromRoot(node, target, 0) + countPaths(node.right, target);
		
	}

	private static int countPathsFromRoot(BinaryNode<Integer> node, int target, int sum) {
		if (node == null) {
			return 0;
		}
		int current = node.data + sum;
		if (current == target) {
			return 1;
		} else {
			return countPathsFromRoot(node.left, target, current) + countPathsFromRoot(node.right, target, current);
		}

	}
}
