package com.jrusco.leetcode;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

//https://leetcode.com/problems/reverse-only-letters/
public class ReverseLettersOnlyTest {
    
    @Test
    public void test0(){
        assertEquals("za", reverseOnlyLetters("az"));
        assertEquals("1=", reverseOnlyLetters("1="));
        assertEquals("dc-ba", reverseOnlyLetters("ab-cd"));
        assertEquals("j-Ih-gfE-dCba", reverseOnlyLetters("a-bC-dEf-ghIj"));
        assertEquals("Qedo1ct-eeLg=ntse-T!", reverseOnlyLetters("Test1ng-Leet=code-Q!"));
    }

    public String reverseOnlyLetters(String s) {
        char[] charArray = s.toCharArray();
        int i = 0;
        int j = s.length() - 1;

        while (i < j){
            while (i < j && !Character.isLetter(charArray[i])){
                i++;
            }
            while (j > i && !Character.isLetter(charArray[j])){
                j--;
            }
            char aux = charArray[i];
            charArray[i++] = charArray[j];
            charArray[j--] = aux;
        }

        return new String(charArray);
    }

}
