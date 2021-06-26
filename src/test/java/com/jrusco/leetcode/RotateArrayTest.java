package com.jrusco.leetcode;

import static org.junit.Assert.assertArrayEquals;
import org.junit.Test;

/**
 * https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/646/
 */
public class RotateArrayTest {

    @Test
    public void test1(){
        int[] nums = new int[]{1,2,3,4,5,6,7};
        rotate(nums, 3);
        assertArrayEquals(new int[]{5,6,7,1,2,3,4}, nums);
    }

    @Test
    public void test2(){
        int[] nums = new int[]{-1,-100,3,99};
        rotate(nums, 2);
        assertArrayEquals(new int[]{3,99,-1,-100}, nums);
    }

    @Test
    public void test3(){
        int[] nums = new int[]{10,15};
        rotate(nums, 1);
        assertArrayEquals(new int[]{15,10}, nums);
    }

    public void rotate(int[] nums, int k) {
        k %= nums.length;
        if (nums.length  == 1 || k == 0){
            return;
        }
        swap(nums, 0, nums.length -1);
        swap(nums, 0, k -1);
        swap(nums, k, nums.length -1);
    }

    private void swap(int[] nums, int start, int end) {
        while(start < end){
            int temp = nums[start];
            nums[start++] = nums[end];
            nums[end--] = temp;
        }
    }
}
