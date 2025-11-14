package com.jrusco.leetcode.string;

import static org.junit.Assert.assertEquals;


import org.junit.Test;

//https://leetcode.com/problems/find-the-difference/
public class FindTheDifferenceTest {
    
    @Test
    public void test(){
        assertEquals('q', findTheDifference("one", "onqe"));
    }

    public char findTheDifference(String s, String t) {
        int sumS = s.chars().sum();
        int sumT = t.chars().sum();
        return (char)(sumT - sumS);
    }

    
}
