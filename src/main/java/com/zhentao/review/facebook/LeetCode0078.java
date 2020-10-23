package com.zhentao.review.facebook;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a set of distinct integers, nums, return all possible subsets (the
 * power set).
 *
 * Note: The solution set must not contain duplicate subsets.
 *
 * @author zhentao.li
 *
 */
public class LeetCode0078 {

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3 };
        for (int i = 4; i < 8; i++) {
            System.out.println(Integer.toBinaryString(i));
        }
        System.out.println(new LeetCode0078().subsets(nums));
    }

    public List<List<Integer>> subsets1(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());

        for (int n : nums) {
            List<List<Integer>> newResult = new ArrayList<>();

            for (List<Integer> subList : result) {
                List<Integer> newSubList = new ArrayList<>(subList);
                //add this element to every list in the result
                newSubList.add(n);
                newResult.add(newSubList);
            }
            result.addAll(newResult);
        }
        return result;
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        for (int i : nums) {
            List<List<Integer>> newList = new ArrayList<>();
            for (List<Integer> list : result) {
                ArrayList<Integer> subList = new ArrayList<>(list);
                subList.add(i);
                newList.add(subList);
            }
            result.addAll(newList);
        }
        return result;
    }
}
