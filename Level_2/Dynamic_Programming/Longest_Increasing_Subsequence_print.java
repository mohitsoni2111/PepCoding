package Level_2.Dynamic_Programming;

import java.util.Vector;

public class Longest_Increasing_Subsequence_print {
    static void printLIS(Vector<Integer> arr) {
        for (int x : arr)
            System.out.print(x + " ");
        System.out.println();
    }

    // Function to construct and print
    // The Longest Increasing Subsequence
    static void constructPrintLIS(int[] arr, int n) {
        // L[i] - The longest increasing
        // sub-sequence ends with arr[i]
        Vector<Integer>[] L = new Vector[n];
        for (int i = 0; i < L.length; i++)
            L[i] = new Vector<>();

        // L[0] is equal to arr[0]
        L[0].add(arr[0]);

        // Start from index 1
        for (int i = 1; i < n; i++){
            // Do for every j less than i
            for (int j = 0; j < i; j++) {
                //L[i] = {Max(L[j])} + arr[i]
                // where j < i and arr[j] < arr[i]
                if ((arr[i] > arr[j]) && (L[i].size() < L[j].size() + 1))
                    L[i] = (Vector<Integer>) L[j].clone();  //deep copy
            }

            // L[i] ends with arr[i]
            L[i].add(arr[i]);
        }

        // L[i] now stores increasing sub-sequence of
        // arr[0..i] that ends with arr[i]
        Vector<Integer> max = L[0];

        // LIS will be max of all increasing sub-sequences of arr
        for (Vector<Integer> x : L)
            if (x.size() > max.size())
                max = x;

        // max will contain LIS
        printLIS(max);
    }

    // Driver function
    public static void main(String[] args) {
        int[] arr = {3, 2, 4, 5, 1};
        int n = arr.length;

        // print LIS of arr
        constructPrintLIS(arr, n);
    }
}
