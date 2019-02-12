package com.zhentao.review.google.high;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Test;

import com.zhentao.review.google.high.DeleteRedNode.NaryTreeNode;

public class DeleteRedNodeTest {
    @Test
    public void test() {
        final NaryTreeNode n1 = new NaryTreeNode("blue");
        final NaryTreeNode n2 = new NaryTreeNode("blue");
        final NaryTreeNode n3 = new NaryTreeNode("red");
        final NaryTreeNode n4 = new NaryTreeNode("red");
        final NaryTreeNode n5 = new NaryTreeNode("red");
        final NaryTreeNode n6 = new NaryTreeNode("blue");
        final NaryTreeNode n7 = new NaryTreeNode("red");

        n1.children.add(n2);
        n1.children.add(n3);
        n1.children.add(n4);

        n2.children.add(n5);
        n3.children.add(n6);
        n4.children.add(n7);
        final DeleteRedNode delete = new DeleteRedNode();
        assertThat(delete.delete(n1), is(List.of(n1, n6)));
    }
}
