package Level_2.Rercursion_and_Backtracking;
import java.io.*;
import java.util.*;

public class Queens_Permutations_2d_As_2d_Box_Chooses {
    public static void queensPermutations(int qpsf, int tq, int row, int col, String asf, boolean[] queens) {
        if (row == tq){
            if (qpsf == tq) {
                System.out.println(asf);
                System.out.println();
            }
            return;
        }

        int newRow = 0;
        int newColumn = 0;
        char sep = '\0';

        if (col == tq - 1){
            newRow = row + 1;
            newColumn = 0;
            sep = '\n';
        }
        else {
            newRow = row;
            newColumn = col + 1;
            sep = '\t';
        }

        for (int i = 0 ; i < queens.length; i++){
            if (!queens[i]){
                queens[i] = true;
                queensPermutations(qpsf + 1, tq, newRow, newColumn, asf + "q" + (i + 1) + sep, queens);
                queens[i] = false;
            }
        }
        queensPermutations(qpsf + 1, tq, newRow, newColumn, asf + "-" + sep, queens);

    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[] queens = new boolean[n];

        queensPermutations(0, n, 0, 0, "", queens);
    }
}
