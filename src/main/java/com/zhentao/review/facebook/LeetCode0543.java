package com.zhentao.review.facebook;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * <b>543. Diameter of Binary Tree</b> Given a binary tree, you need to compute
 * the length of the diameter of the tree. The diameter of a binary tree is the
 * length of the longest path between any two nodes in a tree. This path may or
 * may not pass through the root.
 *
 * <pre>
Example:
Given a binary tree

          1
         / \
        2   3
       / \
      4   5

Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].
 * </pre>
 *
 * Note: The length of path between two nodes is represented by the number of
 * edges between them.
 *
 * @author zhentao.li
 *
 */
public class LeetCode0543 {
    private int maxDiameter = 0;
    public int diameterOfBinaryTree2(TreeNode root) {
        h2(root);
        return maxDiameter;
    }

    private int h2(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = h2(node.left);
        int right = h2(node.right);
        maxDiameter = Math.max(maxDiameter, left + right);
        return Math.max(left, right) + 1;
    }





    public int diameterOfBinaryTree(TreeNode root) {
        AtomicInteger count = new AtomicInteger();
        height(root, count);
        return count.get();
    }

    int height(TreeNode node, AtomicInteger count) {
        if (node == null) {
            return 0;
        }
        int left = height(node.left, count);
        int right = height(node.right, count);
        //it is the number of edges, so we don't add 1 below (like left+right+1).
        count.set(Math.max(count.get(), left + right));
        return Math.max(left, right) + 1; //add the root path
    }

    private static class TreeNode {
        TreeNode left;
        TreeNode right;
    }
}
