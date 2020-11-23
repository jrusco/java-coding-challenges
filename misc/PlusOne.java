import java.util.Arrays;

//https://leetcode.com/problems/plus-one/
public class PlusOne {

    public static void main(String[] args){
        Arrays.stream(plusOne(new int[]{9}))
        .forEach(d -> System.out.print(d));
        System.out.println();
    }

    public static int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9){
                digits[i]++;
                return digits;
            } else {
                digits[i] = 0;
            }
        }
        if (digits[0] == 0){
            digits = new int[digits.length + 1];
            digits[0]++;
        }
        return digits;
    }
}
