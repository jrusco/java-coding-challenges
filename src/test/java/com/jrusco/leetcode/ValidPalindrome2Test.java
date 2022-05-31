package com.jrusco.leetcode;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * https://leetcode.com/problems/valid-palindrome-ii/submissions/
 * 
 * The key is to use pointers to iterate over each char of the String from the begining and from the end, and
 * comparing them for mismatches.
 * As the challenge is about finding the one char I could remove, if possible, to make the remaining string a
 * palindrome, if the first loop finds a mismatch between chars, then <i>checkPalindrome()<i> continues checking the 
 * remainder of the String, removing one of char from the first half of the string and the from the second half.
 */
public class ValidPalindrome2Test {
    
    @Test
    public void test(){
        assertTrue(validPalindrome("aba"));
        assertFalse(validPalindrome("dog"));
        assertTrue(validPalindrome("yd"));
        assertTrue(validPalindrome("abca"));
        assertTrue(validPalindrome("cbbcc"));
    }

    public boolean validPalindrome(String s) {
        if (s.length() < 2){
            return false;
        }

        int i = 0;
        int j = s.length() -1;
        while(i<j){
            if (s.charAt(i) != s.charAt(j)){
                return checkPalindrome(s, i + 1, j) || checkPalindrome(s, i, j - 1);
            }
            i++;
            j--;
        }
        return true;
    }

    private boolean checkPalindrome(String s, int i, int j) {
        if (i > j){
            return false;
        }
        while(i<j){
            if (s.charAt(i++) != s.charAt(j--)){
                return false;
            }
        }
        return true;
    }
}
