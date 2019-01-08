package com.zhentao.review.google;

import com.zhentao.review.cracking.BinaryNode;

/**
 * @see com.zhentao.review.cracking.BinaryNode#leaves()
 * @author zhentao
 *
 */
public class PrintLeaves {
    public static void main(String[] args) {
        BinaryNode<Integer> n0 = new BinaryNode<Integer>(0, null, null);
        BinaryNode<Integer> n1 = new BinaryNode<Integer>(1, n0, null);
        BinaryNode<Integer> n3 = new BinaryNode<Integer>(3, null, null);
        BinaryNode<Integer> n2 = new BinaryNode<Integer>(2, n1, n3);
        BinaryNode<Integer> n6 = new BinaryNode<Integer>(6, null, null);
        BinaryNode<Integer> n7 = new BinaryNode<Integer>(7, n6, null);
        BinaryNode<Integer> n5 = new BinaryNode<Integer>(5, null, n7);
        BinaryNode<Integer> n4 = new BinaryNode<Integer>(4, n2, n5);

        System.out.println(n4.height());
        System.out.println(n4.leaves());
        printLeaves(n4);
        System.out.println();
        
        n2 = new BinaryNode<Integer>(2, n1, null);
        n3 = new BinaryNode<Integer>(3, n2, null);
        n4 = new BinaryNode<Integer>(4, n3, null);
        System.out.println(n4.height());
        System.out.println(n4.leaves());
        printLeaves(n4);
        System.out.println();
    }
    public static <T> void printLeaves(BinaryNode<T> node) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            System.out.print(node.data + " ");
        } else {
            printLeaves(node.left);
            printLeaves(node.right);
        }
    }
}
