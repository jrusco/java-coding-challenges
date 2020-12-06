package com.jrusco;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

//https://leetcode.com/problems/palindrome-number/
public class PalindromeNumberTest {

    @Test
    public void test(){
        assertTrue(isPalindrome(3));
        assertTrue(isPalindrome(121));
        assertFalse(isPalindrome(-121));
        assertFalse(isPalindrome(90));
    }

    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        if (x < 10) return true;
        int original = x;
        int reversed = 0;
        while (x > 0){
            reversed = (reversed *= 10) + (x % 10);
            x = x / 10;
        }
        return original == reversed;
    }
}
