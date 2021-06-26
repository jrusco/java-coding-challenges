package com.jrusco.leetcode;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;


//https://leetcode.com/problems/group-anagrams/
public class GroupAnagramsTest {

    @Test
    public void test(){
        evaluateTestCase1();
        evaluateTestCase2();
    }

    private void evaluateTestCase1() {
        assertEquals(Collections.singletonList(Collections.singletonList("a")), groupAnagrams(new String[]{"a"}));
    }

    private void evaluateTestCase2() {
        List<List<String>> response = groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"});
        assertEquals(3, response.size());
        assertTrue(response.contains(Collections.singletonList("bat")));
        assertTrue(response.contains(Arrays.asList("tan", "nat")));
        assertTrue(response.contains(Arrays.asList("eat", "tea", "ate")));
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length < 2){
            return Collections.singletonList(Arrays.asList(strs));
        }
        Map<String, List<String>> anagramsMap = new HashMap<>();
        for (String word : strs) {
           char[] wordLetters = word.toCharArray();
           Arrays.sort(wordLetters);
           String sortedLetters = new String(wordLetters);
           if (!anagramsMap.containsKey(sortedLetters)){
               anagramsMap.put(sortedLetters, new ArrayList<>());
           }
           anagramsMap.get(sortedLetters).add(word);
        }
        List<List<String>> response = new LinkedList<>();
        anagramsMap.forEach((word, anagrams) -> response.add(anagrams));
        return response;
    }
}
