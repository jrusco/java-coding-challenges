package com.jrusco.leetcode;


import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class AddStringsTest {
    
    @Test
    public void test0(){
        assertEquals("10", addStrings("1", "9"));
        assertEquals("5", addStrings("2", "3"));
        assertEquals("533", addStrings("456", "77"));
        assertEquals("0", addStrings("0", "0"));
    }

    public String addStrings(String num1, String num2) {
        if (num1.equals("0") && num2.equals("0")){
            return "0";
        }
        StringBuilder resultBuilder = new StringBuilder();
        //Not allowed to use existing libs, I need to read each char of the string and perform the sum operation
        //as I would normally do with pen and paper: adding digits starting from the end of the number
        //(sum units first, then tens, hundreds, and so on)
        int i1 = num1.length() - 1;
        int i2 = num2.length() - 1;
        int rest = 0;

        //num1 and num2 could be of different length. I should continue as long as one of them still has digits
        while(i1 >= 0 || i2 >= 0){
            //At the end of each iteration there could be a carry sum, meaning the sum of 
            //num1.charAt(i1--) and num2.charAt(i2--) could be >= 10. In this case I need to take the digit from the "tens" and
            //carry it over to the next iteration.
            int currentIterationSum = rest;
            if (i1 >= 0){
                //by substracting a character to another, I'm actually substracting their (int) positions in the ASCII table
                //I.e. '0' is five positions away from '5', so the operation below will return the int value of the numeric char.
                currentIterationSum += num1.charAt(i1--) - '0';
            }
            if (i2 >= 0){
                currentIterationSum += num2.charAt(i2--) - '0';
            }
            //If there's any digit in the "tens", I'm storing it in the 'rest' var to carry it over to the next iteration.
            rest = currentIterationSum / 10;
            //On each iteration I'm just appending the last digit of the sum to the final outcome
            resultBuilder.append(currentIterationSum % 10);
        }
        if (rest > 0){
            resultBuilder.append(rest);
        }
        //As I've been processing the input backwards (from num1.length() - 1, doing i--) the result is also backwards,
        //I need to reverse it so the digits are in the right order.
        return resultBuilder.reverse().toString();
    }
}
