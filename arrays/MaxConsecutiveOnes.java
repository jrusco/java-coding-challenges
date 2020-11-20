public class MaxConsecutiveOnes {

    public static void main(String[] args){
        int[] test1 = new int[]{1,1,0,1,1,1};
        System.out.println("Max amount of consecutive 1s is: " + findMaxConsecutiveOnes(test1));
    }

    /**
     * https://leetcode.com/explore/featured/card/fun-with-arrays/521/introduction/3238/
     */
    public static int findMaxConsecutiveOnes(int[] nums) {
        int amountOfConsecutiveOnes = 0;
        
        int pos = 0;
        int q = 0;
        
        while(pos < nums.length){
            q = nums[pos] == 1? q + 1 : 0;
            amountOfConsecutiveOnes = q > amountOfConsecutiveOnes ? q : amountOfConsecutiveOnes;
            pos++;
        }


        return amountOfConsecutiveOnes;
    }
}
