package com.zhentao.review.leetcode;

/**
 * <b>130. Surrounded Regions</b>
 * 
 * <pre>
 * Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.

A region is captured by flipping all 'O's into 'X's in that surrounded region.

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
Explanation:

Surrounded regions shouldn’t be on the border, which means that any 'O' on the border of the board 
are not flipped to 'X'. Any 'O' that is not on the border and it is not connected to an 'O' on the 
border will be flipped to 'X'. Two cells are connected if they are adjacent cells connected horizontally 
or vertically.
 * </pre>
 * 
 * @author zhentao
 *
 */
public class SurroundedRegions {
    public void solve(char[][] board) {
        int rows = board.length;
        if (rows <= 2) {
            return;
        }
        int columns = board[0].length;
        if (columns <= 2) {
            return;
        }
        boolean[][] visited = new boolean[rows][columns];
        for (int j = 0; j < columns; j++) {
            dfs(board, visited, 0, j);
            dfs(board, visited, rows - 1, j);
        }
        
        for (int i = 1; i < rows-1; i++) {
            dfs(board, visited, i, 0);
            dfs(board, visited, i, columns-1);
        }
        
        for (int i = 1; i < rows-1; i++) {
            for (int j = 1; j < columns-1; j++) {
                if (board[i][j] == 'O' && !visited[i][j]) {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void dfs(char[][] board, boolean[][] visited, int i, int j) {
        if (i >= 0 && i < board.length && j >= 0 && j < board[0].length && board[i][j] == 'O' && !visited[i][j]) {
            visited[i][j] = true;
            dfs(board, visited, i, j - 1);// left
            dfs(board, visited, i, j + 1);// right;
            dfs(board, visited, i - 1, j);// above;
            dfs(board, visited, i + 1, j);// below
        }
    }
}
