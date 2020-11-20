import java.util.Arrays;

//TODO: fix and submit
/**
 * https://leetcode.com/explore/featured/card/fun-with-arrays/525/inserting-items-into-an-array/3245/
 */
public class DuplicateOcurrenceOfZeros {

    public static void main(String[] args){
        // int[] nums = new int[]{1,0,2,3,0,4,5,0};
        // int[] nums = new int[]{1,2,3};
        int[] nums = new int[]{8,5,0};
        duplicateZeros(nums);
        Arrays.asList(nums).forEach(n -> System.out.println(n));
    }

    public static void duplicateZeros(int[] arr) {
        //first, check how many extra zeros will be by iterating the original array
        int possibleDups = 0;
        int i = 0;
        while (i < arr.length){
            if (arr[i] == 0){
                possibleDups = possibleDups + 1;
                i = i + 2;
            } else {
                i = i + 1;
            }
        }
        
        //second, calculate how many original numbers will be copied from the original array (since there will be numbers "pushed out" of the array)
        int copyUpToIndex = arr.length - possibleDups; 

        //third, start moving the items from the end of the array towards the beggining. Otherwise, you'll be stepping over the elements not-yet copied.
        if (possibleDups > 0){
            int toIndex = arr.length - 1;
            for(int fromIndex = copyUpToIndex; fromIndex > 0; fromIndex--){
                arr[toIndex] = arr[fromIndex]; 
                if (arr[fromIndex] == 0 && toIndex > 0){
                    toIndex = toIndex - 1;
                    arr[toIndex] = 0;
                }
                toIndex = toIndex - 1;
            }
        }
    }
}
