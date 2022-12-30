package Level_2.Arrays;

import java.util.ArrayList;
import java.util.Scanner;

public class Segmented_Sieve {
    public static ArrayList<Integer> sieve(int num){
        boolean[] arr = new boolean[num + 1];   // False -> prime, True -> Not prime

        for (int i = 2; i*i <= arr.length; i++){
            if (!arr[i]){
                for (int j = 2 * i; j < arr.length; j += i){
                    arr[j] = true;
                }
            }
        }
        ArrayList<Integer> res = new ArrayList<>();

        for (int i = 2; i < arr.length; i++){
            if (!arr[i]){
                res.add(i);
            }
        }
        return res;
    }
    public static void segmentedSieveAlgo(int a, int b) {
        // 1. Make root of b
        int rootB = (int) Math.sqrt(b);
        boolean[] arr = new boolean[b - a + 1]; // False -> prime, True -> Not prime

        // 2. Get primes till b using sieve
        ArrayList<Integer> primes = sieve(rootB);

        // 3. Marking using prime
        for (int prime : primes){
            // Find starting index for marking
            int multiple = (int) Math.ceil((a * 1.0) / prime);
            if (multiple == 1)
                multiple++;     // Case when n = 2

            int index = multiple * prime - a;

            for (int j = index; j < arr.length; j += prime){
                arr[j] = true;  // not prime
            }
        }

        for (int i = 0; i < arr.length; i++){
            if (!arr[i] && i + a != 1){
                int val = i + a;
                System.out.println(val);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int a = scn.nextInt();
        int b = scn.nextInt();
        segmentedSieveAlgo(a, b);
    }
}
