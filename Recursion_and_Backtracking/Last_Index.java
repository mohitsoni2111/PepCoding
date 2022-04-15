package Recursion_and_Backtracking;

import static Recursion_and_Backtracking.First_Index.firstIndex;

public class Last_Index {
    public static int lastIndex(int[] arr, int index, int element) {
        if (index == arr.length)
            return -1;

        int n = lastIndex(arr, index + 1, element);
        if (n == -1){
            if (arr[index] == element)
                return index;
            else
                return -1;
        }
        else
            return -1;
    }

    public static void main(String[] args){
        int[] arr = {8,1,2,7,3,4,5,7,6};
        int element = 7;
        System.out.println(lastIndex(arr, 0, element));
    }
}
