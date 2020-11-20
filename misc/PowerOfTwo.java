
//https://leetcode.com/problems/power-of-two/
public class PowerOfTwo {

    public static void main(String[] args){
        System.out.println("16 is " + isPowerOfTwo(16));
        System.out.println("3 is " + isPowerOfTwo(3));
    }

    public static boolean isPowerOfTwo(int n) {
        if (n == 0) return false;
        if (n == 1) return true;
        long i = 1;
        while (i < n){
            i *= 2;
        }
        return i == n;
    }
}
