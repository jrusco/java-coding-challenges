package com.jrusco.leetcode;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class SampleTest1 {
    
    @Test
    public void test(){
        assertTrue(methodUnderTest(1));
    }

    private boolean methodUnderTest(int input) {
        return input == 1;
    }

    
}
