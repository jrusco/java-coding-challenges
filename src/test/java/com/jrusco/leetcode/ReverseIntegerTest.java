package com.jrusco.leetcode;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

//https://leetcode.com/problems/reverse-integer/
public class ReverseIntegerTest {

    @Test
    public void test(){
        assertEquals(21, reverse(120));
        assertEquals(-321, reverse(-123));
        assertEquals(0, reverse(0));
    }

    public int reverse(int x) {
        boolean isNegative = x < 0;
        if (isNegative) x *= -1;
        long reversedX = 0;
        while (x > 0){
            reversedX = (reversedX *= 10) + (x % 10);
            x = x / 10;
        }
        if (isNegative) reversedX *= -1;
        return Math.abs(reversedX) > Integer.MAX_VALUE  ? 0 : (int) reversedX;
    }
}
