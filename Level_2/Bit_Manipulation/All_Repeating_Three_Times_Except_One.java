package Level_2.Bit_Manipulation;

import java.util.Scanner;

public class All_Repeating_Three_Times_Except_One {
    public static void solution(int[] arr){

        int threeN = Integer.MAX_VALUE, threeNPlusOne = 0, threeNPlusTwo = 0;

        for (int i = 0; i < arr.length; i++){
            int commonWithThreeN = arr[i] & threeN;
            int commonWithThreeNPlusOne = arr[i] & threeNPlusOne;
            int commonWithThreeNPlusTwo = arr[i] & threeNPlusTwo;

            threeN = threeN & (~commonWithThreeN);
            threeNPlusOne = threeNPlusOne | commonWithThreeN;

            threeNPlusOne = threeNPlusOne & (~commonWithThreeNPlusOne);
            threeNPlusTwo = threeNPlusTwo | commonWithThreeNPlusOne;

            threeNPlusTwo = threeNPlusTwo & (~commonWithThreeNPlusTwo);
            threeN = threeN | commonWithThreeNPlusTwo;

        }
        System.out.println(threeNPlusOne);
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
