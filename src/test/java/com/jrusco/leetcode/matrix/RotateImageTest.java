package com.jrusco.leetcode.matrix;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

/**
 * https://leetcode.com/problems/rotate-image
 *
 * You are given an n x n 2D matrix representing an image, rotate the image by
 * 90 degrees (clockwise).
 *
 * You have to rotate the image in-place, which means you have to modify the
 * input 2D matrix directly. DO NOT allocate another 2D matrix and do the
 * rotation.
 *
 * == My Notes ==
 * -
 */
public class RotateImageTest {

    @Test
    public void test() {
        /**
         * Case 1
         * Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
         * Output: [[7,4,1],[8,5,2],[9,6,3]]
         */
        int[][] matrix1 = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        rotate(matrix1);
        assertArrayEquals(new int[][] { { 7, 4, 1 }, { 8, 5, 2 }, { 9, 6, 3 } }, matrix1);

        /**
         * Case 2
         * Input: matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
         * Output: [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
         */
        int[][] matrix2 = new int[][] { { 5, 1, 9, 11 }, { 2, 4, 8, 10 }, { 13, 3, 6, 7 }, { 15, 14, 12, 16 } };
        rotate(matrix2);
        assertArrayEquals(new int[][] { { 15, 13, 2, 5 }, { 14, 3, 4, 1 }, { 12, 6, 8, 9 }, { 16, 7, 10, 11 } }, matrix2);
    }

    public void rotate(int[][] matrix) {
        // flip cols for rows -> a counter-clockwise flip under the main diagonal
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < r; c++) {
                int aux = matrix[r][c];
                matrix[r][c] = matrix[c][r];
                matrix[c][r] = aux;
            }
        }
        //reverse each row -> correct the orientation to get the previous flip to the desired 90 degree rotation
        for (int r = 0; r < matrix.length; r++) {
            int left = 0;
            int right = matrix.length - 1;
            while (left < right) {
                int aux = matrix[r][left];
                matrix[r][left] = matrix[r][right];
                matrix[r][right] = aux;
                left++;
                right--;
            }
        }
    }

}
