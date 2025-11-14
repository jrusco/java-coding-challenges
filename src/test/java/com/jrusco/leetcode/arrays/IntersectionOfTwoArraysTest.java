package com.jrusco.leetcode.arrays;

import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

import org.junit.Test;

//https://leetcode.com/problems/intersection-of-two-arrays/
public class IntersectionOfTwoArraysTest {
    
    @Test
    public void test(){
        /*
         * Input: nums1 = [1,2,2,1], nums2 = [2,2]
         * Output: [2]
         */
        assertArrayEquals(new int[]{2}, intersection(new int[]{1,2,2,1}, new int[]{2,2}));
    }

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set2 = Arrays.stream(nums2).boxed().collect(Collectors.toSet());
        return Arrays.stream(nums1)
            .distinct()
            .filter(set2::contains)
            .toArray();
    }

    
}
