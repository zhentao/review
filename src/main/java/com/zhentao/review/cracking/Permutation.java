package com.zhentao.review.cracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Permutation {
	public static void main(String[] args) {
		System.out.println(perm("abc"));
		System.out.println(permWithRecursive("abc"));
		System.out.println(allPerm("abc"));
		System.out.println(permWithDups("aabcb").size());
	}

	public static List<String> perm(String str) {
		ArrayList<String> list = new ArrayList<>();
		int length = str.length();
		if (length == 0) {
			list.add("");
		}
		for (int i = 0; i < length; i++) {
			List<String> partials = perm(str.substring(0, i) + str.substring(i + 1, length));
			for (String s : partials) {
				list.add(str.charAt(i) + s);
			}
		}
		return list;
	}
	
	/**
	 * return all possible combinations from length zero to str.length
	 * @param str
	 * @return
	 */
	public static List<String> allPerm(String str) {
		ArrayList<String> list = new ArrayList<>();
		int length = str.length();

		list.add("");
		for (int i = 0; i < length; i++) {
			List<String> partials = allPerm(str.substring(0, i) + str.substring(i + 1, length));
			for (String s : partials) {
				list.add(str.charAt(i) + s);
			}
		}
		return list;
	}
	
	public static List<String> permWithDups(String str) {
		ArrayList<String> result = new ArrayList<>();
		Map<Character, Integer> freqMap = buildFreqTable(str);
		permWithDups(str.length(), "", result, freqMap);
		return result;
	}
	
	private static Map<Character, Integer> buildFreqTable(String str) {
		Map<Character, Integer> map = new HashMap<>();
		for (Character c : str.toCharArray()) {
			if (map.containsKey(c)) {
				map.put(c, map.get(c) + 1);
			} else {
				map.put(c, 1);
			}
		}
		return map;
	}
	
	private  static void permWithDups(int remaining, String prefix, List<String> result, Map<Character, Integer> freqMap) {
		if (remaining == 0) {
			result.add(prefix);
			return;
		}
		for (Character c : freqMap.keySet()) {
			int count = freqMap.get(c);
			if (count > 0) {
				freqMap.put(c, count-1);
				permWithDups(remaining-1, prefix + c, result, freqMap);
				freqMap.put(c, count);
			}
		}
	}
	
	/**
	 * no dups
	 * @param str
	 * @return
	 */
	public static List<String> permWithRecursive(String str) {
		List<String> result = new ArrayList<>();
		perWithRecursive(str, "", result);
		return result;
	}
	
	private static void perWithRecursive(String remaining, String prefix, List<String> result) {
		int length = remaining.length();
		if (length == 0) {
			result.add(prefix);
			return;
		}
		for (int i = 0; i < length; i++) {
			char c = remaining.charAt(i);
			perWithRecursive(remaining.substring(0, i) + remaining.substring(i+1, length), prefix + c, result);
		}
	}
}
