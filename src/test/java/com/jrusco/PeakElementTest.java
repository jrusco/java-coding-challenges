package com.jrusco;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

//https://leetcode.com/problems/find-peak-element/
public class PeakElementTest {

    @Test
    public void test(){
        assertEquals(1, findPeakElement(new int[]{1,2,1,3,5,6,4}));
        assertEquals(0, findPeakElement(new int[]{1}));
        assertEquals(2, findPeakElement(new int[]{1,2,3,1}));
    }

    public int findPeakElement(int[] nums) {
        for(int i = 1; i <= nums.length - 1; i++ ){
            if (nums[i] > nums[i-1] && 
                    (i == nums.length - 1 || nums[i] > nums[i+1])){
                return i;
            }
        }
        return 0;
    }
}
