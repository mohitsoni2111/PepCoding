package Level_2.Rercursion_and_Backtracking;

import java.util.Scanner;

public class Lexicographical_Numbers {

    private static void printLexico(int n) {
        for (int i = 1; i <= 9; i++)
            dfs(i, n);
    }

    private static void dfs(int i, int n) {
        if (i > n) return;

        System.out.println(i);
        for (int j = 0; j < 10; j++)
            dfs((10 * i) + j, n);
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        printLexico(n);
    }
}
