package com.zhentao.review.google;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * <b>742. Closest Leaf in a Binary Tree</b>
 * 
 * <pre>
 * Given a binary tree where every node has a unique value, and a target key k, find the value of the nearest leaf node to target k in the tree.

Here, nearest to a leaf means the least number of edges traveled on the binary tree to reach any leaf of the tree. Also, a node is called a leaf if it has no children.

In the following examples, the input tree is represented in flattened form row by row. The actual root tree given will be a TreeNode object.

Example 1:

Input:
root = [1, 3, 2], k = 1
Diagram of binary tree:
          1
         / \
        3   2

Output: 2 (or 3)

Explanation: Either 2 or 3 is the nearest leaf node to the target of 1.
 

Example 2:

Input:
root = [1], k = 1
Output: 1

Explanation: The nearest leaf node is the root node itself.
 

Example 3:

Input:
root = [1,2,3,4,null,null,null,5,null,6], k = 2
Diagram of binary tree:
             1
            / \
           2   3
          /
         4
        /
       5
      /
     6

Output: 3
Explanation: The leaf node with value 3 (and not the leaf node with value 6) is nearest to the node with value 2.
 

Note:

root represents a binary tree with at least 1 node and at most 1000 nodes.
Every node has a unique node.val in range [1, 1000].
There exists some node in the given binary tree for which node.val == k.
 * </pre>
 * 
 * @author zhentao
 *
 */
public class ClosestLeafBinaryTree {
    public static void main(final String[] args) {
        final TreeNode n1 = new TreeNode(1);
        final TreeNode n2 = new TreeNode(2);
        final TreeNode n3 = new TreeNode(3);
        final TreeNode n4 = new TreeNode(4);
        final TreeNode n5 = new TreeNode(5);
        final TreeNode n6 = new TreeNode(6);
        
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n4.left = n5;
        n5.left = n6;
        
        System.out.println(new ClosestLeafBinaryTree().findClosestLeaf(n1, 2));
        System.out.println(new ClosestLeafBinaryTree().findClosestLeaf(n6, 6));
        
        n2.left = null;
        System.out.println(new ClosestLeafBinaryTree().findClosestLeaf(n1, 1));
    }
    
    public int findClosestLeaf(final TreeNode root, final int k) {
        final HashMap<TreeNode, TreeNode> parentMap = new HashMap<>();
        final TreeNode nodeK = find(root, parentMap, k);
        return closestLeaf(nodeK, parentMap);
    }
    
    /**
     * DFS
     * @param node
     * @param parentMap
     * @param k
     * @return
     */
    private TreeNode find(final TreeNode node, final Map<TreeNode, TreeNode> parentMap, final int k) {
        if (node.val == k) {
            return node;
        }
        if (node.left != null) {
            parentMap.put(node.left, node);
            final TreeNode nodeK = find(node.left, parentMap, k);
            if (nodeK != null) {
                return nodeK;
            }
        }
        if (node.right != null) {
            parentMap.put(node.right, node);
            final TreeNode nodeK = find(node.right, parentMap, k);
            if (nodeK != null) {
                return nodeK;
            }
        }
        
        throw new IllegalArgumentException("int k=" + k + " is not found in the tree");
    }
    
    /**
     * BFS
     * @param node
     * @param parentMap
     * @return
     */
    private int closestLeaf(final TreeNode node, final Map<TreeNode, TreeNode> parentMap) {
        final Queue<TreeNode> queue = new LinkedList<>();
        final HashSet<TreeNode> visited = new HashSet<>();
        queue.add(node);
        
        
        while(!queue.isEmpty()) {
            final TreeNode temp = queue.poll();
            if (!visited.contains(temp)) {
                if (temp.left == null && temp.right == null) {
                    return temp.val;
                } else {
                    visited.add(temp);
                    if (temp.left != null) {
                        queue.add(temp.left);
                    }
                    if (temp.right != null) {
                        queue.add(temp.right);
                    }
                    final TreeNode parent = parentMap.get(temp);
                    if (parent != null) {
                        queue.add(parent);
                    }
                }
            }
        }
        return 0;
    }

}

