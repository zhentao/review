package com.zhentao.review.test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class UsaCo {
    public static void main(String[] args) throws IOException {
        System.out.println("########################@@@@@@@@@@@@@@@@@@@@");
        System.out.println(process("/Users/zhentao.li/my-repos/review/src/main/java/com/zhentao/review/test/input.txt"));
    }

    public static int process(String fileName) throws IOException {
        DSU dsu = new DSU(101);
        Set<Integer> uniqueParents = new HashSet<>();
        int N = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line = reader.readLine();
            N = Integer.parseInt(line);
            while((line = reader.readLine()) != null) {
                String[] path = line.split(" ");
                dsu.union(Integer.parseInt(path[0]), Integer.parseInt(path[1]));
            }
        }
        for (int i = 1; i <= N; i++) {
            System.out.println(i + ": " + dsu.parent[i]);
        }
        int  root = dsu.find(1);
        uniqueParents.add(root);
        for (int i = 2; i <= N; i++) {
            if(uniqueParents.add(dsu.find(i)))
                return -1;
        }

        return root;
    }

    private static class DSU {
        int[] parent;

        public DSU(int N) {
            parent = new int[N];
            for (int i = 0; i < N; ++i) {
                parent[i] = i;
            }

        }

        public int find(int x) {
            while (parent[x] != x) {
                parent[x] = find(parent[x]);
                x = parent[x];
            }
            return parent[x];
        }

        public void union(int x, int y) {
            parent[find(x)] = find(y);
        }
    }
}
