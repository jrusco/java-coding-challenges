package com.jrusco.leetcode.string;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

//https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii
public class RemoveDuplicatesSortedArrayIITest {
    
    @Test
    public void test() {
        // Test case 1: Example from problem description
        int[] nums1 = {1,1,1,2,2,3};
        int k1 = removeDuplicates(nums1);
        assertEquals(5, k1);
        int[] expected1 = {1,1,2,2,3};
        for (int i = 0; i < k1; i++) {
            assertEquals(expected1[i], nums1[i]);
        }

        // Test case 2: Example from problem description
        int[] nums2 = {0,0,1,1,1,1,2,3,3};
        int k2 = removeDuplicates(nums2);
        assertEquals(7, k2);
        int[] expected2 = {0,0,1,1,2,3,3};
        for (int i = 0; i < k2; i++) {
            assertEquals(expected2[i], nums2[i]);
        }

        // Edge case - empty array
        int[] nums3 = {};
        int k3 = removeDuplicates(nums3);
        assertEquals(0, k3);

        // Edge case - no duplicates
        int[] nums4 = {1,2,3};
        int k4 = removeDuplicates(nums4);
        assertEquals(3, k4);
        int[] expected4 = {1,2,3};
        for (int i = 0; i < k4; i++) {
            assertEquals(expected4[i], nums4[i]);
        }

        // Edge case - all same elements
        int[] nums5 = {1,1,1,1,1};
        int k5 = removeDuplicates(nums5);
        assertEquals(2, k5);
        assertEquals(1, nums5[0]);
        assertEquals(1, nums5[1]);

        // Edge case - exactly two duplicates
        int[] nums6 = {1,1,2,2};
        int k6 = removeDuplicates(nums6);
        assertEquals(4, k6);
        assertEquals(1, nums6[0]);
        assertEquals(1, nums6[1]);
        assertEquals(2, nums6[2]);
        assertEquals(2, nums6[3]);
    }

    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int j = 1;
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1] ) {
                count++;
            } else {
                count = 1;
            }
            if (count <= 2){
                nums[j++] = nums[i];
            }
        }

        return j ;
    }
    
}
