package com.jrusco.leetcode;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

//https://leetcode.com/problems/split-a-string-in-balanced-strings/
public class BalancedStringsTest {
    
    @Test
    public void test0(){
        assertEquals(4, balancedStringSplit("RLRRLLRLRL"));
        assertEquals(3, balancedStringSplit("RLLLLRRRLR"));
        assertEquals(1, balancedStringSplit("LLLLRRRR"));
    }

    public int balancedStringSplit(String s) {
        int balancedStrings = 0;
        int count = 0;
        for (char c : s.toCharArray()) {
            count = c == 'R'? count + 1 : count - 1;
            if (count == 0){
                balancedStrings++;
            }
        }
        return balancedStrings;
    }
}
