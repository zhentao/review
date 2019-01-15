package com.zhentao.review.google;

import java.util.Arrays;
import java.util.Iterator;

/**
 * <b>297. Serialize and Deserialize Binary Tree</b>
 * 
 * <pre>
 * Serialization is the process of converting a data structure or object into a sequence of bits so that 
 * it can be stored in a file or memory buffer, or transmitted across a network connection link to be 
 * reconstructed later in the same or another computer environment.

Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your 
serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be 
serialized to a string and this string can be deserialized to the original tree structure.

Example: 

You may serialize the following tree:

    1
   / \
  2   3
     / \
    4   5

as "[1,2,3,null,null,4,5]"
Clarification: The above format is the same as how LeetCode serializes a binary tree. You do not necessarily 
need to follow this format, so please be creative and come up with different approaches yourself.

Note: Do not use class member/global/static variables to store states. Your serialize and deserialize 
algorithms should be stateless.
 * </pre>
 * 
 * @author zhentao
 *
 */
public class SerDeBinaryTree {

    private static final String NULL = "null";
    private static final String DELIMITTER = ",";

// Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder builder = new StringBuilder();
        serialize(root, builder);
        return builder.toString();
    }

    private void serialize(TreeNode node, StringBuilder builder) {
        if (node == null) {
            builder.append(NULL).append(DELIMITTER);
        } else {
            builder.append(node.val).append(DELIMITTER);
            serialize(node.left, builder);
            serialize(node.right, builder);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        Iterator<String> iter = Arrays.asList(data.split(DELIMITTER)).iterator();
        return deserialize(iter);
    }

    private TreeNode deserialize(Iterator<String> iter) {
        if (iter.hasNext()) {
            String val = iter.next();
            if (val.equals(NULL)) {
                return null;
            }
            TreeNode root = new TreeNode(Integer.parseInt(val));
            root.left = deserialize(iter);
            root.right = deserialize(iter);
            return root;
        }
        return null;
    }
}
