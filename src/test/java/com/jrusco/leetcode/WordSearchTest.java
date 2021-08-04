package com.jrusco.leetcode;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

//https://leetcode.com/problems/word-search/
public class WordSearchTest {
    
    @Test
    public void test(){
        assertFalse("Empty", exist(new char[][]{}, "A"));
        assertTrue("Existing", exist(new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}}, "ABCCED"));
        assertFalse("Non existing", exist(new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}}, "ABCB"));
        assertTrue("Existing", exist(new char[][]{
            {'A','B','C','E'},
            {'S','F','C','S'},
            {'A','D','E','E'}}, "SEE"));
    }

    public boolean exist(char[][] board, String word) {
        for (int col = 0; col < board.length; col++) {
            for (int row = 0; row < board[col].length; row++) {
                if(board[col][row] == word.charAt(0) && find(board, col, row, 0, word)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean find(char[][] board, int col, int row, int count, String word) {
        if (count == word.length()){
            return true;
        }

        if (col < 0 || col >= board.length || 
            row < 0 || row >= board[col].length || 
            board[col][row] != word.charAt(count)){
                return false;
        }

        char tmp = board[col][row];
        board[col][row] = ' ';
        boolean found = find(board, col + 1, row, count + 1, word) ||
                        find(board, col, row + 1, count + 1, word) ||
                        find(board, col - 1, row, count + 1, word) ||
                        find(board, col, row - 1, count + 1, word);
        board[col][row] = tmp;
        return found;
    }
}
