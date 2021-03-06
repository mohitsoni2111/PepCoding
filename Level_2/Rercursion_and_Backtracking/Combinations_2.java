package Level_2.Rercursion_and_Backtracking;
import java.io.*;
import java.util.*;

public class Combinations_2 {
    public static void combinations(boolean[] boxes, int ci, int ti, int lb){
        if (ci > ti){
            for (boolean box : boxes) {
                if (box) {
                    System.out.print("i");
                } else {
                    System.out.print("-");
                }
            }
            System.out.println();
            return;
        }

        for (int b = lb + 1; b < boxes.length; b++){
            if (!boxes[b]){
                boxes[b] = true;
                combinations(boxes, ci + 1, ti, b);
                boxes[b] = false;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int nboxes = Integer.parseInt(br.readLine());
        int ritems = Integer.parseInt(br.readLine());
        combinations(new boolean[nboxes], 1, ritems, -1);
    }
}
