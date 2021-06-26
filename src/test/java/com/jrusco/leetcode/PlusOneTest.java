package com.jrusco;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

//https://leetcode.com/problems/plus-one/
public class PlusOneTest {

    @Test
    public void test(){
        assertArrayEquals(new int[]{1}, plusOne(new int[]{0}));
        assertArrayEquals(new int[]{9,1,0}, plusOne(new int[]{9,0,9}));
        assertArrayEquals(new int[]{1,0,0,0}, plusOne(new int[]{9,9,9}));
        assertArrayEquals(new int[]{4,3,2,2}, plusOne(new int[]{4,3,2,1}));
    }

    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9){
                digits[i]++;
                return digits;
            } else {
                digits[i] = 0;
            }
        }
        if (digits[0] == 0){
            digits = new int[digits.length + 1];
            digits[0]++;
        }
        return digits;
    }
}
