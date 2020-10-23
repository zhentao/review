package com.zhentao.review.facebook;

/**
 * <b>130. Surrounded Regions</b><br/>
 * Given a 2D board containing 'X' and 'O' (the letter O), capture all regions
 * surrounded by 'X'.
 *
 * A region is captured by flipping all 'O's into 'X's in that surrounded
 * region.
 *
 * <pre>
Example:

X X X X
X O O X
X X O X
X O X X

After running your function, the board should be:

X X X X
X X X X
X X X X
X O X X
 * </pre>
 *
 * Explanation:
 *
 * Surrounded regions shouldn’t be on the border, which means that any 'O' on
 * the border of the board are not flipped to 'X'. Any 'O' that is not on the
 * border and it is not connected to an 'O' on the border will be flipped to
 * 'X'. Two cells are connected if they are adjacent cells connected
 * horizontally or vertically.
 *
 * @author zhentao.li
 *
 */
public class LeetCode0130 {
    public void solve(char[][] board) {
        if (board == null || board.length <= 2 || board[0].length <=2) {
            return;
        }

        int rows = board.length;
        int columns = board[0].length;

        boolean[][] visited = new boolean[rows][columns];
        for (int i = 0; i < rows; i++) {
            dfs(board, visited, i, 0);
            dfs(board, visited, i, columns-1);
        }
        for (int j = 1; j < columns-1; j++) {
            dfs(board, visited, 0, j);
            dfs(board, visited, rows-1, j);
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (board[i][j] == 'O' && !visited[i][j]) {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void dfs(char[][] board, boolean[][] visited, int x, int y) {
        if (onBoard(board.length, board[0].length, x, y) && !visited[x][y] && board[x][y] == 'O') {
            visited[x][y] = true;
            dfs(board, visited, x, y+1);
            dfs(board, visited, x, y-1);
            dfs(board, visited, x+1, y);
            dfs(board, visited, x-1, y);
        }
    }

    private boolean onBoard(int rows, int columns, int x, int y) {
        return x>=0 && x<rows && y >=0 && y < columns;
    }
}
