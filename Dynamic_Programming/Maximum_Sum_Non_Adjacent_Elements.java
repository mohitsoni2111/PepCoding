package Dynamic_Programming;

import java.util.Scanner;

public class Maximum_Sum_Non_Adjacent_Elements {

    private static int maximumSum(int[] arr) {
        int oldInclude = arr[0];
        int oldExclude = 0;

        for (int i = 1; i < arr.length; i++){
            int newInclude = oldExclude + arr[i];
            int newExclude = Math.max(oldInclude, oldExclude);
            oldInclude = newInclude;
            oldExclude = newExclude;
        }
        return Math.max(oldInclude, oldExclude);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++)
            arr[i] = sc.nextInt();

        int ans = maximumSum(arr);
        System.out.println(ans);
    }
}
