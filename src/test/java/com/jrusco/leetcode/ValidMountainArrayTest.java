package com.jrusco.leetcode;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

//https://leetcode.com/problems/valid-mountain-array/
public class ValidMountainArrayTest {
    
    @Test
    public void test(){
        assertFalse(validMountainArray(new int[]{2,1}));
        assertTrue(validMountainArray(new int[]{0,3,2,1}));
        assertFalse(validMountainArray(new int[]{1,3,5,5}));
        assertFalse(validMountainArray(new int[]{2,0,2}));
        assertFalse(validMountainArray(new int[]{0,1,2,3,4,5,6,7,8,9}));
        assertFalse(validMountainArray(new int[]{9,8,7,6,5,4,3,2,1,0}));
    }


    //TODO: implementation can be improved by asserting there are INDEXES where values stop increasing and start decreasing.
    //If values dont increase, it can be determined from the get go that's not a "mountain array".
    //Same for increasing values that never decrease. If the index where these changes happens cannot be determined, then arr is invalid.
    public boolean validMountainArray(int[] arr) {
        if (arr.length < 3){
            return false;
        }

        boolean shouldGoUp = true;
        boolean isValidMountain = true;
        int current = arr[0];
        int i = 1;

        if (current > arr[i]){
            return false;
        }

        while(i < arr.length && isValidMountain){
            if (current > arr[i]){
                shouldGoUp = false;
            } else if ((current >= arr[i] && shouldGoUp) || (!shouldGoUp && current <= arr[i])){
                isValidMountain = false;
            }
            current = arr[i++];
        }
        return isValidMountain && !shouldGoUp;
    }

}
