package com.zhentao.review.cracking;

import java.util.ArrayList;
import java.util.List;

public class Parens {
	public static void main(String[] args) {
		System.out.println(generate(3));
		int result = (1)^(((0)|(0))|(1));
		System.out.println(result);
	}
	public static List<String> generate(int n) {
		List<String> result = new ArrayList<>();
		char[] str = new char[2*n];
		addParen(result, n, n, str, 0);
		return result;
	}
	
	private static void addParen(List<String> result, int leftRem, int rightRem, char[] str, int index) {
		if (leftRem < 0 || rightRem < leftRem) {
			return;
		}
		
		if (leftRem == 0 && rightRem == 0) {
			result.add(String.valueOf(str));
		} else {
			str[index] = '(';
			addParen(result, leftRem-1, rightRem, str, index+1);
			
			str[index] = ')';
			addParen(result, leftRem, rightRem-1, str, index+1);
		}
	}
}
