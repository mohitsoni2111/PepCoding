package Level_2.Rercursion_and_Backtracking;

import java.util.Scanner;

public class N_Queens_Branch_and_Bound {

    private static void solve(boolean[][] board, int row, boolean[] columns, boolean[] ndiag, boolean[] rdiag, String asf) {
        if (row == board.length){
            System.out.println(asf + ".");
            return;
        }

        for (int col = 0; col < board[0].length; col++){
            if (!columns[col] && !ndiag[row + col] && !rdiag[row - col + board.length - 1]){
                board[row][col] = true;
                columns[col] = true;
                ndiag[row + col] = true;
                rdiag[row - col + board.length - 1] = true;
                solve(board, row + 1, columns, ndiag, rdiag, asf + row + "-" + col + ", ");
                board[row][col] = false;
                columns[col] = false;
                ndiag[row + col] = false;
                rdiag[row - col + board.length - 1] = false;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        boolean[][] board = new boolean[n][n];

        boolean[] columns = new boolean[n];
        boolean[] ndiag = new boolean[2 * n - 1];
        boolean[] rdiag = new boolean[2 * n - 1];
        solve(board, 0, columns, ndiag, rdiag, "");
    }
}
