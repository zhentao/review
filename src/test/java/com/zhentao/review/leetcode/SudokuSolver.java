package com.zhentao.review.leetcode;

/**
 * <b>Sudoku</b>
 * 
 * <pre>
 * Write a program to solve a Sudoku puzzle by filling the empty cells.

A sudoku solution must satisfy all of the following rules:

Each of the digits 1-9 must occur exactly once in each row.
Each of the digits 1-9 must occur exactly once in each column.
Each of the the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
Empty cells are indicated by the character '.'.


Note:

The given board contain only digits 1-9 and the character '.'.
You may assume that the given Sudoku puzzle will have a single unique solution.
The given board size is always 9x9.
 * </pre>
 * 
 * @author zhentao
 *
 */
public class SudokuSolver {
    public static void main(final String[] args) {
        final char[][] board = {{'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}};
        solveSudoku(board);
    }
    public static void solveSudoku(final char[][] board) {
        solve(board);
    }

    private static boolean solve(final char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    for (char c = '1'; c <= '9'; c++) {
                        if (valid(board, i, j, c)) {
                            board[i][j] = c;
                            if (solve(board)) {
                                return true;
                            } else {
                                board[i][j] = '.';// rollback
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean valid(final char[][] board, final int row, final int col, final char c) {
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == c) {
                return false; // check row
            }
            if (board[row][i] == c) {
                return false; // check column
            }
            if (board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c) {
                return false; // check 3*3 block
            }
        }
        return true;
    }
}
