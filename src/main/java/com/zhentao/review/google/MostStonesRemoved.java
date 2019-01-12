package com.zhentao.review.google;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * <b>947. Most Stones Removed with Same Row or Column</b>
 * 
 * <pre>
 * On a 2D plane, we place stones at some integer coordinate points.  Each coordinate point may have at most one stone.

Now, a move consists of removing a stone that shares a column or row with another stone on the grid.

What is the largest possible number of moves we can make?

 

Example 1:

Input: stones = [[0,0],[0,1],[1,0],[1,2],[2,1],[2,2]]
Output: 5
Example 2:

Input: stones = [[0,0],[0,2],[1,1],[2,0],[2,2]]
Output: 3
Example 3:

Input: stones = [[0,0]]
Output: 0
 

Note:

1 <= stones.length <= 1000
0 <= stones[i][j] < 10000
 * </pre>
 * 
 * @author zhentao
 *
 */
public class MostStonesRemoved {
    public static void main(String[] args) {
        int[][] array = { { 4, 5 }, { 0, 4 }, { 0, 5 }, { 4, 3 }, { 2, 2 }, { 5, 1 }, { 0, 3 }, { 2, 4 }, { 4, 0 } };
        System.out.println(removeStones(array));

        array = new int[][] { { 2, 1 }, { 0, 1 }, { 0, 0 }, { 2, 2 }, { 1, 0 }, { 1, 2 } };
        System.out.println(removeStones(array));

        array = new int[][] { { 0, 0 }, { 0, 2 }, { 1, 1 }, { 2, 0 }, { 2, 2 } };
        System.out.println(removeStones(array));

        array = new int[][] { { 0, 0 } };
        System.out.println(removeStones(array));

        array = new int[][] { { 0, 1 }, { 1, 0 }, { 1, 1 } };
        System.out.println(removeStones(array));
    }

    /**
     * 
     * @param stones
     * @return
     */
    public static int removeStones(int[][] stones) {

        HashSet<Component> componentSet = new HashSet<>();

        for (int[] stone : stones) {
            HashSet<Component> list = new HashSet<>();
            Node node = new Node(stone[0], stone[1]);
            for (Component component : componentSet) {

                if (component.containsRow(stone[0]) || component.containsCol(stone[1])) {
                    component.addNode(node);
                    list.add(component);
                }
            }

            if (list.isEmpty()) {// not found
                Component newComp = new Component(node);
                componentSet.add(newComp);
            }
            if (list.size() == 2) {// merge 2 components
                Iterator<Component> iter = list.iterator();
                Component first = iter.next();
                Component second = iter.next();
                first.merge(second);
                componentSet.remove(second);
            }
        }

        return stones.length - componentSet.size();
    }

    /**
     * This is solved by DFS.
     * 
     * @see com.zhentao.review.google.NumberOfIslands#NumberOfIslands()
     * @param stones
     * @return
     */
    public int removeStones2(int[][] stones) {
        Set<int[]> visited = new HashSet<>();
        int numOfIslands = 0;
        for (int[] s1 : stones) {
            if (!visited.contains(s1)) {
                dfs(s1, visited, stones);
                numOfIslands++;
            }
        }
        return stones.length - numOfIslands;
    }

    private void dfs(int[] s1, Set<int[]> visited, int[][] stones) {
        visited.add(s1);
        for (int[] s2 : stones) {
            if (!visited.contains(s2)) {
                if (s1[0] == s2[0] || s1[1] == s2[1])
                    dfs(s2, visited, stones);
            }
        }
    }
}

class Component {
    Set<Integer> rows = new HashSet<>();
    Set<Integer> cols = new HashSet<>();
    Set<Node> nodes = new HashSet<>();

    public Component(Node node) {
        addNode(node);
    }

    public void merge(Component other) {
        nodes.addAll(other.nodes);
        rows.addAll(other.rows);
        cols.addAll(other.cols);
    }

    public void addNode(Node node) {
        nodes.add(node);
        rows.add(node.x);
        cols.add(node.y);
    }

    public boolean containsRow(int row) {
        return rows.contains(row);
    }

    public boolean containsCol(int col) {
        return cols.contains(col);
    }

    public int size() {
        return nodes.size();
    }
}

class Node {
    final int x;
    final int y;

    Node(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + x;
        result = prime * result + y;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Node other = (Node) obj;
        if (x != other.x)
            return false;
        if (y != other.y)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Node [x=" + x + ", y=" + y + "]";
    }
}
