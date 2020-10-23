package com.zhentao.review.facebook;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * <b>653. Two Sum IV - Input is a BST</b> Given a Binary Search Tree and a
 * target number, return true if there exist two elements in the BST such that
 * their sum is equal to the given target.
 *
 * @author zhentao.li
 *
 */
public class LeetCode0653 {

    public boolean findTarget2(TreeNode root, int k) {
        Set<Integer> set = new HashSet<>();
        return find2(root, set, k);
    }

    private boolean find2(TreeNode node, Set<Integer> nums, int k) {
        if (node == null) {
            return false;
        }
        if (nums.contains(k-node.val)) {
            return true;
        } else {
            nums.add(node.val);
        }
        return find2(node.left, nums, k) || find2(node.right, nums, k);
    }

    /**
     * assume duplicates are allowed
     * @param root
     * @param k
     * @return
     */
    public boolean findTarget(TreeNode root, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        inOrder(root, map);

        for (int key : map.keySet()) {
            int other = k - key;
            if (map.containsKey(other)) {
                if (other == key) {
                    if (map.get(other) > 1) {
                        return true;
                    }
                } else {
                    return true;
                }
            }
        }
        return false;
    }

    private void inOrder(TreeNode node, Map<Integer, Integer> map) {
        if (node == null) {
            return;
        }
        map.put(node.val, map.getOrDefault(node.val, 0) + 1);
        inOrder(node.left, map);
        inOrder(node.right, map);
    }

    public boolean findTargetNoDups(TreeNode root, int k) {
        Set<Integer> set = new HashSet<>();

        return inOrder(root, set, k);
    }

    private boolean inOrder(TreeNode node, Set<Integer> set, int target) {
        if (node == null) {
            return false;
        }
        if (set.contains(target-node.val)) {
            return true;
        }
        set.add(node.val);
        return inOrder(node.left, set, target) || inOrder(node.right, set, target);
    }


    /**
     * find the target in a different level
     * @param root
     * @param k
     * @return
     */
    public boolean findTargetDiffLevel(TreeNode root, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        return inOrder(root, map, 0, k);
    }

    private boolean inOrder(TreeNode node, Map<Integer, Integer> map, int level, int target) {
        if (node == null) {
            return false;
        }
        Integer other = map.get(target - node.val);
        if (other != null && other.intValue() != level) {
            return true;
        }
        map.put(node.val, level);
        return inOrder(node.left, map, level+1, target) || inOrder(node.right, map, level+1, target);
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }
}
