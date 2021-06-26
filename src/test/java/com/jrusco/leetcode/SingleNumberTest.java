package com.jrusco.leetcode;

import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import org.junit.Test;

/**
 * https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/549/
 */
public class SingleNumberTest {
    
    @Test
    public void test0(){
        assertEquals(1, singleNumber(new int[]{1}));
        assertEquals(-1, singleNumber(new int[]{1,-1,1}));
        assertEquals(4, singleNumber(new int[]{4,1,2,1,2}));
    }

    private int singleNumber(int[] nums) {
        if (nums.length < 2){
            return nums[0];
        }
        Arrays.sort(nums);
        int i = 0;
        while (i < nums.length) {
            if (nums[i] != nums[nums.length > i + 1 ? i + 1 : 0]){
                return nums[i];
            } else {
                i = i + 2;
            }
        }
        return nums[0];
    }
}
