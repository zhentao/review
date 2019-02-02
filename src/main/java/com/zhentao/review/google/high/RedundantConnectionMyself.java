package com.zhentao.review.google.high;

import com.zhentao.review.google.TreeNode;

/**
 * @see com.zhentao.review.google.high.RedundantConnection
 * 
 * @author zhentao
 *
 */
public class RedundantConnectionMyself {
    public int[] findRedundantConnection(final int[][] edges) {
        final int length = edges.length;
        final int[] parents = new int[length + 1];
        final int[] rank = new int[length + 1];
        for (int i = 1; i <= length; i++) {
            parents[i] = i;
        }

        for (final int[] edge : edges) {
            final int p = find(edge[0], parents);
            final int q = find(edge[1], parents);
            if (p != q) {
                if (rank[p] > rank[q]) {
                    parents[q] = p;
                } else if (rank[p] < rank[q]) {
                    parents[p] = q;
                } else {
                    parents[p] = q;
                    rank[q]++;
                }
            } else {
                return edge;
            }
        }
        throw new IllegalArgumentException("Invalid input. No circle found");
    }

    private int find(int a, final int[] parents) {
        while (parents[a] != a) {
            a = parents[a];
        }
        return a;
        // path compression
//        if (f != parent[f]) {
//            parent[f] = find(parent, parent[f]); //path compress 
//        }
//        return parent[f];
    }

    /**
     * <pre>
     * LC684，BT删除多余边
    思路：
    684是无向图，用union find，遍历edge，每次把parent付给做节点，若发现母节点相同则为多余
    685 三种错误情况，multiple parents，cycle， both 在both的情况下仔细讨论删除第一个指向multiple parent的node
    685 有很多隐含条件：比如 cycle 最多只可能有一个， multiple parents 最多两个，没有multiple parents  的话就一定有cycle, 这样就多了很多限制，分情况讨论的时候就会简单许多。
    3 invalid situations
    case1: 2 parents no circle
    case2: 2 parents with circle
    case3: 1 parent with circle
    2 main steps
    1 check whether there exists a node with 2 parents, if yes, store the two edges.
    2 if no edge yielded from step 1, apply union-find and find the edge creating cycle (same as 684); ELSE, apply union-find to ALL edges EXCEPT edges from step 1, then check: if edge 1 from step 1 creates a cycle, return edge 1; else return edge 2.
    //请问有的题是binary tree删多余边，这时候输入是 root 还是 edge list ?
    Follow up: 给一棵二叉搜索树，有一条多余边，删除它
    例子：
     7
    /  \
    5    9
    /  \   /  
    3    8
    对于多余边5-8，9-8此处的删除需要有选择，跟之前的题目找到多余边立马不分选择删除有区别
    
    思路:  LC 98: Validate Binary Search Tree
    DFS，参数中带着左右边界，返回值为新树的根节点，如果当前节点不在当前树的范围内，返回null删除该边
    
    参考代码
     * 
     * </pre>
     */
    public void deleteEdge(TreeNode root) {
        if(root == null) return;
        root = dfs(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    private TreeNode dfs(final TreeNode root, final int left, final int right) {
        if(root == null) return null;
        if(root.val <= left || root.val >= right) return null;
        root.left = dfs(root.left, left, root.val);
        root.right = dfs(root.right, root.val, right);
        return root;
    }

}
