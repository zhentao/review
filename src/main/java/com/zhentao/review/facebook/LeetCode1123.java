package com.zhentao.review.facebook;

/**
 * <b>1123. Lowest Common Ancestor of Deepest Leaves</b> Given a rooted binary
 * tree, return the lowest common ancestor of its deepest leaves.
 *
 * <pre>
Recall that:

    The node of a binary tree is a leaf if and only if it has no children
    The depth of the root of the tree is 0, and if the depth of a node is d, the depth of each of its children is d+1.
    The lowest common ancestor of a set S of nodes is the node A with the largest depth such that every node in S is in the subtree with root A.

Example 1:

Input: root = [1,2,3]
Output: [1,2,3]
Explanation:
The deepest leaves are the nodes with values 2 and 3.
The lowest common ancestor of these leaves is the node with value 1.
The answer returned is a TreeNode object (not an array) with serialization "[1,2,3]".

Example 2:

Input: root = [1,2,3,4]
Output: [4]

Example 3:

Input: root = [1,2,3,4,5]
Output: [2,4,5]

Constraints:

    The given tree will have between 1 and 1000 nodes.
    Each node of the tree will have a distinct value between 1 and 1000.
 * </pre>
 *
 * @author zhentao.li
 *
 */
public class LeetCode1123 {
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        if (root == null ) {
            return null;
        }
        int rightHeight = height(root.right);
        int leftHeight = height(root.left);
        if (rightHeight == leftHeight) {
            return root;
        }

        return lcaDeepestLeaves(leftHeight > rightHeight ? root.left : root.right);
    }

    private int height(TreeNode node) {
        if (node != null) {
            return 1 + Math.max(height(node.left), height(node.right));
        } else {
            return 0;
        }
    }

    private static class TreeNode {
        TreeNode left;
        TreeNode right;
    }
}
