package com.zhentao.review.google;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Test;

public class ConstructBinaryTreeTest {
    @Test
    public void test() {

        int[] inorder = {9,3,15,20,7};
        int[] postorder = {9,15,7,20,3};

        assertThat(TreeNode.inorder(new ConstructBinaryTree().buildTree(inorder, postorder)), is(List.of(9,3,15,20,7)));


        inorder = new int[]{3,2,1};
        postorder = new int[]{3,2,1};

        assertThat(TreeNode.inorder(new ConstructBinaryTree().buildTree(inorder, postorder)), is(List.of(3,2,1)));

    }
 }
