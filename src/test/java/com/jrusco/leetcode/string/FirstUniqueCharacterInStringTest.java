package com.jrusco.leetcode.string;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.Test;

/**
 * https://leetcode.com/problems/first-unique-character-in-a-string/
 * 
 * Given a string s, find the first non-repeating character in it and return its
 * index. If it does not exist, return -1.
 * 
 */
public class FirstUniqueCharacterInStringTest {
    
    @Test
    public void test(){
        assertEquals(2, firstUniqChar("bba"));
        assertEquals(-1, firstUniqChar("bbaa"));
        assertEquals(3, firstUniqChar("asdfasdk"));
    }


    public int firstUniqChar(String s) {
        char[] freq = new char[26];
        for (char c: s.toCharArray()) freq[c - 'a']++;

        for (int i = 0; i < s.length(); i++) {
            int letter = s.charAt(i) - 'a';
            if (freq[letter] == 1){
                return i;
            }
        }

        return -1;
    }

    //original approach
    public int firstUniqChar1(String s) {
        Map<Character, Integer> charCountMap = new LinkedHashMap<>();
        Map<Character, Integer> charFirstIndexMap = new HashMap<>();
        
        for (int i = 0; i < s.length(); i++) {
            charCountMap.put(s.charAt(i), charCountMap.getOrDefault(s.charAt(i), 0) + 1);
            charFirstIndexMap.putIfAbsent(s.charAt(i), i);
        }

        return charCountMap.entrySet().stream()
            .filter(c -> c.getValue() == 1)
            .map(Map.Entry::getKey)
            .findFirst()
            .map(charFirstIndexMap::get)
            .orElse(-1);
    }

    
}
