package com.jrusco.demo.silver.interview;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * == The Game ==
 * A classic Connect 4 game where two players take turns dropping colored discs
 * into a 7×6 grid. Discs fall to the lowest available row in the chosen column.
 * The first player to get 4 discs in a row (horizontally, vertically or
 * diagonally) wins. If the board fills up with no winner, the game is a draw.
 * 
 * The input is an array of movements where each value indicates in wich columns
 * the alternate players have dropped a disc in. E.g. an array like {3,4} means
 * player 1 droped a disc in column 3, then player 2 dropped a disc in column 4.
 */
public class Connect4ArrayOptimalSolutionTest {
    
    @Test
    public void test(){

        // coderbyte first test case
        assertEquals(1, connect4(new int[] { 3, 4, 3, 4, 3, 4, 3 }));

        // Draw
        assertEquals(0, connect4(new int[] {0,1,2,3,4,5,6}));

        // P1 wins: horizontal
        assertEquals(1, connect4(new int[] { 0, 0, 1, 1, 2, 2, 3}));

        // P2 wins: vertical
        assertEquals(2, connect4(new int[] { 0, 2, 1, 2, 0, 2, 3, 2}));

        // P2 wins: diag right
        assertEquals(2, connect4(new int[] {0,1,2,1,3,2,4,3,4,3,4,4}));

        // P1 wins: diag left
        assertEquals(1, connect4(new int[] {0,0,2,1,4,3,3,2,2,1,1,5,1}));
    }

    public int connect4(int[] moves) {
        int[][] board = new int[6][7];
        int[] heights = new int[7];

        for (int m = 0; m < moves.length; m++) {
            int col = moves[m];
            int row = heights[col]++;
            int player = m % 2 == 0 ? 1 : 2;
            board[row][col] = player;

            if (checkWin(board, player, row, col)) {
                return player;
            }
        }
        return 0;
    }

    private boolean checkWin(int[][] board, int player, int row, int col) {
        return countAxis(board, player, row, col, 0,  1) >= 4
            || countAxis(board, player, row, col, 1,  0) >= 4
            || countAxis(board, player, row, col, 1,  1) >= 4
            || countAxis(board, player, row, col, 1, -1) >= 4;
    }

    private int countAxis(int[][] board, int player, int row, int col, int dr, int dc) {
        return 1
            + countInDir(board, player, row, col,  dr,  dc)
            + countInDir(board, player, row, col, -dr, -dc);
    }

    private int countInDir(int[][] board, int player, int row, int col, int dr, int dc) {
        int count = 0;
        for (int i = 1; i <= 3; i++) {
            int r = row + i * dr;
            int c = col + i * dc;
            if (r < 0 || r >= 6 || c < 0 || c >= 7 || board[r][c] != player) break;
            count++;
        }
        return count;
    }

}
