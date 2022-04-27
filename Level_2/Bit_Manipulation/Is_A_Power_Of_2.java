package Level_2.Bit_Manipulation;

import java.util.Scanner;

public class Is_A_Power_Of_2 {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int val = (n & (n - 1));
        System.out.println(val == 0);
    }
}
