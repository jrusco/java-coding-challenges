package com.jrusco.demo.silver.silvers20easyset;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * https://leetcode.com/problems/search-insert-position/description/?envType=problem-list-v2&envId=2z168m6d
 * 
 * == My notes ==
 * - Any time you see "sorted array + O(log n)", think binary search first. The
 * O(log n) constraint is a strong hint: it rules out linear scan (O(n))
 *
 */
public class SearchInsertPositionTest {
    
    @Test
    public void test(){
        assertEquals(2, searchInsert(new int[]{1,3,5,6}, 5));
        assertEquals(1, searchInsert(new int[] { 1, 3, 5, 6 }, 2));
        assertEquals(4, searchInsert(new int[] { 1, 3, 5, 6 }, 7));
    }

    public int searchInsert(int[] nums, int target) {
        //binary search -> does O(log n) as the challenge requires
        int left = 0;
        int right = nums.length - 1;
        while (left <= right){
            int mid = right - left / 2;
            if (nums[mid] == target){
                return mid;
            } else if (nums[mid] < target){
                //dont just assign 'mid' since you already know 'target' is not in that range 
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        //if 'target' was not found, this is where it should be placed
        return left;
    }

    
}
