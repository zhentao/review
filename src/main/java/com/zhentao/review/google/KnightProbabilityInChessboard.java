package com.zhentao.review.google;

/**
 * <b>688. Knight Probability in Chessboard</b>
 * 
 * <pre>
 * On an NxN chessboard, a knight starts at the r-th row and c-th column and attempts to make 
 * exactly K moves. The rows and columns are 0 indexed, so the top-left square is (0, 0), and 
 * the bottom-right square is (N-1, N-1).

A chess knight has 8 possible moves it can make, as illustrated below. Each move is two squares 
in a cardinal direction, then one square in an orthogonal direction.

<img src="./doc-files/knight.png" />


Each time the knight is to move, it chooses one of eight possible moves uniformly at random 
(even if the piece would go off the chessboard) and moves there.

The knight continues moving until it has made exactly K moves or has moved off the chessboard. 
Return the probability that the knight remains on the board after it has stopped moving.


Example:

Input: 3, 2, 0, 0
Output: 0.0625
Explanation: There are two moves (to (1,2), (2,1)) that will keep the knight on the board.
From each of those positions, there are also two moves that will keep the knight on the board.
The total probability the knight stays on the board is 0.0625.
 * </pre>
 * 
 * @author zhentao
 *
 */
public class KnightProbabilityInChessboard {
    public double knightProbability(final int N, final int K, final int r, final int c) {
        double count = 1.0;
        for (int i = 0; i < K; i++) {
            count *= 8;
        }
        final double[][] visited = new double[N][N];
        final double valid = dfs(N, K, r, c, visited);
        return valid / count;
    }

    double dfs(final int n, final int k, final int r, final int c, final double[][] visited) {
        final double possibility = possibility(r, c, n);
        if (possibility == 0) {
            return 0;
        }
        if (k == 0) {
            return possibility;
        }
        if (visited[r][c] != 0) {
            return visited[r][c];
        }
        visited[r][c] = dfs(n, k - 1, r - 2, c - 1, visited) + dfs(n, k - 1, r - 2, c + 1, visited)
                + dfs(n, k - 1, r - 1, c - 2, visited) + dfs(n, k - 1, r - 1, c + 2, visited)
                + dfs(n, k - 1, r + 1, c - 2, visited) + dfs(n, k - 1, r + 1, c + 2, visited)
                + dfs(n, k - 1, r + 2, c - 1, visited) + dfs(n, k - 1, r + 2, c + 1, visited);
        return visited[r][c];
    }

    private double possibility(final int r, final int c, final int n) {
        if (r < 0 || r >= n || c < 0 || c >= n) {
            return 0;
        } else {
            return 1.0;
        }
    }
}
