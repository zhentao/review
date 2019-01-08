package com.zhentao.review.cracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class BinaryNode<T> {
	public T data;
	public BinaryNode<T> left;
	public BinaryNode<T> right;
	public BinaryNode(T data, BinaryNode<T> left, BinaryNode<T> right) {
		this.data = data;
		this.left = left;
		this.right = right;
	}

	public void inOrder() {
		Stack<BinaryNode<T>> stack = new Stack<>();
		BinaryNode<T> current = this;
		while (current != null || !stack.isEmpty()) {
			if (current != null) {
				stack.push(current);
				current = current.left;
			} else {
				BinaryNode<T> top = stack.pop();
				System.out.println(top.data.toString());
				current = top.right;
			}
		}
	}

	/**
	 * print left, parent, right
	 */
	public void inOrderRecursive() {
		if (left != null) {
			left.inOrderRecursive();
		}
		System.out.println(data.toString());
		if (right != null) {
			right.inOrderRecursive();
		}
	}

	/**
	 * print parent, left, right
	 */
	public void preOrderRecursive() {
		System.out.println(data.toString());
		if (left != null) {
			left.inOrderRecursive();
		}
		if (right != null) {
			right.inOrderRecursive();
		}
	}

	/**
	 * print left, right, parent
	 */
	public void postOrderRecursive() {
		if (left != null) {
			left.inOrderRecursive();
		}
		if (right != null) {
			right.inOrderRecursive();
		}
		System.out.println(data.toString());
	}

	public void breathFirst() {
		Queue<BinaryNode<T>> q = new LinkedList<>();
		q.add(this);
		while(!q.isEmpty()) {
			BinaryNode<T> node = q.remove();
			System.out.println(node.data.toString());
			if (node.left != null) {
				q.add(node.left);
			}
			if (node.right != null) {
				q.add(node.right);
			}
			
		}
	}
	
	public int height() {
		int leftHeight = 0;
		if (left != null) {
			leftHeight = left.height();
		}
		int rightHeight = 0;
		if (right != null) {
			rightHeight = right.height();
		}
		return 1 + Math.max(leftHeight, rightHeight);
	}
	
	public static <T> void inOrder(BinaryNode<T> node) {
		if (node == null) {
			return;
		}
		inOrder(node.left);
		System.out.println(node);
		inOrder(node.right);
	}
 	@Override
	public String toString() {
		return data.toString();
	}

	public static void main(String[] args) {

	    BinaryNode<Integer> n0 = new BinaryNode<Integer>(0, null, null);
		BinaryNode<Integer> n1 = new BinaryNode<Integer>(1, n0, null);
		BinaryNode<Integer> n3 = new BinaryNode<Integer>(3, null, null);
		BinaryNode<Integer> n2 = new BinaryNode<Integer>(2, n1, n3);
		BinaryNode<Integer> n6 = new BinaryNode<Integer>(6, null, null);
		BinaryNode<Integer> n7 = new BinaryNode<Integer>(7, n6, null);
		BinaryNode<Integer> n5 = new BinaryNode<Integer>(5, null, n7);
		BinaryNode<Integer> n4 = new BinaryNode<Integer>(4, n2, n5);
//		n4.inOrder();
//		n4.inOrderRecursive();
//		n4.breathFirst();
		System.out.println(n4.height());
		System.out.println(n4.leaves());
		n2 = new BinaryNode<Integer>(2, n1, null);
		n3 = new BinaryNode<Integer>(3, n2, null);
		n4 = new BinaryNode<Integer>(4, n3, null);
		System.out.println(n4.leaves());
		
	}
	
	/**
	 * return all leaves in order from left to right
	 * @return
	 */
	public List<BinaryNode<T>> leaves() {
	    List<BinaryNode<T>> list = new ArrayList<>();
	    leaves(list);
	    return list;
	}
	
	private void leaves(List<BinaryNode<T>> list) {
	    if (this.left != null) {
	        left.leaves(list);
	    }
	    if (this.right != null) {
	        right.leaves(list);
	    }
	    if (this.left == null && this.right == null) {
	        list.add(this);
	    }
	}
}
