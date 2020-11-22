import java.util.Arrays;

//https://leetcode.com/problems/move-zeroes/
public class MoveZeroes {

    public static void main(String[] args){
        int[] nums = new int[]{0,1,0,3,12};
        // int[] nums = new int[]{0,0,0,1};
        moveZeroes(nums);
        Arrays.stream(nums).forEach(n -> System.out.print(n + " "));
    }

    public static void moveZeroes(int[] nums) {
        if (nums.length <= 1) return;
        for (int i = 0; i < nums.length - 1; i++) {
            int j = i;
            if (nums[i] == 0){
                while (nums[j] == 0 && j < nums.length - 1){
                    j++;
                }
                for (int k = j - 1; k >= i; k--){
                    nums[k] = nums[k + 1];
                    nums[k + 1] = 0;
                }
            }
        }
    }
}
