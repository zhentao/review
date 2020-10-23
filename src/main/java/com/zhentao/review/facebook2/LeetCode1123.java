package com.zhentao.review.facebook2;

/**
 * <b>1123. Lowest Common Ancestor of Deepest Leaves</b> Given a rooted binary
 * tree, return the lowest common ancestor of its deepest leaves.
 *
 * <pre>
Recall that:

    The node of a binary tree is a leaf if and only if it has no children
    The depth of the root of the tree is 0, and if the depth of a node is d, the depth of each of its children is d+1.
    The lowest common ancestor of a set S of nodes is the node A with the largest depth such that every node in S is in the subtree with root A.

Example 1:

Input: root = [1,2,3]
Output: [1,2,3]
Explanation:
The deepest leaves are the nodes with values 2 and 3.
The lowest common ancestor of these leaves is the node with value 1.
The answer returned is a TreeNode object (not an array) with serialization "[1,2,3]".

Example 2:

Input: root = [1,2,3,4]
Output: [4]

Example 3:

Input: root = [1,2,3,4,5]
Output: [2,4,5]

Constraints:

    The given tree will have between 1 and 1000 nodes.
    Each node of the tree will have a distinct value between 1 and 1000.
 * </pre>
 *
 * @author zhentao.li
 *
 */
public class LeetCode1123 {
    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        n1.right = n2;
        n1.left = n3;
        n3.left = n4;
        n3.right = n5;
        n4.right = n6;

        LeetCode1123 lc = new LeetCode1123();
        lc.lcaDeepestLeaves(n1);
    }

    public TreeNode lcaDeep(TreeNode root) {
        int[] nodeHeights = new int[1001];
        calcHeight(root, nodeHeights);
        return lcaDeep(root, nodeHeights);
    }

    private int calcHeight(TreeNode node, int[] nodeHeights) {
        if (node != null) {
            if (nodeHeights[node.val] == 0) {
                int h = 1 + Math.max(calcHeight(node.left, nodeHeights), calcHeight(node.right, nodeHeights));
                nodeHeights[node.val] = h;
            } else {
                return nodeHeights[node.val];
            }
        }
        return 0;
    }

    private TreeNode lcaDeep(TreeNode node, int[] nodeHeights) {
        if (node == null) {
            return null;
        }
        int rightHeight = nodeHeights[node.right.val];
        int leftHeight = nodeHeights[node.left.val];
        if (rightHeight == leftHeight) {
            return node;
        }

        return lcaDeep(leftHeight > rightHeight ? node.left : node.right, nodeHeights);
    }


    // since there are only 1000 nodes. A hashMap is a better solution for unlimited
    // number of nodes
    private int[] heightOfNode = new int[1001];

    public TreeNode lcaDeepestLeaves(TreeNode root) {
        if (root == null) {
            return null;
        }
        int rightHeight = height(root.right);
        int leftHeight = height(root.left);
        if (rightHeight == leftHeight) {
            return root;
        }

        return lcaDeepestLeaves(leftHeight > rightHeight ? root.left : root.right);
    }

    private int height(TreeNode node) {
        if (node != null) {
            if (heightOfNode[node.val] != 0) {
                return heightOfNode[node.val];
            }

            int h = 1 + Math.max(height(node.left), height(node.right));
            heightOfNode[node.val] = h;
            return h;
        } else {
            return 0;
        }
    }

    private static class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;

        TreeNode(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return String.valueOf(val);
        }
    }
}
