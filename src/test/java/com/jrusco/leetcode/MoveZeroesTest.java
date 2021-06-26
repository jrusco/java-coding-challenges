package com.jrusco.leetcode;

import static org.junit.Assert.assertArrayEquals;
import org.junit.Test;


//https://leetcode.com/problems/move-zeroes/
public class MoveZeroesTest {

    @Test
    public void test(){
        assertArrayEquals(moveZeroes(new int[]{0,1,0,3,12}), new int[]{1,3,12,0,0});
        assertArrayEquals(moveZeroes(new int[]{0,0,0,1}), new int[]{1,0,0,0});
        assertArrayEquals(moveZeroes(new int[]{1}), new int[]{1});
        assertArrayEquals(moveZeroes(new int[]{3,0}), new int[]{3,0});
    }

    public int[] moveZeroes(int[] nums) {
        if (nums.length <= 1) return nums;
        for (int i = 0; i < nums.length - 1; i++) {
            int j = i;
            if (nums[i] == 0){
                while (nums[j] == 0 && j < nums.length - 1){
                    j++;
                }
                for (int k = j - 1; k >= i; k--){
                    nums[k] = nums[k + 1];
                    nums[k + 1] = 0;
                }
            }
        }
        return nums;
    }
}
