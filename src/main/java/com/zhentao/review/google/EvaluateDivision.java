package com.zhentao.review.google;

import java.util.HashMap;
import java.util.Map;

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
    /**
     * union find
     * 
     * @param equations
     * @param values
     * @param queries
     * @return
     */
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        HashMap<String, String> parents = new HashMap<>();
        // store the coefficient from a character to its parents
        // a/b=2.0, b/c=2.0 and c is the parent for a,b,and c.
        // The map is a=4 (2*2), b=2, c=1
        HashMap<String, Double> coefficient = new HashMap<>();

        int length = equations.length;
        for (int i = 0; i < length; i++) {
            String numerator = equations[i][0];
            String denominator = equations[i][1];
            double val = values[i];
            union(parents, coefficient, numerator, denominator, val);
        }

        double[] results = new double[queries.length];
        for (int i = 0; i < queries.length; i++) {
            String numerator = queries[i][0];
            String denominator = queries[i][1];
            if (parents.containsKey(numerator) && parents.containsKey(denominator)) {
                String p1 = find(numerator, parents, coefficient);
                String p2 = find(denominator, parents, coefficient);
                if (!p1.equals(p2)) {
                    results[i] = -1.0;
                } else {
                    results[i] = coefficient.get(numerator) / coefficient.get(denominator);
                }
            } else {
                results[i] = -1.0;
            }
        }

        return results;
    }

    private void union(HashMap<String, String> parents, HashMap<String, Double> coefficient, String numerator,
            String denominator, double val) {
        String numeratorP = find(numerator, parents, coefficient);
        String denominatorP = find(denominator, parents, coefficient);
        if (!numeratorP.equals(denominatorP)) {
            parents.put(numeratorP, denominatorP);
            coefficient.put(numeratorP, coefficient.get(denominator) * val / coefficient.get(numerator));
        }
    }

    /**
     * 
     * @param a
     * @param parents
     * @return the parent for a
     */
    private String find(String a, Map<String, String> parents, Map<String, Double> coefficient) {
        String p = parents.get(a);
        if (p == null) {
            parents.put(a, a);
            coefficient.put(a, 1.0);
            return a;
        }

        if (!p.equals(a)) {
            String ancestor = find(p, parents, coefficient);
            double coef = coefficient.get(a);
            coefficient.put(a, coef * coefficient.get(p));
            parents.put(a, ancestor);
            return ancestor;
        } else {
            return a;
        }
    }
}
