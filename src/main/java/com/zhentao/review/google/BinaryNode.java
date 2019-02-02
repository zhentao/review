package com.zhentao.review.google;

/**
 * 求一颗二叉树的中序遍历的第k个node. node的结构是{int cnt, Node left, Node right}.
 * cnt代表的这个node的所有children的个数
 * 
 * @author zhentao
 *
 */
public class BinaryNode {
    // The # of children
    int count;
    BinaryNode left;
    BinaryNode right;
    String name;

    public BinaryNode(final int count, final String name) {
        this.count = count;
        this.name = name;
    }

    public static BinaryNode findInOrder(final BinaryNode root, final int k) {
        if (root == null || k > root.count + 1 || k < 1) {
            return null;
        }
        if (root.left == null && k == 1) {
            return root;
        }
        if (root.left == null) {
            return findInOrder(root.right, k - 1);
        } else if (k > root.left.count + 2) {
            return findInOrder(root.right, k - (root.left.count + 2));
        } else if (k < root.left.count + 2) {
            return findInOrder(root.left, k);
        } else {
            return root;
        }
    }

    @Override
    public String toString() {
        return name;
    }
}
