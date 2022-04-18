package Level_2.Rercursion_and_Backtracking;

import java.util.Scanner;

public class Josephus_Problem {

    public static int solution(int n, int k){
        if (n == 1) return 0;

        int x = solution(n - 1, k);

        return (x + k) % n;
    }
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int k = scn.nextInt();
        System.out.println(solution(n,k));
    }
}
