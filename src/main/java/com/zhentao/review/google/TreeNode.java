package com.zhentao.review.google;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(final int x) {
        val = x;
    }

    @Override
    public String toString() {
        return "val: " + val;
    }

    @Override
    public boolean equals(final Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TreeNode)) {
            return false;
        }
        final TreeNode that = (TreeNode) other;
        return this.val == that.val;
    }

    public static List<TreeNode> preorderWithStack(final TreeNode root) {
        final ArrayList<TreeNode> list = new ArrayList<>();

        if (root != null) {
            final Stack<TreeNode> stack = new Stack<>();
            stack.add(root);
            while (!stack.empty()) {
                final TreeNode node = stack.pop();
                list.add(node);

                final TreeNode right = node.right;
                if (right != null) {
                    stack.add(right);
                }

                final TreeNode left = node.left;
                if (left != null) {
                    stack.add(left);
                }
            }
        }
        return list;
    }

    public static List<Integer> inorder(final TreeNode root) {
        final ArrayList<Integer> list = new ArrayList<>();
        inorder(root, list);
        return list;
    }

    private static void inorder(final TreeNode node, final List<Integer> list) {
        if (node == null) {
            return;
        }
        inorder(node.left, list);
        list.add(node.val);
        inorder(node.right, list);
    }

    public static List<Integer> inorderIterative(final TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        final ArrayList<Integer> list = new ArrayList<>();
        final Stack<TreeNode> stack = new Stack<>();
        TreeNode t = root;

        while (t != null || !stack.isEmpty()) {
            if (t != null) {
                stack.push(t);
                t = t.left;
            } else {
                t = stack.pop();
                list.add(t.val);
                t = t.right;
            }
        }
        return list;
    }

    public static List<TreeNode> postOrder(final TreeNode root) {
        final ArrayList<TreeNode> list = new ArrayList<>();
        if (root != null) {
            postOrder(root, list);
        }
        return list;
    }

    private static void postOrder(final TreeNode node, final ArrayList<TreeNode> list) {
        if (node.left != null) {
            postOrder(node.left, list);
        }
        if (node.right != null) {
            postOrder(node.right, list);
        }
        list.add(node);
    }
    
    /**
     * This code is not good since it modifies the tree
     * @param root
     * @return
     */
    public static List<TreeNode> postOrderStack(final TreeNode root) {
        final ArrayList<TreeNode> list = new ArrayList<>();
        if (root != null) {
            final Stack<TreeNode> stack = new Stack<>();
            final TreeNode temp = root;
            stack.push(temp);
            while(!stack.isEmpty()) {
               final TreeNode t = stack.peek();
               if (t.left == null && t.right == null) {
                   stack.pop();
                   list.add(t);
               } else {
                   if (t.right != null) {
                      stack.push(t.right);
                      t.right = null;
                   }
                   if (t.left != null) {
                       stack.push(t.left);
                       t.left = null;
                   }
               }
            }
        }
        return list;
    }
    
    public static List<TreeNode> postorderTraversal(final TreeNode root) {
        final LinkedList<TreeNode> stack = new LinkedList<>();
        final LinkedList<TreeNode> output = new LinkedList<>();
        if (root == null) {
          return output;
        }

        stack.add(root);
        while (!stack.isEmpty()) {
          final TreeNode node = stack.pollLast();
          output.addFirst(node);
          if (node.left != null) {
            stack.add(node.left);
          }
          if (node.right != null) {
            stack.add(node.right);
          }
        }
        return output;
      }
}