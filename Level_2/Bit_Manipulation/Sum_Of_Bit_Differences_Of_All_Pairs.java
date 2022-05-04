package Level_2.Bit_Manipulation;

import java.util.Scanner;

public class Sum_Of_Bit_Differences_Of_All_Pairs {
    public static long solution(int[] arr){

        long res = 0;

        for (int i = 0; i < 32; i++){
            int countOn = 0;

            for (int val : arr){
                if ((val & (1 << i)) != 0){
                    countOn++;
                }
            }
            int countOff = arr.length - countOn;
            int diff = countOn * countOff * 2;
            res += diff;
        }
        return res;
    }

    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i < arr.length; i++){
            arr[i] = scn.nextInt();
        }
        System.out.println(solution(arr));
    }
}
