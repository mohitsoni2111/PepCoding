package Level_2.Bit_Manipulation;

import java.util.Scanner;

public class Flip_Bits_To_Convert_A_To_B {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int a = scn.nextInt();
        int b = scn.nextInt();

        int n = a ^ b;

        int count = 0;
        while (n > 0){
            int rsbm = n & - n;
            n -= rsbm;
            count++;
        }
        System.out.println(count);
    }
}
