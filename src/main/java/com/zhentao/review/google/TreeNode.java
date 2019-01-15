package com.zhentao.review.google;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        return "val: " + val;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TreeNode)) {
            return false;
        }
        TreeNode that = (TreeNode) other;
        return this.val == that.val;
    }
    public static List<TreeNode> preorderWithStack(TreeNode root) {
        ArrayList<TreeNode> list = new ArrayList<>();

        if (root != null) {
            Stack<TreeNode> stack = new Stack<>();
            stack.add(root);
            while (!stack.empty()) {
                TreeNode node = stack.pop();
                list.add(node);

                TreeNode right = node.right;
                if (right != null) {
                    stack.add(right);
                }

                TreeNode left = node.left;
                if (left != null) {
                    stack.add(left);
                }
            }
        }
        return list;
    }
    
    public static List<Integer> inorder(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        inorder(root, list);
        return list;
    }
    private static void inorder(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        inorder(node.left, list);
        list.add(node.val);
        inorder(node.right, list);
        
    }
}