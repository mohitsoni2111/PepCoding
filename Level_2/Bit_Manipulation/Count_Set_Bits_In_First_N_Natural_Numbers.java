package Level_2.Bit_Manipulation;

import java.util.Scanner;

public class Count_Set_Bits_In_First_N_Natural_Numbers {

    public static int largestPowerOf2InRange(int n){
        int x = 0;
        while ((1 << x) <= n)
            x++;
        return x - 1;
    }

    public static int solution(int n){
        if (n == 0)
            return 0;

        int x = largestPowerOf2InRange(n);
        int bitsUpto2RaiseX = x * (1 << (x - 1));
        int msbFrom2xtoN = n - (1 << x) + 1;
        int rest = n - (1 << x);
        return bitsUpto2RaiseX + msbFrom2xtoN + solution(rest);
    }
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        System.out.println(solution(n));
    }
}
