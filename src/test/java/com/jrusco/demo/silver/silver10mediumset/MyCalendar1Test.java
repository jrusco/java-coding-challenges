package com.jrusco.demo.silver.silver10mediumset;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.TreeMap;

import org.junit.Test;

/**
 * https://leetcode.com/problems/my-calendar-i
 * 
 * You are implementing a program to use as your calendar. We can add a new
 * event if adding the event will not cause a double booking.
 * 
 * A double booking happens when two events have some non-empty intersection
 * (i.e., some moment is common to both events.).
 * 
 * The event can be represented as a pair of integers startTime and endTime that
 * represents a booking on the half-open interval [startTime, endTime), the
 * range of real numbers x such that startTime <= x < endTime.
 * 
 * Implement the MyCalendar class:
 * 
 * MyCalendar() Initializes the calendar object.
 * boolean book(int startTime, int endTime) Returns true if the event can be
 * added to the calendar successfully without causing a double booking.
 * Otherwise, return false and do not add the event to the calendar.
 * 
 * 
 * 
 * == My Notes ==
 * - TreeMap keeps keys sorted automatically; floorEntry/ceilingEntry give O(log n) neighbor lookup vs O(n) for a plain list scan.
 * - Two neighbors are sufficient: floor (left) checks if an existing booking's END bleeds into the new START; ceiling (right) checks if an existing booking's START falls before the new END.
 * - Half-open intervals [start, end) make boundary checks strict (<, not <=): book(20,30) after book(10,20) is valid because 20 < 20 is false.
 * - Use var instead of Map.Entry<Integer,Integer> to avoid the import — LeetCode's isolated class context doesn't resolve it.
 */
public class MyCalendar1Test {
    
    @Test
    public void test(){
        /**
         * Example 1:
         * 
         * Input
         * ["MyCalendar", "book", "book", "book"]
         * [[], [10, 20], [15, 25], [20, 30]]
         * Output
         * [null, true, false, true]
         * 
         * Explanation
         * MyCalendar myCalendar = new MyCalendar();
         * myCalendar.book(10, 20); // return True
         * myCalendar.book(15, 25); // return False, It can not be booked because time
         * 15 is already booked by another event.
         * myCalendar.book(20, 30); // return True, The event can be booked, as the
         * first event takes every time less than 20, but not including 20.
         */
        MyCalendar myCalendar = new MyCalendar();
        assertTrue(myCalendar.book(10, 20));
        assertFalse(myCalendar.book(15, 25));
        assertTrue(myCalendar.book(20, 30));
    }

    class MyCalendar {

        TreeMap<Integer, Integer> treeMap;

        public MyCalendar() {
            treeMap = new TreeMap<>();
        }

        public boolean book(int startTime, int endTime) {

            // FLOOR is the value to the LEFT
            // so I'm checking that the end (entry.value) of an existing booking does not overlap with the startTime of the new one Im trying to insert
            // Example of collision: existing[25,50] --- new[40,60]
            var entry = treeMap.floorEntry(startTime);
            if (entry != null && entry.getValue() > startTime){
                // end of existing booking overlaps with start of the new one
                return false;
            }

            // CEILING is the value to the RIGHT, 
            // so Im checking here that the start (entry.key) of an existing booking does not overlap with the endTime of the new one im trying to insert.
            // Example of collision: new[20,35] --- existing[30,40]
            entry = treeMap.ceilingEntry(startTime);
            if (entry != null && entry.getKey() < endTime){
                // begining of existing booking overlaps with end of the new one
                return false;
            }

            treeMap.put(startTime, endTime);
            return true;
        }
    }

    /**
     * Your MyCalendar object will be instantiated and called as such:
     * MyCalendar obj = new MyCalendar();
     * boolean param_1 = obj.book(startTime,endTime);
     */

    
}
