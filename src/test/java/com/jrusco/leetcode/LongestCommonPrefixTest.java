package com.jrusco.leetcode;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 * https://leetcode.com/problems/longest-common-prefix/
 * 
 * In this case, taking the first word of the <i>strs<i> array as reference for comparison is as good as any other.
 * In addition, I'm keeping track with <i>indexInString<i> of what position the char I'm comparing is at, in each word.
 * 
 * I.e. 
 * I first get the 1st letter (s) of the first word (indexInString == 0) and iterate over the rest of the words, comparing their first char.
 * Next, I get the 2nd letter (s) of the first word (indexInString == 1) and iterate over the rest of the words, comparing their second char.
 * And so on..
 * 
 * This continues until either:
 * - I run out of characters to comapare with in any of the words
 * - It turned out one of the characters dont match for any word in any given position 
 */
public class LongestCommonPrefixTest {
    
    @Test
    public void test(){
        assertEquals("fl", longestCommonPrefix(new String[]{"flower","flow","flight"}));
        assertEquals("", longestCommonPrefix(new String[]{"dog","racecar","car"}));
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0){
            return "";
        }

        String commonPrefix = "";

        int indexInString = 0;
        //for each letter of the first word in the "strs" array
        for(char s:strs[0].toCharArray()){
            //for each remaining word in the "strs" array
            for (int i = 1; i < strs.length; i++) {
                //if there are not enough letters in that other word,
                //or that other word has a different letter in the same position as the first word
                if (strs[i].length() -1 < indexInString || strs[i].charAt(indexInString) != s){
                    //return the common prefix gotten so far
                    return commonPrefix;
                }
            }
            //if not, it means it had matching a letter in matching position. So add it to the end result.
            commonPrefix += s;
            //increase the index to compare letters in the following position in each word.
            indexInString++;
        }

        return commonPrefix;

    }
}
