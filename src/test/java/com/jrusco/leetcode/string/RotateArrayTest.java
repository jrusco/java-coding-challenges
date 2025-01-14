package com.jrusco.leetcode.string;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;
import org.junit.Test;

//https://leetcode.com/problems/rotate-array
public class RotateArrayTest {
    
    @Test
    public void test() {
        // Test case 1: Example from problem
        int[] nums1 = {1,2,3,4,5,6,7};
        rotate(nums1, 3);
        int[] expected1 = {5,6,7,1,2,3,4};
        assertArrayEquals(expected1, nums1);

        // Test case 2: Example with negative numbers
        int[] nums2 = {-1,-100,3,99};
        rotate(nums2, 2);
        int[] expected2 = {3,99,-1,-100};
        assertArrayEquals(expected2, nums2);

        // Edge case: Single element
        int[] nums3 = {1};
        rotate(nums3, 1);
        assertArrayEquals(new int[]{1}, nums3);

        // Edge case: k = 0
        int[] nums4 = {1,2,3};
        rotate(nums4, 0);
        assertArrayEquals(new int[]{1,2,3}, nums4);

        // Edge case: k > array length
        int[] nums5 = {1,2,3};
        rotate(nums5, 5);  // Equivalent to k=2
        assertArrayEquals(new int[]{2,3,1}, nums5);

        // Edge case: k equals array length
        int[] nums6 = {1,2,3};
        rotate(nums6, 3);
        assertArrayEquals(new int[]{1,2,3}, nums6);

    }


    //Solution with extra rotations, not bad but not the most efficient
    public void rotate(int[] nums, int k) {
        if (k == 0) return;
        k = k % nums.length;

        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    private void reverse(int[] nums, int start, int end){
        while (start < end) {
            int aux = nums[end];
            nums[end] = nums[start];
            nums[start] = aux;
            start++;
            end--;
        }
    }
    
}
