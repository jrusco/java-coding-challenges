package com.jrusco.leetcode;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

//https://www.youtube.com/watch?v=mjZpZ_wcYFg
public class RunLengthEncodingTest {
    @Test
    public void test0(){
        assertEquals("a4b3c2", encode("aaaabbbcc"));
        assertEquals("z1", encode("z"));
        assertEquals("y8", encode("yyyyyyyy"));
    }

    public String encode(String input){
        if (input == null || input.isEmpty()) return "";
        char[] inputChars = input.toCharArray();
        char current = inputChars[0];
        int count = 0;
        StringBuilder builder = new StringBuilder();
        for (char c : inputChars) {
            if (current == c){
                count++;
            } else {
                builder.append(current).append(count);
                current = c;
                count = 1;
            }
        }
        builder.append(current).append(count);
        return builder.toString();
    }
}
