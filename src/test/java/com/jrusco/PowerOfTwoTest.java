package com.jrusco;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

//https://leetcode.com/problems/power-of-two/
public class PowerOfTwoTest {

    @Test
    public void test(){
        assertTrue(isPowerOfTwo(16));
        assertFalse(isPowerOfTwo(3));
    }

    public boolean isPowerOfTwo(int n) {
        if (n == 0) return false;
        if (n == 1) return true;
        long i = 1;
        while (i < n){
            i *= 2;
        }
        return i == n;
    }
}
