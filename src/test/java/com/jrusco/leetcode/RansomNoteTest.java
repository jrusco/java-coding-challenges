package com.jrusco.leetcode;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.junit.Test;

//https://leetcode.com/problems/ransom-note
public class RansomNoteTest {
    
    @Test
    public void test(){
        assertFalse(canConstruct("aa", "ab"));
        assertTrue(canConstruct("cc", "zcc"));
        assertFalse(canConstruct("aab", "ab"));
        assertFalse(canConstruct("a", ""));
    }

    public boolean canConstruct(String ransomNote, String magazine) {

        if (magazine.length() == 0 || ransomNote.length() > magazine.length()){
            return false;
        }

        //This could be also done with a foreach loop
        Map<Character, Long> available = magazine.chars()
            .mapToObj(i -> (char) i)
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        
        for (char c : ransomNote.toCharArray()) {
            if(!available.containsKey(c) || available.get(c) < 1){
                return false;
            }
            available.put(c, available.get(c) - 1);
        }
        return true;
    }
}
