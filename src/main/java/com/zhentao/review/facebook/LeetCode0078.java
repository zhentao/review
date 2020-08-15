package com.zhentao.review.facebook;

import java.util.ArrayList;
import java.util.List;

public class LeetCode0078 {

    public static void main(String[] args) {
        int[] nums = {1, 2,3};
        for (int i = 4; i < 8; i++) {
        System.out.println(Integer.toBinaryString(i));
        }
        System.out.println(new LeetCode0078().subsets(nums));
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
