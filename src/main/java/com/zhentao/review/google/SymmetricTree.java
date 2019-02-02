package com.zhentao.review.google;

/**
 * <b>101. Symmetric Tree</b>
 * 
 * <pre>
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree [1,2,2,3,4,4,3] is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3
But the following [1,2,2,null,3,null,3] is not:
    1
   / \
  2   2
   \   \
   3    3
 * </pre>
 * 
 * @author zhentao
 *
 */
public class SymmetricTree {
    public boolean isSymmetric(final TreeNode root) {
        return isSymmetric(root, root);
    }
    
    boolean isSymmetric(final TreeNode left, final TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        return left.val == right.val && isSymmetric(left.left, right.right) 
                && isSymmetric(left.right, right.left);
    }
}
