package Level_2.Rercursion_and_Backtracking;
import java.io.*;
import java.util.*;

public class Queens_Combinations_2d_As_2d_Box_Chooses {
    public static void queensCombinations(int qpsf, int tq, int row, int col, String asf){
        if (row == tq){
            if (qpsf == tq) {
                System.out.println(asf);
            }
            return;
        }

        int newRow = 0;
        int newColumn = 0;
        String yasf = "";
        String nasf = "";

        if (col == tq - 1){
            newRow = row + 1;
            newColumn = 0;
            yasf = asf + "q\n";
            nasf = asf + "-\n";
        } else {
            newRow = row;
            newColumn = col + 1;
            yasf = asf + "q";
            nasf = asf + "-";
        }

        queensCombinations(qpsf, tq, newRow, newColumn, asf + yasf);
        queensCombinations(qpsf, tq, newRow, newColumn, asf + nasf);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        queensCombinations(0, n, 0, 0, "");
    }
}
