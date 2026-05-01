package com.jrusco.demo.consultant;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * == The Game ==
 * - Same challenge as @Connect4ArrayTest
 * - doing it again for practice, no changes to the challenge whatsoever
 */
public class Connect4Array2ndTryTest {
    
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
        if (playerWins(board, 1)){
            return 1;
        } else if (playerWins(board, 2)){
            return 2;
        }
        return 0;
    }

    private int[][] initBoard(int[] moves) {
        int[][] board = new int[6][7];

        for (int i = 0; i < moves.length; i++) {
            int column = moves[i];
            int row = 0;
            int player = i % 2 == 0? 1 : 2;
            while(board[row][column] != 0){
                row++;
            }
            board[row][column] = player;
        }

        return board;
    }

    private boolean playerWins(int[][] board, int player) {

        for (int r = 0; r < 6; r++) {
            for (int c = 0; c < 7; c++) {
                /*
                 * rDir | cDir
                 * 0 | 1 horizontal
                 * 1 | 0 vertical
                 * 1 | 1 diagonal right
                 *-1 | 1 diagonal left
                 */
                if (checkWinCondition(board, player, r, c, 0, 1) ||
                    checkWinCondition(board, player, r, c, 1, 0) ||
                    checkWinCondition(board, player, r, c, 1, 1) ||
                    checkWinCondition(board, player, r, c, -1, 1)){
                        return true;
                }
            }
        }
        return false;
    }

    private boolean checkWinCondition(int[][] board, int player, int r, int c, int rDir, int cDir) {
        int tokensToWin = 4;

        for (int i = 0; i < tokensToWin; i++) {
            int currentRow = r + i * rDir;
            int currentCol = c + i * cDir;

            if ((currentRow < 0 || currentRow > 5) || (currentCol < 0 || currentCol > 6)){
                //out of bounds
                return false;
            }
            
            if (board[currentRow][currentCol] != player) {
                // not enough tokens of the current player to win
                return false;
            }
        }
        return true;
    }

}
