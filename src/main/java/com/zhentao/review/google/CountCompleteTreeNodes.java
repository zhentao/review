package com.zhentao.review.google;

/**
 * <b>222. Count Complete Tree Nodes</b>
 * 
 * <pre>
 * Given a complete binary tree, count the number of nodes.

Note:

Definition of a complete binary tree from Wikipedia:
In a complete binary tree every level, except possibly the last, is completely filled, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.

Example:

Input: 
    1
   / \
  2   3
 / \  /
4  5 6

Output: 6
 * </pre>
 * 
 * @author zhentao
 *
 */
public class CountCompleteTreeNodes {
    public int countNodes(final TreeNode root) {
        final int height = height(root);
        if (height == -1) {
            return 0;
        } else if (height == 0) {
            return 1;
        }
        final int rightHeight = height(root.right);
        if (rightHeight == height - 1) {// the left tree is a complete tree with height as (height-1). The # of nodes in
                                        // left tree is 2^height - 1. Plus root, the total # is 2^height which is 1 <<
                                        // height.
            return (1 << height) + countNodes(root.right);
        } else {// The right tree is a complete tree with height as (height - 2). The # of nodes
                // in right tree is 2^(height-1) - 1. Plus root, it is 2^(height-1) which is 2 <<(height-1)

            return (1 << (height - 1)) + countNodes(root.left);
        }
    }

    private int height(TreeNode root) {
        int height = -1;
        while (root != null) {
            height++;
            root = root.left;
        }
        return height;
    }
}
