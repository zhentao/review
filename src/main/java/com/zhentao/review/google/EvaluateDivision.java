package com.zhentao.review.google;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * <b>399. Evaluate Division</b>
 * 
 * <pre>
 * Equations are given in the format A / B = k, where A and B are variables represented as strings, and k is a real number (floating point number). Given some queries, return the answers. If the answer does not exist, return -1.0.

Example:
Given a / b = 2.0, b / c = 3.0. 
queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ? . 
return [6.0, 0.5, -1.0, 1.0, -1.0 ].

The input is: vector<pair<string, string>> equations, vector<double>& values, vector<pair<string, string>> queries , where equations.size() == values.size(), and the values are positive. This represents the equations. Return vector<double>.

According to the example above:

equations = [ ["a", "b"], ["b", "c"] ],
values = [2.0, 3.0],
queries = [ ["a", "c"], ["b", "a"], ["a", "e"], ["a", "a"], ["x", "x"] ]. 
The input is always valid. You may assume that evaluating the queries will result in no division by zero and there is no contradiction.
 * </pre>
 * 
 * @author zhentao
 *
 */
public class EvaluateDivision {
    public static void main(String[] args) {
        String[][] equations = { { "a", "b" }, { "b", "c" } };
        double[] values = { 2.0, 3.0 };
        String[][] queries = { { "a", "c" }, { "b", "a" }, { "a", "e" }, { "a", "a" }, { "x", "x" } };
        double[] results = calcEquation(equations, values, queries);
        System.out.println(Arrays.toString(results));
    }

    public static double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        Graph graph = new Graph(equations, values);
        int length = queries.length;
        double[] results = new double[length];
        for (int i = 0; i < length; i++) {
            String numerator = queries[i][0];
            String denominator = queries[i][1];
            //make sure both numerator and denominator are in the graph
            if (graph.contains(numerator) && graph.contains(denominator)) {
                HashSet<String> visited = new HashSet<>();
                results[i] = dfs(graph.get(numerator), graph.get(denominator), visited, 1.0);
            } else {
                results[i] = -1.0;
            }
        }
        return results;
    }

    static double dfs(GraphNode numerator, GraphNode denominator, Set<String> visited, double accumulator) {

        if (numerator.equals(denominator)) {
            return accumulator;
        }
        visited.add(numerator.name);

        for (Map.Entry<GraphNode, Double> entry : numerator.edges.entrySet()) {
            GraphNode node = entry.getKey();
            if (!visited.contains(node.name)) {
                double result = dfs(node, denominator, visited, accumulator * entry.getValue());
                if (result != -1.0) {
                    return result;
                }
            }
        }

        return -1.0;
    }
}

class Graph {
    //store all nodes: map from name to Node
    Map<String, GraphNode> nodes;

    Graph(String[][] equations, double[] values) {
        nodes = new HashMap<>();
        for (int i = 0; i < equations.length; i++) {
            String parentName = equations[i][0];
            GraphNode parent = nodes.get(equations[i][0]);
            if (parent == null) {
                parent = new GraphNode(parentName);
                nodes.put(parentName, parent);
            }

            String childName = equations[i][1];
            GraphNode child = nodes.get(childName);
            if (child == null) {
                child = new GraphNode(childName);
                nodes.put(childName, child);
            }

            //Two-way links
            parent.addChild(child, values[i]);
            child.addChild(parent, 1 / values[i]);
        }
    }

    boolean contains(String name) {
        return nodes.containsKey(name);
    }

    GraphNode get(String name) {
        return nodes.get(name);
    }
}

class GraphNode {
    String name;
    Map<GraphNode, Double> edges;

    GraphNode(String name) {
        this.name = name;
        edges = new HashMap<>();
    }

    void addChild(GraphNode node, double value) {
        edges.put(node, value);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
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
        GraphNode other = (GraphNode) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Node [name=" + name + "]";
    }

}
