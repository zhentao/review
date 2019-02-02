package com.zhentao.review.google;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;

import org.junit.Test;

public class TreeNodeTest {
    @Test
    public void testPreorder() {
        final TreeNode n1 = new TreeNode(1);
        final TreeNode n2 = new TreeNode(2);
        final TreeNode n3 = new TreeNode(3);
        final TreeNode n4 = new TreeNode(4);
        final TreeNode n5 = new TreeNode(5);
        final TreeNode n6 = new TreeNode(6);
        final TreeNode n7 = new TreeNode(7);

        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n4.left = n5;
        n5.left = n6;
        n6.right = n7;
        assertThat(TreeNode.preorderWithStack(n1), is(Arrays.asList(n1, n2, n4, n5, n6, n7, n3)));
    }

    @Test
    public void testInorder() {
        final TreeNode n1 = new TreeNode(1);
        final TreeNode n2 = new TreeNode(2);
        final TreeNode n3 = new TreeNode(3);
        final TreeNode n4 = new TreeNode(4);
        final TreeNode n5 = new TreeNode(5);
        final TreeNode n6 = new TreeNode(6);
        final TreeNode n7 = new TreeNode(7);

        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n4.left = n5;
        n5.left = n6;
        n6.right = n7;

        assertThat(TreeNode.inorder(n1), is(Arrays.asList(n6.val, n7.val, n5.val, n4.val, n2.val, n1.val, n3.val)));
        assertThat(TreeNode.inorderIterative(n1),
                is(Arrays.asList(n6.val, n7.val, n5.val, n4.val, n2.val, n1.val, n3.val)));
    }
    
    @Test
    public void testPostOrder() {
        final TreeNode n1 = new TreeNode(1);
        final TreeNode n2 = new TreeNode(2);
        final TreeNode n3 = new TreeNode(3);
        final TreeNode n4 = new TreeNode(4);
        final TreeNode n5 = new TreeNode(5);
        final TreeNode n6 = new TreeNode(6);
        final TreeNode n7 = new TreeNode(7);

        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n4.left = n5;
        n5.left = n6;
        n6.right = n7;
        assertThat(TreeNode.postOrder(n1), is(Arrays.asList(n7, n6, n5, n4, n2, n3, n1)));
        //assertThat(TreeNode.postOrderStack(n1), is(Arrays.asList(n7, n6, n5, n4, n2, n3, n1)));
        
        assertThat(TreeNode.postorderTraversal(n1), is(Arrays.asList(n7, n6, n5, n4, n2, n3, n1)));
    }
}
