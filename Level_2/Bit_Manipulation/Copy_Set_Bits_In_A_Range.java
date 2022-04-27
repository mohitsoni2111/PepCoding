package Level_2.Bit_Manipulation;

import java.util.Scanner;

public class Copy_Set_Bits_In_A_Range {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int a = scn.nextInt();
        int b = scn.nextInt();
        int left = scn.nextInt();
        int right = scn.nextInt();

        int bits = right - left + 1;
        int interMask = (1 << bits) - 1;
        int mask = (interMask << (left - 1));

        mask = a & mask;
        int result = b | mask;
        System.out.println(result);
    }
}
