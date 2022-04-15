package Recursion_and_Backtracking;

public class Max_of_Array {
    private static int printMax(int[] arr, int i) {
        if(i == arr.length - 1)
            return arr[i];
        return Math.max(arr[i], printMax(arr, i + 1));
    }
    public static void main(String[] args){
        int[] arr = {8,1,2,3,4,5,6};
        System.out.println(printMax(arr, 0));
    }
}
