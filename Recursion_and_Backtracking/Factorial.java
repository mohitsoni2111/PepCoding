package Recursion_and_Backtracking;

import java.util.Scanner;

public class Factorial {
    private static int factorial(int n) {
        if(n == 0)
            return 1;
        return n * factorial(n-1);
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(factorial(n));
    }
}
