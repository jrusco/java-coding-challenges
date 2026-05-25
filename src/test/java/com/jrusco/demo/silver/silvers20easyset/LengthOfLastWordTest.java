package com.jrusco.demo.silver.silvers20easyset;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * https://leetcode.com/problems/length-of-last-word
 * 
 * == My Notes ==
 * - Regex: \s means one space, tab, etc. \s+ means one or more.
 */
public class LengthOfLastWordTest {
    
    @Test
    public void test(){
        assertEquals(5, lengthOfLastWord("Hello World"));
        assertEquals(4, lengthOfLastWord("   fly me   to   the moon  "));
        assertEquals(6, lengthOfLastWord("luffy is still joyboy"));
    }

    public int lengthOfLastWord(String s) {
        String[] words = s.trim().split("\\s+");
        return words[words.length - 1].length();
    }

    
}
