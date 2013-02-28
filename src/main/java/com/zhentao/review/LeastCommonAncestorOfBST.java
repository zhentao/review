package com.zhentao.review;

import java.util.LinkedList;
import java.util.Queue;

import com.zhentao.review.BinarySearchTree.BinaryNode;


public class LeastCommonAncestorOfBST {
    public static void main(String[] arguments) {
        BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();

        tree.add(5);
        tree.add(7);
        tree.add(9);
        tree.add(3);
        tree.add(1);
        tree.add(2);
        tree.add(4);
        tree.add(6);
        tree.add(8);
        tree.add(10);

//        System.out.println(lca(tree.root, 4, 6));
//        System.out.println(lca(tree.root, 4, 2));
//        System.out.println(lca(tree.root, 8, 6));
//        System.out.println(lca(tree.root, 7, 10));
        breadthFirst(tree.root);
        System.out.println();
        inOrder(tree.root);
        System.out.println();
        preOrder(tree.root);
        System.out.println();
        postOrder(tree.root);
    }

    public  static <T extends Comparable<T>> T lca(BinaryNode<T> root, T t1, T t2) {
        if (root == null || t1 == null || t2 == null) {
            return null;
        }
        T t = root.item;
        if (t.compareTo(t1) > 0 && t.compareTo(t2) > 0) {
            return lca(root.left, t1, t2);
        } else if (t.compareTo(t1) < 0 && t.compareTo(t2) < 0) {
            return lca(root.right, t1, t2);
        }
        return t;
    }

    public static <T extends Comparable<T>> void breadthFirst(BinaryNode<T> root) {
        if (root != null) {
            Queue<BinaryNode<T>> queue = new LinkedList<BinaryNode<T>>();
            queue.add(root);
            while (!queue.isEmpty()) {
                BinaryNode<T> node = queue.remove();
                System.out.print(node.item + " ");
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
    }

    public static <T extends Comparable<T>> void inOrder(BinaryNode<T> root) {
        if (root == null) return;
        System.out.print(root.item + " ");
        inOrder(root.left);
        inOrder(root.right);
    }

    public static <T extends Comparable<T>> void preOrder(BinaryNode<T> root) {
        if (root == null) return;
        preOrder(root.left);
        System.out.print(root.item + " ");
        preOrder(root.right);
    }

    public static <T extends Comparable<T>> void postOrder(BinaryNode<T> root) {
        if (root == null) return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.item + " ");
    }
}
