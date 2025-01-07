package com.jrusco.leetcode.string;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

//https://leetcode.com/problems/majority-element
public class majorityElement {
    
    @Test
    public void test() {
        // Test case 1: Example from problem
        int[] nums1 = {3,2,3};
        assertEquals(3, majorityElement(nums1));

        // Test case 2: Example from problem
        int[] nums2 = {2,2,1,1,1,2,2};
        assertEquals(2, majorityElement(nums2));

        // Edge case: Single element
        int[] nums3 = {1};
        assertEquals(1, majorityElement(nums3));

        // Edge case: All same elements
        int[] nums4 = {5,5,5,5,5};
        assertEquals(5, majorityElement(nums4));

        // Edge case: Exact majority
        int[] nums5 = {1,1,1,2,2};
        assertEquals(1, majorityElement(nums5));

        // Edge case: Maximum/Minimum values
        int[] nums6 = {Integer.MAX_VALUE, Integer.MAX_VALUE};
        assertEquals(Integer.MAX_VALUE, majorityElement(nums6));

        int[] nums7 = {Integer.MIN_VALUE, Integer.MIN_VALUE, 5};
        assertEquals(Integer.MIN_VALUE, majorityElement(nums7));
    }

    //hint: Boyer-Moore Voting Algorithm (it works because elements are sorted)
    public int majorityElement(int[] nums) {
        if (nums.length == 1) return nums[0];

        int e = nums[0];
        int count = 0;
        for (int i = 0; i < nums.length / 2; i++) {
            if(nums[i] == e){
                count++;
            } else {
                count--;
            }
            
            if (count == 0){
                e = nums[i+1];
            }
        }

        return e;
    }


    /**
     * first try, not efficient -> o(n2)
     * 
     * public int majorityElement(int[] nums) {
     * if (nums.length == 1) return nums[0];
     * 
     * int candidate = 0;
     * int candidateCount = 1;
     * for (int i = 0; i < nums.length / 2; i++) {
     * int element = nums[i];
     * int elementCount = 1;
     * for (int j = i; j < nums.length; j++) {
     * if (nums[j] == element){
     * elementCount++;
     * }
     * }
     * if (elementCount > candidateCount) {
     * candidateCount = elementCount;
     * candidate = element;
     * }
     * }
     * 
     * return candidate;
     * }
     */
    
}
