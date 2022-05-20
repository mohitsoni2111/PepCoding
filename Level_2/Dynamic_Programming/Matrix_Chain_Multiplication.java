package Level_2.Dynamic_Programming;

import java.util.Scanner;

public class Matrix_Chain_Multiplication {
    public static int mcm(int[] arr){


        return 0;
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i < n; i++){
            arr[i] = scn.nextInt();
        }
        System.out.println(mcm(arr));
    }
}
