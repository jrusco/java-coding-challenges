package com.jrusco.leetcode.string;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.Test;

//https://leetcode.com/problems/first-unique-character-in-a-string/
public class FirstUniqueCharacterInStringTest {
    
    @Test
    public void test(){
        assertEquals(2, firstUniqChar("bba"));
        assertEquals(-1, firstUniqChar("bbaa"));
        assertEquals(3, firstUniqChar("asdfasdk"));
    }

    public int firstUniqChar(String s) {
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
