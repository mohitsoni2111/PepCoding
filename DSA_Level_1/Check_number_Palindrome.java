package DSA_Level_1;

import java.util.Scanner;

public class Check_number_Palindrome {

    private static boolean isPalindrome(int n) {
        if(n < 0) return false;

        int divisor = 1;
        // Find the divisor
        while(n / divisor >= 10)
            divisor *= 10;

        while(n != 0){
            int leading  = n / divisor;
            int trailing = n % 10;

            if(leading != trailing) return false;

            // Removing leading and trailing digits
            n = (n % divisor) / 10;

            // Reducing divisor by a factor of 2 as 2 digits are removed
            divisor = divisor / 100;
        }

        return true;
    }


    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(isPalindrome(n));

    }
}
