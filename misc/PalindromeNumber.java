//https://leetcode.com/problems/palindrome-number/
public class PalindromeNumber {

    public static void main(String[] args){
    }

    public static boolean isPalindrome(int x) {
        if (x < 0) return false;
        if (x < 10) return true;
        int original = x;
        int reversed = 0;
        while (x > 0){
            reversed = (reversed *= 10) + (x % 10);
            x = x / 10;
        }
        return original == reversed;
    }
}
