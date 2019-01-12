package com.zhentao.review.leetcode;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;

import org.junit.Test;

public class SurroundedRegionsTest {

    @Test
    public void test() {
        SurroundedRegions surrounded = new SurroundedRegions();
        char[][] board = new char[4][4];
        for (char[] row : board) {
            Arrays.fill(row, 'X');
        }
        char[][] result = board.clone();
        
        board[1][1] = 'O';
        board[1][2] = 'O';
        board[2][1] = 'O';
        board[3][1] = 'O';
        
        //result[3][1] = 'O';
        surrounded.solve(board);
        assertThat(board, is(result));
    }
}
