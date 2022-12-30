package Level_2.Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class Sieve_Of_Eratosthenes {
    public static void printPrimeUsingSieve(int n) {
        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);

        for (int i = 2; i*i <= isPrime.length; i++){
            if(isPrime[i]){
                // making multiples not prime
                for (int j = i + 1; j < isPrime.length; j += i){
                    isPrime[j] = false; // not prime
                }
            }
        }

        // print all prime till n
        for (int i = 2; i < isPrime.length; i++){
            if (isPrime[i]){
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        printPrimeUsingSieve(n);
    }
}
