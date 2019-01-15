package com.zhentao.review.google;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;

import org.junit.Test;

public class ConstructBinaryTreeTest {
    @Test
    public void test() {
        
        int[] inorder = {9,3,15,20,7};
        int[] postorder = {9,15,7,20,3};
        
        assertThat(TreeNode.inorder(new ConstructBinaryTree().buildTree(inorder, postorder)), is(Arrays.asList(9,3,15,20,7)));
        
        
        inorder = new int[]{3,2,1};
        postorder = new int[]{3,2,1};
        
        assertThat(TreeNode.inorder(new ConstructBinaryTree().buildTree(inorder, postorder)), is(Arrays.asList(3,2,1)));
        
    }
 }
