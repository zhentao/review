package com.zhentao.review.google;

import java.util.Stack;

/**
 * <b>285. Inorder Successor in BST</b>
 * 
 * <pre>
 * Given a binary search tree and a node in it, find the in-order successor of that node in the BST.

Note: If the given node has no in-order successor in the tree, return null.
 * </pre>
 * 
 * @author zhentao
 *
 */
public class InorderSuccessorBST {
    public TreeNode inorderSuccessor(final TreeNode root, final TreeNode t) {
        if (root == null || t == null) {
            return null;
        }
         boolean visitedTarget = false;
        final Stack<TreeNode> stack = new Stack<>();
         TreeNode temp = root;
        while(temp != null || !stack.isEmpty()) {
            while(temp != null) {
                stack.push(temp);
                temp = temp.left;
            }
            temp = stack.pop();
            if (visitedTarget) {
                return temp;
            }
            if (temp == t) {
                visitedTarget = true;
            }
            temp = temp.right;
        }
        return null;
    }
}
