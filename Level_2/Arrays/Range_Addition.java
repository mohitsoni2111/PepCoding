package Level_2.Arrays;

import java.util.Scanner;

public class Range_Addition {
    public static int[] getModifiedArray(int length, int[][] updates) {
        int[] res = new int[length];
        for (int[] update : updates) {
            int startIndex = update[0];
            int endIndex = update[1];
            int increment = update[2];

            res[startIndex] += increment;
            if (endIndex + 1 < length)
                res[endIndex + 1] -= increment;
        }

        // Prefix Sum Array
        for (int i = 1; i < res.length; i++){
            res[i] += res[i - 1];
        }

        return res;
    }


    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int length = scn.nextInt();
        int nu = scn.nextInt();
        int[][] updates = new int[nu][3];

        for(int u = 0; u < nu; u++) {
            updates[u][0] = scn.nextInt();
            updates[u][1] = scn.nextInt();
            updates[u][2] = scn.nextInt();
        }

        int[] res = getModifiedArray(length, updates);

        for (int re : res) {
            System.out.print(re + " ");
        }
    }
}
