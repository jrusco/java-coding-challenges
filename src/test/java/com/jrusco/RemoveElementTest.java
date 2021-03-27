package com.jrusco;

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
}
