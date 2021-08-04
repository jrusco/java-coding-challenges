package com.jrusco.leetcode;

import static org.junit.Assert.assertArrayEquals;
import org.junit.Test;

//https://leetcode.com/problems/two-sum/
public class TwoSumTest {

    @Test
    public void test(){
        assertArrayEquals(new int[]{1,2}, twoSum(new int[]{2,5,5,11}, 10));
    }

    public int[] twoSum(int[] nums, int target) {
        if (nums.length == 2) return new int[]{0, 1};
        int i = 0;
        while(i <= nums.length - 2){
            int j = (i == 0) ? 1 : 0;
            while (j <= nums.length - 1){
                if (nums[i] + nums[j] == target){
                    return new int[]{i, j};
                }
                j = (j + 1 == i) ? j+2 : j+1;
            }
            i++;
        }
        return new int[]{nums.length - 2, nums.length - 1};
    }
}
