package Level_2.Bit_Manipulation;

import java.util.Scanner;

public class Swap_All_Odd_And_Even_Bits {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int oddMask = 0x55555555;
        int evenMask = 0xAAAAAAAA;

        int odds = (n & oddMask);
        int evens = (n & evenMask);

        odds <<= 1;
        evens >>= 1;

        n = odds | evens;

        System.out.println(n);
    }
}
