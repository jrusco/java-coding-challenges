package com.jrusco.demo.silver.silvers20easyset;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * https://leetcode.com/problems/sqrtx
 * 
 * SOLVED WITH HELP OF AI
 * - Understanding binary search pointers issues
 * - Type missmatch between int and long, without explicit casting int will still overflow
 * 
 * == My Notes ==
 * - Binary search on the answer space [1, x], not on an array index.
 * - Use `left + (right - left) / 2` for mid, NOT `(right - left) / 2`.
 *   The second form computes a distance from 0, not a position in the current
 *   window — once left shifts up, mid lands outside [left, right] and the
 *   search breaks (infinite loop / wrong results on large inputs).
 * - `(left + right) / 2` also works conceptually but risks int overflow when
 *   both bounds are large. `left + (right - left) / 2` keeps intermediates small.
 * - Save `result = mid` when square < x: mid is a valid floor candidate.
 *   When the loop ends without an exact match, result holds the last valid one.
 */
public class SqrtxTest {
    
    @Test
    public void test(){
        assertEquals(2, mySqrt(4));
        assertEquals("reqs rounding down from 2.82842", 2, mySqrt(8));
        assertEquals(46339, mySqrt(2147395599));
    }

    public int mySqrt(int x) {
        //binary search
        int left = 1;
        int right = x;
        int result = 0;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            //Java evaluates expressions using the types of the operands, not the type of the variable receiving the result. 
            // If I do just `mid * mid` then result is int, THEN widened to long (but overflow already happened)
            long square = (long) mid * mid;
            if (square == x){
                return mid;
            //continue with the binary search
            } else if (square < x){
                //Why save `result = mid` ? see Notes
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }

    
}
