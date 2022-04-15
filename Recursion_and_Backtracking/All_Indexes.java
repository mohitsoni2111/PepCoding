package Recursion_and_Backtracking;

public class All_Indexes {
    public static int[] allIndex(int[] arr, int index, int element, int foundSoFar) {
        if (index == arr.length)
            return new int[foundSoFar];

        int[] res;
        if (arr[index]==element){
            res = allIndex(arr, index + 1, element, foundSoFar + 1);
            res[foundSoFar] = index;
        }
        else {
            res = allIndex(arr, index + 1, element, foundSoFar);
        }
        return res;
    }

    public static void main(String[] args){
        int[] arr = {8,1,2,7,3,4,5,7,6};
        int element = 7;
        System.out.println(allIndex(arr, 0, element, 0));
    }
}
