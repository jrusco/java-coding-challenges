import java.util.Arrays;

public class TwoSum {

    public static void main(String[] args){
        int[] result = twoSum(new int[]{2,5,5,11}, 10);
        Arrays.stream(result).forEach(n -> System.out.println(n));
    }

    public static int[] twoSum(int[] nums, int target) {
        if (nums.length == 2) return new int[]{0, 1};
        int i = 0;
        while(i <= nums.length - 2){
            int j = (i == 0) ? 1 : 0;
            while (j <= nums.length - 1){
                if (nums[i] + nums[j] == target){
                    return new int[]{i, j};
                }
                j = (j + 1 == i) ? j+2 : j+1;
            }
            i++;
        }
        return new int[]{nums.length - 2, nums.length - 1};
    }
}
