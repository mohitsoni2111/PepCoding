package Level_2.Bit_Manipulation;

import java.util.Scanner;

public class Print_Binary_And_Reverse_Bits {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        boolean flag = false;
        int rev = 0;
        int j = 0;
        for (int i = 31; i >= 0; i--){
            int mask = (1 << i);
            if (flag){
                if ((n & mask) == 0){
                    System.out.print(1);

                    int setMask = (1 << j);
                    rev |= setMask;
                } else {
                    System.out.print(0);
                }
                j++;
            } else {
                if ((n & mask) == 0){
                    flag = true;
                    System.out.print(1);

                    int setMask = (1 << j);
                    rev |= setMask;
                    j++;
                }
            }
        }
        System.out.println();
        System.out.println(rev);
    }
}
