package com.jrusco.leetcode;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

//https://leetcode.com/problems/missing-number/
public class MissingNumberTest {
    
    @Test
    public void test(){
        assertEquals(1, missingNumber(new int[]{0}));
        assertEquals(0, missingNumber(new int[]{1}));
        assertEquals(2, missingNumber(new int[]{0,1}));
        assertEquals(0, missingNumber(new int[]{2,1}));
        assertEquals(2, missingNumber(new int[]{3,0,1}));
        assertEquals(5, missingNumber(new int[]{1,3,2,0,4}));
    }

    public int missingNumber(int[] nums) {
        if (nums.length > 1){
            Arrays.sort(nums);
            if (nums[0] != 0){
                return 0;
            }
            for (int index = 0; index < nums.length; index++) {
                int nextInt = nums[index] + 1;
                int nextIndex = nums.length > index + 1 ? index + 1 : 0;
                if (nextInt != nums[nextIndex]){
                    return nextInt;
                }
            }
        }
        return nums[0] == 1 ? 0 : 1;
    }
}
