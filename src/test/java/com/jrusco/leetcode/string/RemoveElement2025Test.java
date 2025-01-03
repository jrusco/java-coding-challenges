package com.jrusco.leetcode.string;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

//https://leetcode.com/problems/remove-element
public class RemoveElement2025Test {
    
    @Test
    public void test(){
        // Test case 1
        int[] nums1 = {3,2,2,3};
        int val1 = 3;
        int result1 = removeElement(nums1, val1);
        assertEquals(2, result1);
        // Verify first k elements (order may vary)
        int count1 = 0;
        for(int i = 0; i < result1; i++) {
            if(nums1[i] == 2) count1++;
        }
        assertEquals(2, count1);

        // Test case 2
        int[] nums2 = {0,1,2,2,3,0,4,2};
        int val2 = 2;
        int result2 = removeElement(nums2, val2);
        assertEquals(5, result2);
        // Verify first k elements (order may vary)
        int zeros = 0, ones = 0, threes = 0, fours = 0;
        for(int i = 0; i < result2; i++) {
            if(nums2[i] == 0) zeros++;
            if(nums2[i] == 1) ones++;
            if(nums2[i] == 3) threes++;
            if(nums2[i] == 4) fours++;
        }
        assertEquals(2, zeros);
        assertEquals(1, ones);
        assertEquals(1, threes);
        assertEquals(1, fours);
    }

    public int removeElement(int[] nums, int val) {
        int i = 0;
        for (int n : nums) {
            if (n != val){
                nums[i] = n;
                i++;
            }
        }
        return i;
    }
}
