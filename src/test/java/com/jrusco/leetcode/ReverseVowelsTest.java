package com.jrusco.leetcode;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

//https://leetcode.com/problems/reverse-vowels-of-a-string/
public class ReverseVowelsTest {
    
    @Test
    public void test(){
        assertEquals("holle", reverseVowels("hello"));
        assertEquals("aA", reverseVowels("Aa"));
        assertEquals("qwerty", reverseVowels("qwerty"));
    }

    public String reverseVowels(String s) {
        char[] charArray = s.toCharArray();
        Set<Character> vowels = new HashSet<>(Arrays.asList('a','e','i','o','u','A','E','I','O','U'));
        int i = 0;
        int j = charArray.length - 1;

        while(i < j){
            while (i < j && !vowels.contains(charArray[i])) {
                i++;
            }
            while (j > i && !vowels.contains(charArray[j])) {
                j--;
            }
            if (vowels.contains(charArray[i]) && vowels.contains(charArray[j])){
                char temp = charArray[i];
                charArray[i++] = charArray[j];
                charArray[j--] = temp;
            }
        }

        return new String(charArray);
    }

    /*
    public String reverseVowels(String s) {
        char[] array = s.toCharArray();
        List<Character> vowels = Arrays.asList('a','e','i','o','u','A','E','I','O','U');
        Stack<Character> vowelStack = new Stack<>();

        for (Character character : array) {
            if (vowels.contains(character)){
                vowelStack.push(character);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (Character character : array) {
            if (vowels.contains(character)){
                sb.append(vowelStack.pop());
            } else {
                sb.append(character);
            }
        }

        return sb.toString();
    }

    */

}
