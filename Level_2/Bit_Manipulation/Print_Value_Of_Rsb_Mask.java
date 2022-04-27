package Level_2.Bit_Manipulation;

import java.util.Scanner;

public class Print_Value_Of_Rsb_Mask {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int rsbm = n & -n;
        System.out.println(Integer.toBinaryString(rsbm));
    }
}
