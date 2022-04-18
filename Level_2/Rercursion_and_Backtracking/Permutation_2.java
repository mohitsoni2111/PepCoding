package Level_2.Rercursion_and_Backtracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Permutation_2 {
    public static void permutations(int cb, int tb, int[] items, int ssf, int ts, String asf){

    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int nboxes = Integer.parseInt(br.readLine());
        int ritems = Integer.parseInt(br.readLine());
        permutations(1, nboxes, new int[ritems], 0, ritems, "");
    }
}
