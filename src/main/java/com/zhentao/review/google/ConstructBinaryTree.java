package com.zhentao.review.google;

import java.util.HashMap;
import java.util.Map;

/**
 * <b>106. Construct Binary Tree from Inorder and Postorder Traversal</b>
 * 
 * <pre>
 * Given inorder and postorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.

For example, given

inorder = [9,3,15,20,7]
postorder = [9,15,7,20,3]
Return the following binary tree:

    3
   / \
  9  20
    /  \
   15   7
 * </pre>
 * 
 * @author zhentao
 *
 */
public class ConstructBinaryTree {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer, Integer> map = new HashMap<>();

        int length = inorder.length;
        for (int i = 0; i < length; i++) {
            map.put(inorder[i], i);
        }
        return construct(inorder, 0, length - 1, postorder, 0, postorder.length - 1, map);
    }

    private TreeNode construct(int[] inorder, int iStart, int iEnd, int[] postorder, int pStart, int pEnd,
            Map<Integer, Integer> map) {
        if (iStart > iEnd) {
            return null;
        }
        int value = postorder[pEnd];
        TreeNode root = new TreeNode(value);
        if (iStart != iEnd) {
            int index = findIndex(inorder, iStart, iEnd, value, map);
            root.left = construct(inorder, iStart, index - 1, postorder, pStart, pStart + (index - iStart) - 1, map);
            root.right = construct(inorder, index + 1, iEnd, postorder, pStart + (index - iStart), pEnd - 1, map);
        }
        return root;
    }

    private int findIndex(int[] inorder, int iStart, int iEnd, int target, Map<Integer, Integer> map) {
        int index =  map.get(target);
        if (index >= iStart && index <= iEnd) {
            return index;
        }
        throw new IllegalArgumentException("value " + target + " is not in inorder array");
    }
}
