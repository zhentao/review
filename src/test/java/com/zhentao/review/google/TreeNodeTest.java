package com.zhentao.review.google;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;

import org.junit.Test;

public class TreeNodeTest {
    @Test
    public void test() {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);
        
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n4.left = n5;
        n5.left = n6;
        n6.right = n7;
        Arrays.asList(n1,n2,n4,n5,n6,n2);
        assertThat(TreeNode.preorderWithStack(n1), is(Arrays.asList(n1,n2,n4,n5,n6,n7,n3)));
    }
}
