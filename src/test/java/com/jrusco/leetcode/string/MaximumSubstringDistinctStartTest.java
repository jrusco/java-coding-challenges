package com.jrusco.leetcode.string;

import static org.junit.Assert.assertEquals;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.junit.Test;

/**
 * https://leetcode.com/problems/maximum-substrings-with-distinct-start/?envType=problem-list-v2&envId=string
 * 
 * == My Notes ==
 * - in this case i only need to count the substrings that have a distinct starting character,
 * therefore here only that first character matters.
 * - when I convert the char array into a Set, then im automatically getting the count of all
 * distinct characters in the string. Dont need to be doing any manual counting or sums.
 */
public class MaximumSubstringDistinctStartTest {
    
    @Test
    public void test(){
        //expected: 2 -> "a", "bab"
        assertEquals(2, maxDistinct("abab"));
        
        // expected: 4 -> "a", "b", "c", "d"
        assertEquals(4, maxDistinct("abcd"));

        // expected: 1 -> "aaaa"
        assertEquals(1, maxDistinct("aaaa"));
    }

    public int maxDistinct(String s) {
        return s.chars().mapToObj(c -> (char) c).collect(Collectors.toSet()).size();
    }

    
}
