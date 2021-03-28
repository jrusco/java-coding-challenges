package com.jrusco;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

//https://leetcode.com/problems/climbing-stairs/
public class ClimbingStairsTest {
    
    @Test
    public void test0(){
        assertEquals(3, climbStairs(3));
    }

    public int climbStairs(int n) {
        //size == n + 1 because the final answer will be at position waysToClimb[n]
        int[] waysToClimb = new int[n + 1];
        //there's 1 way to climb 0 steps: don't climb
        waysToClimb[0] = 1;
        //there's 1 way to climb 1 step: climb 1 step
        waysToClimb[1] = 1;
        //each of the following steps can be climbed in as many ways as the combination of the ways of climbing previous steps
        for (int i = 2; i <= n; i++) {
            waysToClimb[i] = waysToClimb[i -1] + waysToClimb[i -2];
        }
        return waysToClimb[n];
    }
}
