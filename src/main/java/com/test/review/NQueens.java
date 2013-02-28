package com.test.review;

public class NQueens {

    private int total;

    private boolean unsafe(int y, int[] b) {
        for (int i = 1; i <= y; i++) {
            int t = b[y - i];
            if (t == b[y] || t == b[y] - i || t == b[y] + i) {
                return true;
            }
        }

        return false;
    }

    private void putboard(int numOfQueens, int[] b) {
        System.out.println("\n\nSolution " + (++total));
        for (int y = 0; y < numOfQueens; y++) {
            for (int x = 0; x < numOfQueens; x++) {
                System.out.print((b[y] == x) ? "|Q" : "|_");
            }
            System.out.println("|");
        }
    }

    public static void main(String[] args) {
        NQueens q = new NQueens();
        q.solve(8);
        //q.solve(8);
    }

    public void solve(int numOfQueens) {
        total = 0;
        int[] b = new int[numOfQueens];

        int y = 0;
        b[0] = -1;
        while (y >= 0) {
            do {
                b[y]++;
            } while ((b[y] < numOfQueens) && unsafe(y, b));

            if (b[y] < numOfQueens) {
                if (y < numOfQueens - 1) {
                    b[++y] = -1;
                } else {
                    putboard(numOfQueens, b);
                }
            } else {
                y--;
            }
        }
    }
}
