//TODO link to the challenge
public class FirstBadVersion {

    public static void main(String[] args){
        System.out.println(firstBadVersion(3));
    }

    public static int firstBadVersion(int n) {
        if (n == 1) return 1;
        int floor = 1, ceiling = n, middle = 0;
        while (middle < ceiling){
            middle = floor + ((int) Math.ceil((ceiling - floor) / 2d));
            if(isBadVersion(middle)){
                ceiling = middle;
            } else {
                floor = middle;
            }
        }
        return middle;
    }

    private static boolean isBadVersion(int version){
        return version >= 3;
    }
}
