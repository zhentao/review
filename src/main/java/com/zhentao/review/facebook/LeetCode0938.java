package com.zhentao.review.facebook;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * <b>938. Range Sum of BST</b>
 *
 * Given the root node of a binary search tree, return the sum of values of all
 * nodes with value between L and R (inclusive).
 *
 * The binary search tree is guaranteed to have unique values.
 *
 * <pre>
Example 1:

Input: root = [10,5,15,3,7,null,18], L = 7, R = 15
Output: 32

Example 2:

Input: root = [10,5,15,3,7,13,18,1,null,6], L = 6, R = 10
Output: 23



Note:

    The number of nodes in the tree is at most 10000.
    The final answer is guaranteed to be less than 2^31.
 *
 * </pre>
 *
 * @author zhentao.li
 *
 */
public class LeetCode0938 {
    public int rangeSumBST(TreeNode root, int L, int R) {
        AtomicInteger accumulator = new AtomicInteger();
        preOrder(root, L, R, accumulator);
        return accumulator.get();
    }

    private void preOrder(TreeNode node, int L, int R, AtomicInteger accumulator) {
        if (node != null) {
            if (node.val >= L && node.val <= R) {
                accumulator.addAndGet(node.val);
            }
            preOrder(node.left, L, R, accumulator);
            preOrder(node.right, L, R, accumulator);
        }
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }
}
