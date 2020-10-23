package com.zhentao.review.facebook;

import java.util.Arrays;
import java.util.Iterator;

/**
 * <b>297. Serialize and Deserialize Binary Tree</b> Serialization is the
 * process of converting a data structure or object into a sequence of bits so
 * that it can be stored in a file or memory buffer, or transmitted across a
 * network connection link to be reconstructed later in the same or another
 * computer environment.
 *
 * Design an algorithm to serialize and deserialize a binary tree. There is no
 * restriction on how your serialization/deserialization algorithm should work.
 * You just need to ensure that a binary tree can be serialized to a string and
 * this string can be deserialized to the original tree structure.
 *
 * <pre>
Example:

You may serialize the following tree:

    1
   / \
  2   3
     / \
    4   5

as "[1,2,3,null,null,4,5]"
 * </pre>
 *
 * Clarification: The above format is the same as how LeetCode serializes a
 * binary tree. You do not necessarily need to follow this format, so please be
 * creative and come up with different approaches yourself.
 *
 * Note: Do not use class member/global/static variables to store states. Your
 * serialize and deserialize algorithms should be stateless.
 *
 * @author zhentao.li
 *
 */
public class LeetCode0297 {
    public static void main(String[] args) {
        LeetCode0297 lc = new LeetCode0297();

        String[] nodes = {"1","2","3","null","null","4","5"};
        TreeNode root = lc.deserialize(String.join(",", nodes));
        System.out.println(lc.serialize(root));
    }



    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder builder = new StringBuilder();
        preOrderSerialize(root, builder);
        return builder.toString();
    }

    private void preOrderSerialize(TreeNode node, StringBuilder builder) {
        if (node == null) {
            builder.append("null,");
            return;
        }
        builder.append(node.val).append(",");
        preOrderSerialize(node.left, builder);
        preOrderSerialize(node.right, builder);
    }
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Iterator<String> iter = Arrays.asList(data.split(",")).iterator();

        return preOrderDeserialize(iter);
    }

    private TreeNode preOrderDeserialize(Iterator<String> iter) {
        if (iter == null || !iter.hasNext()) {
            return null;
        }
        String value = iter.next();
        if (value.equals("null")) {
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(value));
        root.left = preOrderDeserialize(iter);
        root.right = preOrderDeserialize(iter);
        return root;
    }
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return String.valueOf(val);
        }
    }
}
