package com.jrusco.leetcode.matrix;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;


/**
 * https://leetcode.com/problems/largest-local-values-in-a-matrix/description/?envType=problem-list-v2&envId=matrix
 * 
 * == Challenge ==
 * You are given an n x n integer matrix grid.
 * Generate an integer matrix maxLocal of size (n - 2) x (n - 2) such that:
 * maxLocal[i][j] is equal to the largest value of the 3 x 3 matrix in grid
 * centered around row i + 1 and column j + 1.
 * In other words, we want to find the largest value in every contiguous 3 x 3
 * matrix in grid.
 * Return the generated matrix.
 * 
 * == My Notes ==
 * 
 * - 
 */
public class LargestLocalValuesTest {

    @Test
    public void test(){
        int[][] grid = new int[][]{{ 9, 9, 8, 1}, { 5, 6, 2, 6}, { 8, 2, 6, 4}, { 6, 2, 2, 2}};
        assertArrayEquals(new int[][]{{9, 9}, {8, 6}}, largestLocal(grid));

        int[][] grid2 = new int[][] { {1,1,1,1,1},{1,1,1,1,1},{1,1,2,1,1},{1,1,1,1,1},{1,1,1,1,1}};
        assertArrayEquals(new int[][] { { 2,2,2}, { 2, 2, 2 }, { 2, 2, 2 } }, largestLocal(grid2));
    }

    public int[][] largestLocal(int[][] grid) {
        int n = grid.length;
        int[][] output = new int[n - 2][n - 2];

        for (int i = 0; i < n - 2; i++) {
            for (int j = 0; j <  n - 2; j++) {
                int largestValue = 0;
                for (int r = 0; r <= 2; r++) {
                    for (int c = 0; c <= 2; c++) {
                        largestValue = Math.max(largestValue, grid[i+r][j+c]);
                    }
                }
                output[i][j] = largestValue;
            }
        }

        return output;
    }

    
}
