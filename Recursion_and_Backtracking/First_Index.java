package Recursion_and_Backtracking;

public class First_Index {
    public static int firstIndex(int[] arr, int index, int element) {
        if (index == arr.length)
            return -1;

        if (arr[index] == element)
            return index;
        else
            return firstIndex(arr, index + 1, element);
    }

    public static void main(String[] args){
        int[] arr = {8,1,2,7,3,4,5,7,6};
        int element = 7;
        System.out.println(firstIndex(arr, 0, element));
    }
}
