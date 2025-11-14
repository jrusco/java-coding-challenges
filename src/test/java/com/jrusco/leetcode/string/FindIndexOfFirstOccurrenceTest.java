package com.jrusco.leetcode.string;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

//https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string
public class FindIndexOfFirstOccurrenceTest {
    
    @Test
    public void test(){
        assertEquals(0, strStr("sadbutsad", "sad"));
    }

    public int strStr(String haystack, String needle) {
        if (needle == null || needle.isEmpty())
            return 0;
        if (haystack == null || haystack.isEmpty())
            return -1;

        char[] haystackArray = haystack.toCharArray();
        char[] needleArray = needle.toCharArray();

        for (int h = 0; h <= haystackArray.length - needle.length(); h++) {
            int n = 0;
            while (n < needle.length() && h + n < haystackArray.length && haystackArray[h + n] == needleArray[n]) {
                n++;
            }
            if (needleArray.length == n){
                return h;
            }
        }

        return -1;
    }

    
}
