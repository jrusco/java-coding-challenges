package com.jrusco.demo.consultant;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * == The Game ==
 * Two players take turns dropping colored discs into a 7-column × 6-row
 * vertical grid. Discs fall to the lowest available row in the chosen column.
 * The first player to get 4 discs in a row (horizontally, vertically, or
 * diagonally) wins.
 * 
 * == My notes ==
 * - this is matrix-type challenge
 * - key here is to manage pointers and bounds correctly (avoid IOO exceptions)
 * - i divided the problem into `hasWon()` for directing the flows and
 * `checkDirection()` for the matrix crawling logic. This keeps it readable and adheres to DRY principle
 * - implementation started by solving the simplest paths first (horizontal, vertical) and built up from there (diagonal variations)
 * - using `int` for the "direction" variables keeps it simple, versatile and directly applicable to the logic (no enum or string mapping needed)
 */
public class Connect4Test {
    
    @Test
    public void test(){
        // Pending: only a few moves made, no winner
        assertEquals("Pending", connect4(new int[][] {
                { 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0 },
                { 1, 2, 1, 0, 0, 0, 0 }
        }));

        //horizontal P2 wins
        assertEquals("Player 2 wins", connect4(new int[][] {
                { 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0 },
                { 1, 1, 0, 0, 0, 0, 0 },
                { 1, 2, 1, 2, 2, 2, 2 }
        }));

        //diagonal P2 wins
        assertEquals("Player 2 wins", connect4(new int[][] {
         { 0, 0, 0, 0, 0, 0, 0 },
         { 0, 0, 0, 0, 0, 0, 0 },
         { 2, 0, 0, 0, 0, 0, 0 },
         { 1, 2, 0, 0, 0, 0, 0 },
         { 1, 1, 2, 0, 0, 0, 0 },
         { 1, 2, 1, 2, 0, 0, 0 }
         }));
         
         // diagonal P1 wins
        assertEquals("Player 1 wins", connect4(new int[][] {
                { 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 1, 0, 0, 0 },
                { 1, 2, 1, 0, 0, 0, 0 },
                { 1, 1, 2, 0, 0, 0, 0 },
                { 1, 2, 1, 2, 0, 0, 0 }
        }));
    }

    public String connect4(int[][] board){
        if (hasWon(board, 1)){
            return "Player 1 wins";
        } else if (hasWon(board, 2)){
            return "Player 2 wins";
        } // else: board may be full (no 0s) and that results in "Draw"
        return "Pending";
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
