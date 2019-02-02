package com.zhentao.review.google.high;

import java.util.ArrayDeque;
import java.util.Queue;

import com.zhentao.review.google.TreeNode;

/**
 * <b>951. Flip Equivalent Binary Trees</b>
 * 
 * <pre>
 * For a binary tree T, we can define a flip operation as follows: choose any node, and swap the left and right child subtrees.

A binary tree X is flip equivalent to a binary tree Y if and only if we can make X equal to Y after some number of flip operations.

Write a function that determines whether two binary trees are flip equivalent.  The trees are given by root nodes root1 and root2.

 

Example 1:

Input: root1 = [1,2,3,4,5,6,null,null,null,7,8], root2 = [1,3,2,null,6,4,5,null,null,null,null,8,7]
Output: true
Explanation: We flipped at nodes with values 1, 3, and 5.
Flipped Trees Diagram

<img src="./doc-files/tree_ex.png" />

Note:

Each tree will have at most 100 nodes.
Each value in each tree will be a unique integer in the range [0, 99].
 * </pre>
 * 
 * @author zhentao
 *
 */
public class FlipEquivalentBinaryTree {
    public boolean flipEquiv(final TreeNode root1, final TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null) {
            return false;
        }
        if (root2 == null) {
            return false;
        }
        final Queue<TreeNode> q1 = new ArrayDeque<>();
        final Queue<TreeNode> q2 = new ArrayDeque<>();
        q1.add(root1);
        q2.add(root2);
        while (!q1.isEmpty()) {
            final TreeNode n1 = q1.poll();
            if (q2.isEmpty()) {
                return false;
            }
            final TreeNode n2 = q2.poll();
            if (n1.val != n2.val) {
                return false;
            }
            if (equals(n1.left, n2.left)) {
                if (n1.left != null) {
                    q1.add(n1.left);
                    q2.add(n2.left);
                }
                if (!equals(n1.right, n2.right)) {
                    return false;
                } else if (n1.right != null) {
                    q1.add(n1.right);
                    q2.add(n2.right);
                }
            } else if (equals(n1.right, n2.left)){
                if (n1.right != null) {
                    q1.add(n1.right);
                    q2.add(n2.left);
                }
                if (!equals(n1.left, n2.right)) {
                    return false;
                } else if(n1.left != null) {
                    q1.add(n1.left);
                    q2.add(n2.right);
                }
            } else {
                return false;
            }
        }
        return q2.isEmpty();
    }

    private boolean equals(final TreeNode n1, final TreeNode n2) {
        if (n1 == n2) {
            return true;
        }
        if (n1 == null || n2 == null) {
            return false;
        }
        return n1.val == n2.val;
    }
    
    public boolean flipEquiv2(final TreeNode root1, final TreeNode root2) {
        if (root1 == root2)
            return true;
        if (root1 == null || root2 == null || root1.val != root2.val)
            return false;

        return (flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right) ||
                flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left));
    }
}
