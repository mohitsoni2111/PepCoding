package LeetCode.DP;

import java.util.Scanner;

public class Integer_Break_343 {
    static int prod = 1;
    public static int largestSquare(int num){
        return (int)Math.floor(Math.sqrt(num));
    }

    public static int integerBreak(int n) {
        if (n == 2) return 1;

        while(n > 3){
            int num = largestSquare(n);
            prod *= num;
            n -= num;
            if(n == 3 || n == 2){
                prod *= num;
                return prod;
            }
        }
        return prod;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ans = integerBreak(n);
        System.out.println(ans);
    }
}
