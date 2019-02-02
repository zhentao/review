package com.zhentao.review.google.high;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import com.zhentao.review.google.TreeNode;

public class FlipEquivalentBinaryTreeTest {
    @Test
    public void test() {
        final FlipEquivalentBinaryTree flip = new FlipEquivalentBinaryTree();
        final TreeNode n1 = new TreeNode(1);
        final TreeNode n2 = new TreeNode(2);
        final TreeNode n3 = new TreeNode(3);
        final TreeNode n4 = new TreeNode(4);
        final TreeNode n5 = new TreeNode(5);
        final TreeNode n6 = new TreeNode(6);
        final TreeNode n7 = new TreeNode(7);
        final TreeNode n8 = new TreeNode(8);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n5.left = n7;
        n5.right = n8;
        
        final TreeNode m1 = new TreeNode(1);
        final TreeNode m2 = new TreeNode(2);
        final TreeNode m3 = new TreeNode(3);
        final TreeNode m4 = new TreeNode(4);
        final TreeNode m5 = new TreeNode(5);
        final TreeNode m6 = new TreeNode(6);
        final TreeNode m7 = new TreeNode(7);
        final TreeNode m8 = new TreeNode(8);
        m1.left = m2;
        m1.right = m3;
        m2.left = m4;
        m2.right = m5;
        m3.left = m6;
        m5.left = m7;
        m5.right = m8;
        
        assertThat(flip.flipEquiv(n1, m1), is(true));
    }
    @Test
    public void test2() {
        final FlipEquivalentBinaryTree flip = new FlipEquivalentBinaryTree();
        final TreeNode n1 = new TreeNode(1);
        final TreeNode n2 = new TreeNode(2);
        final TreeNode n3 = new TreeNode(3);
        final TreeNode n4 = new TreeNode(4);
        final TreeNode n5 = new TreeNode(5);
        final TreeNode n6 = new TreeNode(6);
        final TreeNode n7 = new TreeNode(7);
        final TreeNode n8 = new TreeNode(8);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n5.left = n7;
        n5.right = n8;
        
        final TreeNode m1 = new TreeNode(1);
        final TreeNode m2 = new TreeNode(2);
        final TreeNode m3 = new TreeNode(3);
        final TreeNode m4 = new TreeNode(4);
        final TreeNode m5 = new TreeNode(5);
        final TreeNode m6 = new TreeNode(6);
        final TreeNode m7 = new TreeNode(7);
        //final TreeNode m8 = new TreeNode(8);
        m1.left = m2;
        m1.right = m3;
        m2.left = m4;
        m2.right = m5;
        m3.left = m6;
        m5.left = m7;
        //m5.right = m8;
        
        assertThat(flip.flipEquiv(n1, m1), is(false));
    }
    
    @Test
    public void test3() {
        final TreeNode n1 = new TreeNode(1);
        final TreeNode n2 = n1;
        n2.left = new TreeNode(2);
        assertThat(n1, is(n2));
    }
}
