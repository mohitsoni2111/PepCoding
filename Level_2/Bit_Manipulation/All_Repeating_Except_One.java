package Level_2.Bit_Manipulation;

import java.util.Scanner;

public class All_Repeating_Except_One {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i < n; i++){
            arr[i] = scn.nextInt();
        }

        int uni = 0;
        for (int val : arr){
            uni = uni ^ val;
        }
        System.out.println(uni);
    }
}
