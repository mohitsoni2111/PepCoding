package Level_2.Bit_Manipulation;

import java.util.Scanner;

public class Solve_7n_By_8 {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        System.out.println(((n << 3) - n) >> 3);    // (8n - n)/8
    }
}
