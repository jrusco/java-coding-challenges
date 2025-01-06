package com.jrusco.leetcode.string;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class RemoveDuplicatesTest {
    
    @Test
    public void test() {
        // Test case 1
        int[] nums1 = {1, 1, 2};
        int k1 = removeDuplicates(nums1);
        assertEquals(2, k1);
        assertEquals(1, nums1[0]);
        assertEquals(2, nums1[1]);

        // Test case 2
        int[] nums2 = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int k2 = removeDuplicates(nums2);
        assertEquals(5, k2);
        int[] expected2 = {0, 1, 2, 3, 4};
        for (int i = 0; i < k2; i++) {
            assertEquals(expected2[i], nums2[i]);
        }

        // Edge case - empty array
        int[] nums3 = {};
        int k3 = removeDuplicates(nums3);
        assertEquals(0, k3);

        // Edge case - no duplicates
        int[] nums4 = {1, 2, 3};
        int k4 = removeDuplicates(nums4);
        assertEquals(3, k4);
        assertEquals(1, nums4[0]);
        assertEquals(2, nums4[1]);
        assertEquals(3, nums4[2]);
    }

    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0){
            return 0;
        }

        int j = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[j] != nums[i]){
                j++;
                nums[j] = nums[i];
            }
        }

        return j + 1;
    }
    
}
