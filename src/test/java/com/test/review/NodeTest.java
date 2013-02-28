package com.test.review;

import org.junit.Test;

public class NodeTest {
    @Test
    public void testReverse() {
        Node<String> n5 = new Node<String>("5", null);
        Node<String> n4 = new Node<String>("4", n5);
        Node<String> n3 = new Node<String>("3", n4);
        Node<String> n2 = new Node<String>("2", n3);
        Node<String> n1 = new Node<String>("1", n2);

        Node.reverse(n1);
        n5.print();
        System.out.println();
        Node.reverseRecursive(n5);
        n1.print();
        System.out.println();

        Node.reverseNode(n1);
        n5.print();
        System.out.println();

    }
}
