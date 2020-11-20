import java.util.Arrays;
import java.util.stream.Collectors;

// https://leetcode.com/problems/single-number/
public class SingleNumber {

    public static void main(String[] args) {
        System.out.println("Should be 4: " + singleNumber(new int[]{4,1,2,2,1}));
        System.out.println("Should be 1: " + singleNumber(new int[]{1}));
    }

    public static int singleNumber(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        return Arrays.stream(nums)
            .boxed()
            .collect(Collectors.groupingBy(num -> num,  Collectors.counting()))
            .entrySet()
            .stream()
            .filter(entry -> entry.getValue() == 1L)
            .findFirst()
            .get().getKey();
    }
}
