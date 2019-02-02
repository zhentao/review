package com.zhentao.review.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * <b>36. Valid Sudoku</b>
 * 
 * <pre>
 * Determine if a 9x9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:

Each row must contain the digits 1-9 without repetition.
Each column must contain the digits 1-9 without repetition.
Each of the 9 3x3 sub-boxes of the grid must contain the digits 1-9 without repetition.

A partially filled sudoku which is valid.

The Sudoku board could be partially filled, where empty cells are filled with the character '.'.

Example 1:

Input:
[
  ["5","3",".",".","7",".",".",".","."],
  ["6",".",".","1","9","5",".",".","."],
  [".","9","8",".",".",".",".","6","."],
  ["8",".",".",".","6",".",".",".","3"],
  ["4",".",".","8",".","3",".",".","1"],
  ["7",".",".",".","2",".",".",".","6"],
  [".","6",".",".",".",".","2","8","."],
  [".",".",".","4","1","9",".",".","5"],
  [".",".",".",".","8",".",".","7","9"]
]
Output: true
Example 2:

Input:
[
  ["8","3",".",".","7",".",".",".","."],
  ["6",".",".","1","9","5",".",".","."],
  [".","9","8",".",".",".",".","6","."],
  ["8",".",".",".","6",".",".",".","3"],
  ["4",".",".","8",".","3",".",".","1"],
  ["7",".",".",".","2",".",".",".","6"],
  [".","6",".",".",".",".","2","8","."],
  [".",".",".","4","1","9",".",".","5"],
  [".",".",".",".","8",".",".","7","9"]
]
Output: false
Explanation: Same as Example 1, except with the 5 in the top left corner being 
    modified to 8. Since there are two 8's in the top left 3x3 sub-box, it is invalid.
Note:

A Sudoku board (partially filled) could be valid but is not necessarily solvable.
Only the filled cells need to be validated according to the mentioned rules.
The given board contain only digits 1-9 and the character '.'.
The given board size is always 9x9.
 * </pre>
 * 
 * @author zhentao
 *
 */
public class ValidSudoku {
    
    public boolean isValidSudoku(final char[][] board) {
        final Set<Character> set = new HashSet<>();
        for (final char[] row : board) {
            for (final char ch : row) {
                if (!valid(set, ch)) {
                    return false;
                }
            }
            set.clear();
        }
        for (int column = 0; column < 9; column++) {
            for (int row = 0; row < 9; row++) {
                final char ch = board[row][column];
                if (!valid(set, ch)) {
                    return false;
                }
            }
            set.clear();
        }
        
        for (int row = 0; row < 9; row += 3) {
            for (int column = 0; column < 9; column += 3) {
                if (!checkSubBoard(row, column, board)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean checkSubBoard(final int rowStart, final int columnStart, final char[][] board) {
        final Set<Character> set = new HashSet<>();
        for (int row = rowStart; row < rowStart + 3; row++) {
            for (int column = columnStart; column < columnStart + 3; column++) {
                if (!valid(set, board[row][column])) {
                    return false;
                }
            }
        }
        return true;
    }
    private boolean valid(final Set<Character> set, final char ch) {
        if (set.contains(ch)) {
            return false;
        } else if (ch != '.') {
            set.add(ch);
        }
        return true;
    }
}
