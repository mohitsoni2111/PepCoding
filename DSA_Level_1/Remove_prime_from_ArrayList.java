package DSA_Level_1;

import java.util.ArrayList;
import java.util.Scanner;

public class Remove_prime_from_ArrayList {

    public static boolean isPrime(int n){
        if( n <= 1) return false;
        if( n <= 3) return true;
        if( n%2 == 0 || n%3 ==0) return false;

        for (int i = 5; i <= Math.sqrt(n); i += 6){
            if( n % i == 0 || n % (i+2) == 0) return false;
        }
        return true;
    }

    public static int[] removePrime(int[] arr) {

        return null;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = {1,2,3,4,5,6,7,8,9,12,34,56,76,89};

        removePrime(arr);
    }
}
