package Level_2.Dynamic_Programming;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Super_Ugly_Number {
    // O(nk)
    public static int solution1(int[] primes, int n) {
        int[] pointers = new int[primes.length];
        Arrays.fill(pointers, 1);

        int[] dp = new int[n + 1];
        dp[1] = 1;

        for (int i = 2; i <= n; i++){
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < primes.length; j++){
                min = Math.min(min, primes[j] * dp[pointers[j]]);
            }
            dp[i] = min;

            for (int j = 0; j < primes.length; j++){
                if (primes[j] * dp[pointers[j]] == min){
                    pointers[j]++;
                }
            }
        }
        return dp[n];
    }

    // O(nlogk)
    public static class Pair implements Comparable<Pair> {
        int prime;
        int pointer;
        int value;

        public Pair(int prime, int pointer, int value){
            this.prime = prime;
            this.pointer = pointer;
            this.value = value;
        }

        public int compareTo(Pair o){
            return this.value - o.value;
        }
    }
    public static int solution(int[] primes, int n){
        int[] dp = new int[n + 1];
        dp[1] = 1;

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for (int prime : primes) {
            pq.add(new Pair(prime, 1, prime));
        }

        for (int i = 2; i <= n; i++){
            Pair rem = pq.remove();
            if (dp[i - 1] != rem.value){
                dp[i] = rem.value;
                i++;
            }
            pq.add(new Pair(rem.prime, rem.pointer + 1, rem.prime * dp[rem.pointer + 1]));
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int k = scn.nextInt();
        int[] primes = new int[k];
        for (int i = 0 ; i < k; i++) {
            primes[i] = scn.nextInt();
        }
        int n = scn.nextInt();
        System.out.println(solution(primes, n));
    }
}
