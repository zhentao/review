package com.zhentao.review.google;

import java.util.HashSet;

/**
 * <b>753. Cracking the Safe</b>
 * @author zhentao
 *
 */
public class CrackingSafe {
    public static void main(String[] args) {
        for (int i = 1; i <= 5; i++ ) {
            String ans = crackSafe(i, 2);
            System.out.println(ans + " " + ans.length());
        }
    }
    public static String crackSafe(int n, int k) {
        if (n == 1 && k == 1) return "0";
        HashSet<String> seen = new HashSet<>();
        StringBuilder ans = new StringBuilder();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n-1; ++i)
            sb.append("0");
        String start = sb.toString();

        dfs(start, k, seen, ans);
        ans.append(start);
        return new String(ans);
    }

    private static void dfs(String node, int k, HashSet<String> seen, StringBuilder ans) {
        for (int x = 0; x < k; ++x) {
            String nei = node + x;
            if (!seen.contains(nei)) {
                seen.add(nei);
                dfs(nei.substring(1), k, seen, ans);
                ans.append(x);
            }
        }
    }
}
