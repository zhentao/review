package com.zhentao.review.cracking;

import java.util.HashSet;
import java.util.Set;

public class PowerSet {

	public static void main(String[] args) {
		Set<Integer> set = new HashSet<>();
		set.add(1);
		set.add(2);
		set.add(3);
		for (Set<Integer> powerset : get(set)) {
			System.out.println(powerset);
		}
	}
	public static <T> Set<Set<T>> get(Set<T> set) {
		if (set == null) {
			return null;
		}
		Set<Set<T>> sets = new HashSet<Set<T>>();
		//empty set is one of the sub set
		sets.add(new HashSet<T>());
		for (T element : set) {
			get(sets, element);
		}
		return sets;
	}
	
	private static <T> void get(Set<Set<T>> sets, T element) {
		Set<Set<T>> newsets = new HashSet<Set<T>>();
		for (Set<T> myset : sets) {
			Set<T> mynewset = new HashSet<T>(myset);
			mynewset.add(element);
			newsets.add(mynewset);
		}
		sets.addAll(newsets);
	}
}
