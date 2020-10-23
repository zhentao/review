package com.zhentao.review.facebook;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * <b>236. Lowest Common Ancestor of a Binary Tree</b> Given a binary tree, find
 * the lowest common ancestor (LCA) of two given nodes in the tree.
 *
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor
 * is defined between two nodes p and q as the lowest node in T that has both p
 * and q as descendants (where we allow a node to be a descendant of itself).”
 *
 * Given the following binary tree: root = [3,5,1,6,2,0,8,null,null,7,4]
 *
 * <pre>
Example 1:

Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
Output: 3
Explanation: The LCA of nodes 5 and 1 is 3.

Example 2:

Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
Output: 5
Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.

Note:

    All of the nodes' values will be unique.
    p and q are different and both values will exist in the binary tree.
 * </pre>
 *
 * @author zhentao.li
 *
 */
public class LeetCode0236 {
    public TreeNode lca(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lca(root.left, p, q);
        TreeNode right = lca(root.right, p, q);
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }
        return root;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Map<Integer, TreeNode> parents = new HashMap<>();
        preOrder(root, null, parents);

        Set<TreeNode> pParents = new HashSet<>();

        TreeNode parent = p;
        while (parent != null) {
            pParents.add(parent);
            parent = parents.get(parent.val);
        }

        TreeNode qParent = q;
        while(!pParents.contains(qParent)) {
            qParent = parents.get(qParent.val);
        }
        return qParent;
    }

    private void preOrder(TreeNode node, TreeNode parent, Map<Integer, TreeNode> parents) {
        if (node != null) {
            parents.put(node.val, parent);
            preOrder(node.left, node, parents);
            preOrder(node.right, node, parents);
        }
    }

    public TreeNode lowestCommonAncestorRecursive(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }

        final TreeNode left = lowestCommonAncestorRecursive(root.left, p, q);
        final TreeNode right = lowestCommonAncestorRecursive(root.right, p, q);

        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }
        //p and q are in different sides
        return root;
    }
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }
}
