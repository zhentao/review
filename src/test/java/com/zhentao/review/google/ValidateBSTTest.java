package com.zhentao.review.google;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;
public class ValidateBSTTest {
//[10,5,15,null,null,6,20]
    @Test
    public void test() {
        final TreeNode root = new TreeNode(10);
        final TreeNode left = new TreeNode(5);
        final TreeNode right = new TreeNode(15);
        root.left = left;
        root.right = right;
        
        final TreeNode leftOfRight = new TreeNode(6);
        final TreeNode rightOfRight = new TreeNode(20);
        right.left= leftOfRight;
        right.right = rightOfRight;
        final ValidateBST validate = new ValidateBST();
        assertThat(validate.isValidBST(root), is(false));
        
    }
 }
