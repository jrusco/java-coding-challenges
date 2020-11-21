
//https://leetcode.com/problems/find-peak-element/
public class PeakElement {

    public static void main(String[] args){
        System.out.println(findPeakElement(new int[]{1,2,1,3,5,6,4}));
        System.out.println(findPeakElement(new int[]{1,2}));
        System.out.println(findPeakElement(new int[]{5}));
    }

    public static int findPeakElement(int[] nums) {
        for(int i = 1; i <= nums.length - 1; i++ ){
            if (nums[i] > nums[i-1] && 
                    (i == nums.length - 1 || nums[i] > nums[i+1])){
                return i;
            }
        }
        return 0;
    }
}
