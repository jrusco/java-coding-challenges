import java.util.Arrays;

/**
 * https://leetcode.com/explore/featured/card/fun-with-arrays/521/introduction/3237/
 */
public class EvenNumberOfDigits {

    public static void main(String[] args){
        int[] test1 = new int[]{12,345,2,6,7896};
        System.out.println(findNumbers(test1));
    }

    public static int findNumbers(int[] nums) {
        return ((Long)Arrays.stream(nums).boxed().filter(n -> String.valueOf(n).length() % 2 == 0).count()).intValue();
    }

}
