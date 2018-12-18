package com.zhentao.review.cracking;

import java.util.Arrays;

/**
 * <b>1.7 Rotate Matrix</b>
 * Rotate Matrix: Given an image represented by an NxN matrix, where each pixel in the image is 4
 * bytes, write a method to rotate the image by 90 degrees. (an you do this in place?
 * @author zhentao.li
 *
 */
public class MatrixRotation {

	public static void main(String[] args) {
		int[][] matrix = {{1,2,3,4}, {5, 6,7,8},{9,10,11,12},{13,14,15,16}};
		print(rotate(matrix));
	}
	public static int[][] rotate(int[][] input) {
		
		int length = input.length;
		int[][] copy = new int[length][length];
		
		for (int i = 0; i < length; i++) {
			for (int j = 0; j < length; j++) {
				copy[j][length - i - 1] = input[i][j];
			}
		}

		return copy;
	}
	
	private static void print(int[][] matrix) {
		for (int[] row : matrix) {
			System.out.println(Arrays.toString(row));
		}
	}
}
