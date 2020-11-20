import java.util.Arrays;

/**
 * https://leetcode.com/explore/learn/card/fun-with-arrays/525/inserting-items-into-an-array/3253/
 */
public class MergeSortedArray {

    public static void main(String[] args){
        int[] nums1 = new int[]{1,2,3,0,0,0};
        int[] nums2 = new int[]{2,5,6};
        int m = 3;
        int n = 3;
        merge(nums1, m, nums2, n);
        printResult(nums1);
    }

    //---------
    public static void merge(int[] nums1, int m, int[] nums2, int n){
        if (n > 0){
            for(int nums2index = 0; nums2index < n; nums2index++){
                //get the number to insert in the array
                int num2 = nums2[nums2index];
                //find out where it should be placed
                int insertAtIndex = findIndexForNum(num2, nums1);
                //move the elements in the array to make space for the new number
                //TODO: this for loop should be moved to a method
                for (int i = m + insertAtIndex; i > insertAtIndex; i++){
                    nums1[i] = nums1[i - 1];
                }
                //insert the new number
                nums1[insertAtIndex] = num2;
            }
        }
    }


    private static int findIndexForNum(int num2, int[] nums1) {
        int indexOfNum2 = 0;
        while(nums1[indexOfNum2] < num2){
            indexOfNum2 = indexOfNum2 + 1;
        }
        return 0;
    }

    //---------

    public static void printResult(int[] results) {
        Arrays.stream(results).forEach(r -> System.out.println(r));
    }
}
