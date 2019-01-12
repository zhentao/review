package com.zhentao.review.cracking;

/**
 * Magic Index: A magic index in an array A [1. .. n -1] is defined to be an
 * index such that A[ i]= i. Given a sorted array of distinct integers, write a
 * method to find a magic index, if one exists, in array A. FOLLOW UP What if
 * the values are not distinct?
 * 
 * @author zhentao.li
 *
 */
public class MagicIndex {
	public static void main(String[] args) {
		int[] input = new int[] {-2, -1, 0,3,5};
		System.out.println(find(input));
	}
	
	public static int find(int[] input) {
		return find(input, 0, input.length - 1);
	}

	private static int find(int[] input, int start, int end) {
		if (start > end) {
			return -1;
		}
		int mid = start + (end - start) / 2;
		if (input[mid] == mid) {
			return mid;
		} else if (input[mid] > mid) {
			return find(input, start, mid - 1);
		} else {
			return find(input, mid + 1, end);
		}
	}
}
