package Dynamic_Programming;

import java.util.Scanner;

public class Count_Binary_Strings {

    //Method 2
    private static int countBinaryStrings(int n) {
        int OldCountZeros = 1;
        int OldCountOnes = 1;

        for (int i = 2; i <= n; i++){
            int newCountZeros = OldCountOnes;
            int newCountOnes = OldCountZeros + OldCountOnes;
            OldCountZeros = newCountZeros;
            OldCountOnes = newCountOnes;
        }
        return OldCountZeros + OldCountOnes;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int ans = countBinaryStrings(n);
        System.out.println(ans);

        // Method 1
        int[] dp0 = new int[n + 1];
        int[] dp1 = new int[n + 1];
        dp0[1] = 1;
        dp1[1] = 1;

        for (int i = 2; i <= n; i++){
            dp1[i] = dp1[i - 1] + dp0[i - 1];
            dp0[i] = dp1[i - 1];
        }
        System.out.println(dp0[n] + dp1[n]);
    }
}
