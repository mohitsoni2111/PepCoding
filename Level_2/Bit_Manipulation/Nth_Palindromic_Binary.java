package Level_2.Bit_Manipulation;

import java.util.Scanner;

public class Nth_Palindromic_Binary {
    private static int getRev(int n) {
        int rev = 0;
        while (n != 0){
            int lowestBit = (n & 1);
            rev |= lowestBit;
            rev <<= 1;
            n >>= 1;
        }
        rev >>= 1;

        return rev;
    }
    public static int NthPalindromicBinary(int n) {
        int count = 1;
        int len = 1;

        while (count < n){
            len++;
            count += (1 << (len-1) / 2);
        }
        count -= (1 << (len-1) / 2);
        int offset = n - count - 1;

        int ans = (1 << (len - 1));
        ans |= (offset << (len / 2));
        int valReverse = (ans >> (len / 2));
        int rev = getRev(valReverse);
        ans |= rev;
        return ans;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        System.out.println(NthPalindromicBinary(n));
    }
}
