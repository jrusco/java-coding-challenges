package com.jrusco.leetcode.string;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

//https://leetcode.com/problems/merge-sorted-array
public class MergeSortedArrayTest {

    @Test
    public void test() {
        int[] nums1 = new int[]{1,2,3,0,0,0};
        int[] nums2 = new int[]{2,5,6};
        merge(nums1, 3, nums2, 3);
        assertEquals(Arrays.toString(new int[]{1,2,2,3,5,6}), Arrays.toString(nums1));
        
        nums1 = new int[]{2,0};
        nums2 = new int[]{1};
        merge(nums1, 1, nums2, 1);
        assertEquals(Arrays.toString(new int[]{1,2}), Arrays.toString(nums1));
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
            int p1 = m - 1;
            int p2 = n - 1;
            int p = m + n - 1;

            while(p2 >= 0){
                if (p1 >= 0 && nums1[p1] > nums2[p2]){
                    nums1[p] = nums1[p1];
                    p1--;
                } else {
                    nums1[p] = nums2[p2];
                    p2--;
                }
                p--;
            }
        }
    
}
