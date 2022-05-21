package Level_2.Dynamic_Programming;

import java.util.Scanner;

public class Burst_Balloons {
    public static int solution(int[] arr) {
        //write your code here

        return 0;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
        }
        System.out.println(solution(arr));
    }
}
