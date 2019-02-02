package com.zhentao.review.google;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class BinaryNodeTest {
    @Test
    public void test() {
        final BinaryNode n1 = new BinaryNode(6, "a");
        final BinaryNode n2 = new BinaryNode(2, "b");
        final BinaryNode n3 = new BinaryNode(2, "c");
        final BinaryNode n4 = new BinaryNode(0, "d");
        final BinaryNode n5 = new BinaryNode(0, "e");
        final BinaryNode n6 = new BinaryNode(0, "f");
        final BinaryNode n7 = new BinaryNode(0, "g");
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;
        
        assertThat(BinaryNode.findInOrder(n1, 4), is(n1));
        assertThat(BinaryNode.findInOrder(n1, 3), is(n5));
        assertThat(BinaryNode.findInOrder(n1, 2), is(n2));
        assertThat(BinaryNode.findInOrder(n1, 1), is(n4));
        assertThat(BinaryNode.findInOrder(n1, 5), is(n6));
        assertThat(BinaryNode.findInOrder(n1, 6), is(n3));
        assertThat(BinaryNode.findInOrder(n1, 7), is(n7));
        
    }
    
    @Test
    public void test2() {
        final BinaryNode n1 = new BinaryNode(6, "a");
        final BinaryNode n2 = new BinaryNode(1, "b");
        final BinaryNode n3 = new BinaryNode(3, "c");
        final BinaryNode n4 = new BinaryNode(0, "d");
        final BinaryNode n5 = new BinaryNode(1, "e");
        final BinaryNode n6 = new BinaryNode(0, "f");
        final BinaryNode n7 = new BinaryNode(0, "g");
        n1.left = n2;
        n1.right = n3;
        n2.right = n4;
        n3.left = n5;
        n3.right = n6;
        n5.left = n7;
        
        assertThat(BinaryNode.findInOrder(n1, 1), is(n2));
        assertThat(BinaryNode.findInOrder(n1, 2), is(n4));
        assertThat(BinaryNode.findInOrder(n1, 3), is(n1));
        assertThat(BinaryNode.findInOrder(n1, 4), is(n7));
        assertThat(BinaryNode.findInOrder(n1, 5), is(n5));
        assertThat(BinaryNode.findInOrder(n1, 6), is(n3));
        assertThat(BinaryNode.findInOrder(n1, 7), is(n6));
        
    }
}
