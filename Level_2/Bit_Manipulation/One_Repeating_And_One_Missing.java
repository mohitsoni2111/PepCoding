package Level_2.Bit_Manipulation;

import java.util.Scanner;

public class One_Repeating_And_One_Missing {
    public static void solution(int[] arr){
        int xor = 0;
        for (int val : arr) {
            xor = xor ^ val;
        }

        for (int i = 1; i < arr.length; i++){
            xor = xor ^ i;
        }

        int rsbm = xor & -xor;

        int x = 0;
        int y = 0;
        for (int val : arr) {
            if ((val & rsbm) == 0)
                x = x ^ val;
            else
                y = y ^ val;
        }
        for (int i = 1; i < arr.length; i++){
            if ((i & rsbm) == 0)
                x = x ^ i;
            else
                y = y ^ i;
        }

        for (int val : arr){
            if (val == x){
                System.out.println("Missing Number -> " + y);
                System.out.println("Repeating Number -> " + x);
                break;
            }
            else if (val == y){
                System.out.println("Missing Number -> " + x);
                System.out.println("Repeating Number -> " + y);
            }
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
