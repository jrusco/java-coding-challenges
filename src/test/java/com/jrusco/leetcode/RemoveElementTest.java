package com.jrusco.leetcode;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

//https://leetcode.com/problems/remove-element/
public class RemoveElementTest {
    
    @Test
    public void test0(){
        assertEquals(5, removeElement(new int[]{0,1,2,2,3,0,4,2}, 2));
    }

    @Test
    public void test1(){
        assertEquals(1, removeElement(new int[]{1,2,2}, 2));
    }

    @Test
    public void test2(){
        assertEquals(2, removeElement(new int[]{3,2,2,3}, 3));
    }

    @Test
    public void test3(){
        assertEquals(1, removeElement(new int[]{2}, 3));
    }

    @Test
    public void test5(){
        assertEquals(2, removeElement(new int[]{3,3}, 5));
    }
    
    @Test
    public void test6(){
        assertEquals(0, removeElement(new int[]{1}, 1));
    }

    public int removeElement(int[] nums, int val) {
        if (nums.length == 0 || (nums.length == 1 && nums[0] != val)){
            return nums.length;
        }
        int numsRemoved = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val){
                int j = i;
                while(j < nums.length - 1 && nums[j] == val){
                    j++;
                }
                if (nums[j] != val){
                    nums[i] = nums [j];
                    nums[j] = val;
                    numsRemoved++;
                } else {
                    return i;
                }
            }
        }
        return nums.length - numsRemoved;
    }

    /**
    * This solution is not correct if we consider what's asked in the problem description:
    * > you must do this by modifying the input array in-place with O(1) extra memory.
    * > The order of elements can be changed. It doesn't matter what you leave beyond the new length.
    * 
    * Because it'll return the right new length, but it won't include all the right values in the new length and
    * it'll also leave the last item in the array as it is (even if == val)
    */
    public int proposedRemoveElement(int[] nums, int val){
        int index = 0;
        for (int i : nums) {
            if (i != val){
                nums[index++] = i;
            }
        }
        return index;
    }
}
