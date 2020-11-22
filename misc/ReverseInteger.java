//https://leetcode.com/problems/reverse-integer/
public class ReverseInteger {

    public static void main(String[] args){
        System.out.println(reverse(-1563847412));
    }

    public static int reverse(int x) {
        boolean isNegative = x < 0;
        if (isNegative) x *= -1;
        long reversedX = 0;
        while (x > 0){
            reversedX = (reversedX *= 10) + (x % 10);
            x = x / 10;
        }
        if (isNegative) reversedX *= -1;
        return Math.abs(reversedX) > Integer.MAX_VALUE  ? 0 : (int) reversedX;
    }
}
