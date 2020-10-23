package com.zhentao.review.facebook;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * <b>987. Vertical Order Traversal of a Binary Tree</b> Given a binary tree,
 * return the vertical order traversal of its nodes values.
 *
 * For each node at position (X, Y), its left and right children respectively
 * will be at positions (X-1, Y-1) and (X+1, Y-1).
 *
 * Running a vertical line from X = -infinity to X = +infinity, whenever the
 * vertical line touches some nodes, we report the values of the nodes in order
 * from top to bottom (decreasing Y coordinates).
 *
 * If two nodes have the same position, then the value of the node that is
 * reported first is the value that is smaller.
 *
 * Return an list of non-empty reports in order of X coordinate. Every report
 * will have a list of values of nodes.
 *
 *
 * <pre>
Example 1:

Input: [3,9,20,null,null,15,7]
Output: [[9],[3,15],[20],[7]]
Explanation:
Without loss of generality, we can assume the root node is at position (0, 0):
Then, the node with value 9 occurs at position (-1, -1);
The nodes with values 3 and 15 occur at positions (0, 0) and (0, -2);
The node with value 20 occurs at position (1, -1);
The node with value 7 occurs at position (2, -2).

Example 2:

Input: [1,2,3,4,5,6,7]
Output: [[4],[2],[1,5,6],[3],[7]]
Explanation:
The node with value 5 and the node with value 6 have the same position according to the given scheme.
However, in the report "[1,5,6]", the node value of 5 comes first since 5 is smaller than 6.

Note:

    The tree will have between 1 and 1000 nodes.
    Each node's value will be between 0 and 1000.
 *
 * </pre>
 *
 * @author zhentao.li
 *
 */
public class LeetCode0987 {
    public List<List<Integer>> verticalTraversal2(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        TreeMap<Integer, TreeSet<Node>> map = new TreeMap<>();
        preOrder2(root, map, 0, 0);
        for (Map.Entry<Integer, TreeSet<Node>> entry : map.entrySet()) {
            List<Integer> subList = new ArrayList<>();
            for (Node node : entry.getValue()) {
                subList.add(node.val);
            }
            list.add(subList);
        }
        return list;
    }

    private void preOrder2(TreeNode node, TreeMap<Integer, TreeSet<Node>> map, int x, int y) {
        if (node != null) {
            map.computeIfAbsent(x, k -> new TreeSet<>()).add(new Node(node.val, y));
            preOrder2(node.left, map, x - 1, y - 1);
            preOrder2(node.right, map, x + 1, y - 1);
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer, PriorityQueue<Node>> map = new TreeMap<>();
        preOrder(root, map, 0, 0);
        List<List<Integer>> list = new ArrayList<>(map.size());
        for (Map.Entry<Integer, PriorityQueue<Node>> entry : map.entrySet()) {
            ArrayList<Integer> subList = new ArrayList<>();
            list.add(subList);
            PriorityQueue<Node> queue = entry.getValue();
            while (!queue.isEmpty()) {
                subList.add(queue.poll().val);
            }
        }
        return list;
    }

    public int[][] verticalTraversalArray(TreeNode root) {
        TreeMap<Integer, PriorityQueue<Node>> map = new TreeMap<>();
        preOrder(root, map, 0, 0);
        int[][] array = new int[map.size()][];
        int row = 0;
        for (Map.Entry<Integer, PriorityQueue<Node>> entry : map.entrySet()) {
            PriorityQueue<Node> queue = entry.getValue();
            array[row] = new int[queue.size()];
            for (int i = 0; i < array[row].length; i++) {
                array[row][i] = queue.poll().val;
            }
            row++;
        }

        return array;
    }

    private void preOrder(TreeNode node, TreeMap<Integer, PriorityQueue<Node>> map, int x, int y) {
        if (node != null) {
            map.computeIfAbsent(x, k -> new PriorityQueue<>()).add(new Node(node.val, y));
            preOrder(node.left, map, x - 1, y - 1);
            preOrder(node.right, map, x + 1, y - 1);
        }
    }

    private static class Node implements Comparable<Node> {
        int val;

        int y;

        Node(int val, int y) {
            this.val = val;
            this.y = y;
        }

        @Override
        public int compareTo(Node o) {
            if (y == o.y) {
                return Integer.compare(val, o.val);
            }
            return -Integer.compare(y, o.y);
        }

    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }
}
