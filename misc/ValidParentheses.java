import java.util.Objects;
import java.util.Stack;

// https://leetcode.com/problems/valid-parentheses/
public class ValidParentheses {

    public static void main(String[] args){
        // System.out.println("string 1 should be true: " + validate("()[]{}"));
        // System.out.println("string 2 should be true: " + validate("({[]})"));
        // System.out.println("string 3 should be false: " + validate("([)]"));
        System.out.println("string 4 should be false: " + validate("("));
        System.out.println("string 5 should be false: " + validate("(("));
        System.out.println("string 6 should be false: " + validate(")("));
    }

    public static boolean validate(String arg) {
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
