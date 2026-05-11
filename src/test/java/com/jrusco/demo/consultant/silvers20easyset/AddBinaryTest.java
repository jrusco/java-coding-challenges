package com.jrusco.demo.consultant.silvers20easyset;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * https://leetcode.com/problems/add-binary
 * 
 * == My Notes ==
 * - Radix = the base of a numeral system that defines how many unique digits
 * exist (binary=2, decimal=10, hex=16).
 */
public class AddBinaryTest {
    
    @Test
    public void test(){
        assertEquals("100", addBinary("11", "1"));
        assertEquals("10101", addBinary("1010", "1011"));
    }

    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        // start both pointers at the rightmost (least significant) digit
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;

        // continue until both strings are exhausted and no carry remains
        while (i >= 0 || j >= 0 || carry > 0) {
            int sum = carry;
            // add digit from a if still in bounds, then move pointer left
            if (i >= 0) sum += a.charAt(i--) - '0';
            // add digit from b if still in bounds, then move pointer left
            if (j >= 0) sum += b.charAt(j--) - '0';
            // current bit is sum mod 2 (0 or 1)
            sb.append(sum % 2);
            // carry is 1 if sum >= 2, otherwise 0
            carry = sum / 2;
        }

        // digits were appended least-significant first, so reverse before returning
        return sb.reverse().toString();
    }
}

