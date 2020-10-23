package com.zhentao.review.facebook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 133. Clone Graph
Medium

Given a reference of a node in a connected undirected graph.

Return a deep copy (clone) of the graph.
 * @author zhentao.li
 *
 */
public class LeetCode0133 {
    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        n1.neighbors.add(n2);
        n1.neighbors.add(n4);
        n2.neighbors.add(n1);
        n2.neighbors.add(n3);
        n3.neighbors.add(n2);
        n3.neighbors.add(n4);
        n4.neighbors.add(n1);
        n4.neighbors.add(n3);

        Node newNode = new LeetCode0133().cloneGraph(n1);
        System.out.println(newNode);
    }

    public Node cloneGraph1(Node n) {
        if (n == null) {
            return null;
        }
        //map from old to new
        HashMap<Node, Node> map = new HashMap<>();
        return cloneGraphRec1(n, map);
    }

    private Node cloneGraphRec1(Node n, Map<Node, Node> map) {
        if (n == null) {
            return null;
        }
        if (map.containsKey(n)) {
            return map.get(n);
        }
        Node nn = new Node(n.val);
        map.put(n, nn);
        for (Node neibour : n.neighbors) {
            nn.neighbors.add(cloneGraphRec1(neibour, map));
        }
        return nn;
    }





    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        Map<Node, Node> map = new HashMap<>();
        return cloneDFS(node, map);
    }

    private Node cloneDFS(Node node, Map<Node, Node> map) {
        Node found = map.get(node);
        if (found != null) {
            return found;
        }
        Node newNode = new Node(node.val);
        map.put(node, newNode);

        for (Node neighbor : node.neighbors) {
            newNode.neighbors.add(cloneDFS(neighbor, map));
        }
        return newNode;
    }
    static class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }

        @Override
        public String toString() {
            return String.valueOf(val);
        }
    }
}
