package Level_2.Bit_Manipulation;

import java.util.Scanner;

public class Triplets_1 {
    public static void solution(int[] arr){
        int count = 0;

        for (int i = 0; i < arr.length; i++){
            int val = arr[i];
            for (int k = i + 1; k < arr.length; k++){
                val = val ^ arr[k];

                if (val == 0){
                    count += (k - i);
                }
            }
        }
        System.out.println(count);
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i < arr.length; i++){
            arr[i] = scn.nextInt();
        }
        solution(arr);
    }
}
