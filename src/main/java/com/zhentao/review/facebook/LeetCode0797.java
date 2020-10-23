package com.zhentao.review.facebook;

import java.util.ArrayList;
import java.util.List;

/**
 * <b>797. All Paths From Source to Target</b> Given a directed acyclic graph of
 * N nodes. Find all possible paths from node 0 to node N-1, and return them in
 * any order.
 *
 * The graph is given as follows: the nodes are 0, 1, ..., graph.length - 1.
 * graph[i] is a list of all nodes j for which the edge (i, j) exists.
 *
 * <pre>
Example:
Input: [[1,2],[3],[3],[]]
Output: [[0,1,3],[0,2,3]]
Explanation: The graph looks like this:
0--->1
|    |
v    v
2--->3
There are two paths: 0 -> 1 -> 3 and 0 -> 2 -> 3.

Constraints:

    The number of nodes in the graph will be in the range [2, 15].
    You can print different paths in any order, but you should keep the order of nodes inside one path.
 * </pre>
 *
 * @author zhentao.li
 *
 */
public class LeetCode0797 {
    public static void main(String[] args) {
        LeetCode0797 lc = new LeetCode0797();
        System.out.println(lc.allPathsSourceTarget2(new int[][]{{1,2},{3},{3},{}}));
    }

    public List<List<Integer>> allPathsSourceTarget2(int[][] graph) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        path.add(0);
        all2(graph, list, path, 0);
        return list;
    }

    private void all2(int[][] graph, List<List<Integer>> list, List<Integer> path, int node) {
        if (node == graph.length-1) {
            list.add(new ArrayList<>(path));
        }

        for (int child : graph[node]) {
            path.add(child);
            all2(graph, list, path, child);
            path.remove((Integer)child);
        }
    }






    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        path.add(0);
        dfs(graph, 0, result, path);
        return result;
    }

    private void dfs(int[][] graph, int node, List<List<Integer>> result, List<Integer> path) {
        if (node == graph.length-1) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int next : graph[node]) {
            path.add(next);
            dfs(graph, next, result, path);
            //backtrack, remove just added the node `next`
            path.remove(path.size()-1);
        }
    }
}
