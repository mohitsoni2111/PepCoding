package Level_2.Bit_Manipulation;

import java.util.Scanner;

public class Basics_Of_Bit_Manipulation {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int i = scn.nextInt();
        int j = scn.nextInt();
        int k = scn.nextInt();
        int m = scn.nextInt();

        int onMask = (1 << i);
        int offMask = ~(1 << j);
        int toggleMask = (1 << k);
        int checkMask = (1 << m);

        System.out.println(n | onMask);
        System.out.println(n & offMask);
        System.out.println(n ^ toggleMask);
        System.out.println((n & checkMask) != 0);

    }
}
