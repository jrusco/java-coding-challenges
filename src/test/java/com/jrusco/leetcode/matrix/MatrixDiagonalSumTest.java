package com.jrusco.leetcode.matrix;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Test;


/**
 * https://leetcode.com/problems/matrix-diagonal-sum/description/?envType=problem-list-v2&envId=matrix
 * 
 * == Challenge ==
 * You are given an m x n integer grid accounts where accounts[i][j] is the
 * amount of money the i​​​​​​​​​​​th​​​​ customer has in the j​​​​​​​​​​​th​​​​
 * bank. Return the wealth that the richest customer has.
 * 
 * A customer's wealth is the amount of money they have in all their bank
 * accounts. The richest customer is the customer that has the maximum wealth.
 * 
 * == My notes ==
 * - the antidiagnonal is a function of i, so i wouldnt need another pointer (j) 
 * to calculate its positions, but rather something like n-i-1
 * 
 */
public class MatrixDiagonalSumTest {

    @Test
    public void test(){
        int[][] mat = {{1,2,3},{4,5,6},{7,8,9}};
        assertEquals(25, diagonalSum(mat));
        
        int[][] mat2 = { { 1, 1, 1 , 1}, { 1, 1, 1, 1 }, { 1, 1, 1, 1 }, { 1, 1, 1, 1 }};
        assertEquals(8, diagonalSum(mat2));
    }

    public int diagonalSum(int[][] mat) {
        int sum = 0;
        for (int i = 0; i < mat.length; i++) {
            sum += mat[i][i];
            if (mat.length - i - 1 != i) {
                sum += mat[i][mat.length - i - 1];
            }
        }

        return sum;
    }

    
}
