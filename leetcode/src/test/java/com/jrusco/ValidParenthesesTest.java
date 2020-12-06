package com.jrusco;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import java.util.Objects;
import java.util.Stack;
import org.junit.Test;

// https://leetcode.com/problems/valid-parentheses/
public class ValidParenthesesTest {

    @Test
    public void main(){
        assertTrue(validate("()[]{}"));
        assertTrue(validate("({[]})"));
        assertFalse(validate("([)]"));
        assertFalse(validate("("));
        assertFalse(validate("(("));
        assertFalse(validate(")("));
    }

    public boolean validate(String arg) {
        if (Objects.isNull(arg) || arg.isEmpty()){
            return true;
        }
        if (arg.length() == 1){
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (char s : arg.toCharArray()) {
            if (s == '(' || s == '{' || s == '['){
                stack.push(s);
            } else if (!stack.empty() &&
                        ((s == ')' && stack.peek() ==  '(') ||
                        (s == '}' && stack.peek() ==  '{') ||
                        (s == ']' && stack.peek() ==  '['))){
                stack.pop();
            } else {
                return false;
            }
        }
        return stack.empty();
    }
}
