package LeetCode.Arrays;

public class Jump_Game_III {
    public static boolean canReach(int[] arr, int i) {
        if(i > arr.length - 1 || i < 0) return false;

        if(arr[i] == 0) return true;
        return canReach(arr, i - arr[i]) || canReach(arr, i + arr[i]);
    }
    public static void main(String[] args){
        int[] arr = {4,2,3,0,3,1,2};
        int start = 5;
        boolean ans = canReach(arr, start);
        System.out.println(ans);
    }
}
