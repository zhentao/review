package com.zhentao.review.cracking;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PondSize {
    public static void main(String[] args) {
        int[][] input = { { 0, 2, 1, 0 }, { 0, 1, 0, 1 }, { 1, 1, 0, 1 }, { 0, 1, 0, 1 } };
        System.out.println(calculate(input));
    }

    public static List<Integer> calculate(int[][] input) {
        ArrayList<Point> a = new ArrayList<>();
        boolean[][] visited = new boolean[input.length][];
        for (int i = 0; i < input.length; i++) {
            visited[i] = new boolean[input[i].length];
        }
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[i].length; j++) {
                if (input[i][j] == 0) {
                    Point p  = new Point(i, j);
                    a.add(p);
                }
            }
        }

        List<Integer> results = new ArrayList<>();
        Iterator<Point> iter = a.iterator();
        while (iter.hasNext()) {
            Point p = iter.next();
            if (!visited[p.row][p.column]) {
                results.add(count(input, p, visited));
            } 
        }
        return results;
    }

    private static int count(int[][] input, Point point, boolean[][] visited) {
        int row = point.row;
        int column = point.column;
        if (row < 0 || row >= input.length || column < 0 || column >= input[row].length || input[row][column] != 0) {
            return 0;
        }
        visited[row][column] = true;
        return 1 + count(input, new Point(row, column + 1), visited) + count(input, new Point(row + 1, column - 1), visited)
                + count(input, new Point(row + 1, column), visited) + count(input, new Point(row + 1, column + 1), visited);
    }

    private static class Point {
        public final int row;
        public final int column;

        public Point(int row, int column) {
            this.row = row;
            this.column = column;
        }
        
        @Override
        public String toString() {
            return "row=" + row + " column=" + column; 
        }
        
//        @Override
//        public int hashCode() {
//            return Objects.hash(row, column);
//        }
//        
//        @Override
//        public boolean equals(Object other) {
//            if (!(other instanceof Point)) {
//                return false;
//            }
//            Point that = (Point) other;
//            return that.row == this.row && that.column == this.column;
//        }
    }
}
