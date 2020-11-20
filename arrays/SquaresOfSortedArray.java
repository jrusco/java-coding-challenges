import java.util.Arrays;

/**
 * https://leetcode.com/explore/featured/card/fun-with-arrays/521/introduction/3240/
 */
public class SquaresOfSortedArray {

    public static void main(String[] args){
        int[] test1 = new int[]{-4,-1,0,3,10};
        System.out.println(sortedSquares(test1));
    }

    public static int[] sortedSquares(int[] A) {
        return Arrays.stream(A).map(a -> a*a).sorted().toArray();
    }
}
