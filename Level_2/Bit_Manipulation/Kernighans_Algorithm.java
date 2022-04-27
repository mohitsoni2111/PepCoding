package Level_2.Bit_Manipulation;

import java.util.Scanner;

public class Kernighans_Algorithm {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int count = 0;
        while (n != 0){
            int rsbm = n & -n;
            n -= rsbm;
            count++;
        }

        System.out.println(count);
    }
}
