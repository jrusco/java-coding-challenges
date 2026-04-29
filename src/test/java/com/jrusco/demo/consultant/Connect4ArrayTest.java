package com.jrusco.demo.consultant;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * == The Game ==
 * Same challenge as @Connect4Test in a 7x6 board, but the input is an array of
 * movements where
 * each value indicates in wich columns the alternate players have
 * dropped a disc in. E.g. an array like {3,4} means player 1 droped a disc in
 * column 3, and then P2 dropped a disc in column 4.
 * 
 * == My notes ==
 * - Same resolution as in @Connect4Test but with an extra step: build the board
 *      from the array first.
 * - note the matrix dimentions are specified in the reverse order as the Java matrix should be inited. 
 *      In challenge: 7x6 (width x height), but in Java is 6x7 (row -height- x column -width-)
 */
public class Connect4ArrayTest {
    
    @Test
    public void test(){
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

    public int connect4(int[] moves){
        int[][] board = initBoard(moves);
        if (hasWon(board, 1)){
            return 1;
        } else if (hasWon(board, 2)){
            return 2;
        }
        return 0;
    }

    private int[][] initBoard(int[] moves){
        int[][] board = new int[6][7];
        for (int m = 0; m < moves.length; m++) {
            int r = 0;
            while (board[r][moves[m]] != 0) {
                r++;
            }
            int player = m % 2 == 0 ? 1 : 2;
            board[r][moves[m]] = player;
        }
        return board;
    }

    private boolean hasWon(int[][] board, int player) {
        //for each row...
        for (int row = 0; row < 6; row++) {
            //for each column...
            for (int col = 0; col < 7; col++) {
                if (checkDirection(board, player, row, col, 0, 1)){
                    //horizontal
                    return true;
                }
                if (checkDirection(board, player, row, col, 1, 0)){
                    //vertical
                    return true;
                }
                if (checkDirection(board, player, row, col, 1, 1)) {
                    // diagonally right
                    return true;
                }
                if (checkDirection(board, player, row, col, -1, 1)) {
                    // diagonally left
                    return true;
                }
            }
            
        }
        return false;
    }

    //rowDir: 1 (right) 0 (same) -1 (left)
    //colDir: 1 (up) 0 (same) -1 (down)
    private boolean checkDirection(int[][] board, int player, int row, int col, int rowDir, int colDir){

        //from a starting cell, check 4 cells in the given direction for the player discs
        for (int i = 0; i < 4; i++) {
            int r = row + i * rowDir;
            int c = col + i * colDir;
            
            if ((r < 0 || r > 5) || (c < 0 || c > 6)){
                // out of bounds
                return false;
            }

            if (board[r][c] != player){
                // disc in this cell is not the player's
                return false;
            }
        }

        return true;
    }
}
