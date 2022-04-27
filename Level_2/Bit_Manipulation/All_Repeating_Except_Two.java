package Level_2.Bit_Manipulation;

import java.util.Scanner;

public class All_Repeating_Except_Two {

    public static void solution(int[] arr){
        int xXORy = 0;
        for (int val : arr){
            xXORy = xXORy ^ val;
        }

        int rsbm = xXORy & -xXORy;

        int x = 0;
        int y = 0;
        for (int val : arr){
            if ((val & rsbm) == 0){
                x = x ^ val;
            }
            else {
                y = y ^ val;
            }
        }
        if (x < y){
            System.out.println(x);
            System.out.println(y);
        }
        else {
            System.out.println(y);
            System.out.println(x);
        }
    }
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i < n; i++){
            arr[i] = scn.nextInt();
        }
        solution(arr);
    }
}
