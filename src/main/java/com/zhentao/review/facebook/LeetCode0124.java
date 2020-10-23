package com.zhentao.review.facebook;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * <b>124. Binary Tree Maximum Path Sum</b> Given a non-empty binary tree, find
 * the maximum path sum.
 *
 * For this problem, a path is defined as any sequence of nodes from some
 * starting node to any node in the tree along the parent-child connections. The
 * path must contain at least one node and does not need to go through the root.
 *
 * <pre>
Example 1:

Input: [1,2,3]

       1
      / \
     2   3

Output: 6

Example 2:

Input: [-10,9,20,null,null,15,7]

   -10
   / \
  9  20
    /  \
   15   7

Output: 42
 * </pre>
 *
 * @author zhentao.li
 *
 */
public class LeetCode0124 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(-1);
        root.right = new TreeNode(-3);
        LeetCode0124 lc = new LeetCode0124();
        System.out.println(lc.maxPathSum1(root));

    }

    private int max = 0;
    public int maxPathSum1(TreeNode root) {
        return height1(root);
    }

    private int height1(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = Math.max(height1(node.left), 0);
        int right = Math.max(height1(node.right), 0);

        max = Math.max(max, left+right+node.val);

        return Math.max(left, right) + node.val;
    }


    public int maxPathSum(TreeNode root) {
        AtomicInteger maxValue = new AtomicInteger(Integer.MIN_VALUE);
        maxPathSum(root, maxValue);
        return maxValue.get();
    }

    private int maxPathSum(TreeNode node, AtomicInteger maxValue) {
        if (node == null)
            return 0;
        int left = Math.max(0, maxPathSum(node.left, maxValue));
        int right = Math.max(0, maxPathSum(node.right, maxValue));
        // current node as the parent, compare with the existing maxValue
        maxValue.set(Math.max(maxValue.get(), left + right + node.val));
        // for the parent of current node, choose the max of current node's left or
        // right child
        return Math.max(left, right) + node.val;
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
