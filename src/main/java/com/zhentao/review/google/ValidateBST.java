package com.zhentao.review.google;

/**
 * <b>98. Validate Binary Search Tree</b>
 * 
 * <pre>
 * Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
Example 1:

Input:
    2
   / \
  1   3
Output: true
Example 2:

    5
   / \
  1   4
     / \
    3   6
Output: false
Explanation: The input is: [5,1,4,null,null,3,6]. The root node's value
             is 5 but its right child's value is 4.
 * </pre>
 * 
 * @author zhentao
 *
 */
public class ValidateBST {
    public boolean isValidBST(final TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.left != null && root.val <= findMaxInLeft(root.left)) {
            return false;
        }
        if (root.right != null && root.val >= findMinInRight(root.right)) {
            return false;
        }
        if (!isValidBST(root.left)) {
            return false;
        }
        if (!isValidBST(root.right)) {
            return false;
        }
        return true;
    }
    int findMaxInLeft(TreeNode node) {
        while(node.right != null) {
            node = node.right;
        }
        return node.val;
    }
    
    int findMinInRight(TreeNode node) {
        while(node.left != null) {
            node = node.left;
        }
        return node.val;
    }
}
