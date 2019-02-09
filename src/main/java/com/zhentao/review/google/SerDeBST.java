package com.zhentao.review.google;

/**
 * <b>449. Serialize and Deserialize BST</b>
 * 
 * <pre>
 * Serialization is the process of converting a data structure or object into a sequence 
 * of bits so that it can be stored in a file or memory buffer, or transmitted across a 
 * network connection link to be reconstructed later in the same or another computer environment.
 * 
 * Design an algorithm to serialize and deserialize a binary search tree. There is no restriction 
 * on how your serialization/deserialization algorithm should work. You just need to ensure that 
 * a binary search tree can be serialized to a string and this string can be deserialized to the 
 * original tree structure.
 * 
 * The encoded string should be as compact as possible.
 * 
 * Note: Do not use class member/global/static variables to store states. Your serialize and 
 * deserialize algorithms should be stateless.
 * </pre>
 * 
 * @author zhentao
 *
 */
public class SerDeBST {
    private static final String DELIMITER = ",";

    // Encodes a tree to a single string.
    public String serialize(final TreeNode root) {
        final StringBuilder builder = new StringBuilder();
        preOrder(root, builder);
        return builder.toString();
    }

    private void preOrder(final TreeNode node, final StringBuilder builder) {
        if (node == null) {
            return;
        }
        builder.append(node.val + DELIMITER);
        preOrder(node.left, builder);
        preOrder(node.right, builder);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(final String data) {
        if (data.equals("")) {
            return null;
        }
        final String[] array = data.split(DELIMITER);
        final int length = array.length;
        final TreeNode root = new TreeNode(Integer.valueOf(array[0]));
        for (int i = 1; i < length; i++) {
            final int val = Integer.valueOf(array[i]);
            deserialize(root, val);
        }
        
        return root;
    }
    
    private void deserialize(final TreeNode root , final int val) {
        TreeNode child = root;
        TreeNode parent = null;
        while(child != null) {
            parent = child;
            child = child.val > val ? child.left : child.right;
        }
        if (parent.val > val) {
            parent.left = new TreeNode(val);
        } else {
            parent.right = new TreeNode(val);
        }
    }
}
