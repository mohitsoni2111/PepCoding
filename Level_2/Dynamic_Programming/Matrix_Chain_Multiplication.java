package Level_2.Dynamic_Programming;

import java.util.Scanner;

public class Matrix_Chain_Multiplication {
    public static int mcm(int[] arr){
        int[][] dp = new int[arr.length - 1][arr.length - 1];

        for (int g = 0; g < dp.length; g++){
            for (int i = 0, j = g; j < dp.length; j++){
                if (g == 0){
                    dp[i][j] = 0
                }
                else if (g == 1){

                }
                else {

                }
            }
        }

        return dp[0][dp.length - 1];
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
