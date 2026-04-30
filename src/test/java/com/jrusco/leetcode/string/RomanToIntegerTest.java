package com.jrusco.leetcode.string;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

/**
 * https://leetcode.com/problems/roman-to-integer/description/?envType=problem-list-v2&envId=string
 * 
 * 
 */
public class RomanToIntegerTest {
    
    @Test
    public void test(){
        assertEquals(3, romanToInt("III"));
        assertEquals(58, romanToInt("LVIII"));
        assertEquals(1994, romanToInt("MCMXCIV"));
    }

    public int romanToInt(String s) {
        int sum = 0;

        // Initialize the map from Roman to Integer
        Map<Character, Integer> valueMap = new HashMap<>();
        valueMap.put('I', 1);
        valueMap.put('V', 5);
        valueMap.put('X', 10);
        valueMap.put('L', 50);
        valueMap.put('C', 100);
        valueMap.put('D', 500);
        valueMap.put('M', 1000);

        // Go over each element of the String, and compare it to the next... 
        char[] sArray = s.toCharArray();
        for (int i = 0; i < sArray.length; i++) {
            int current = valueMap.get(sArray[i]);
            // if current is the last char of the String
            // or if is bigger than the next, add it
            if (i == sArray.length -1 || current >= valueMap.get(sArray[i + 1])){
                sum += current;
            } else {
                // else: current is smaller that the next, means its substracting
                sum -= current;
            }
        }

        return sum;
    }
    
    //Instead of the Map, could use this to reduce complexity
    private int romanValue(char c) {
        return switch (c) {
            case 'I' -> 1;
            case 'V' -> 5;
            case 'X' -> 10;
            case 'L' -> 50;
            case 'C' -> 100;
            case 'D' -> 500;
            case 'M' -> 1000;
            default -> 0;
        };
    }

}
