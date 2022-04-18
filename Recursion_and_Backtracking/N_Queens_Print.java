package Recursion_and_Backtracking;

import java.util.Scanner;

public class N_Queens_Print {

    private static boolean isSafeLocation(int[][] chess, int row, int col) {
        for (int i = row - 1, j = col; i >= 0; i--){        // Check up
            if (chess[i][j] == 1)
                return false;
        }
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--){     // Check left diagonal
            if (chess[i][j] == 1)
                return false;
        }
        for (int i = row - 1, j = col + 1; i >= 0 && j < chess.length; i--, j++){       // Check right diagonal
            if (chess[i][j] == 1)
                return false;
        }
        return true;
    }

    private static void printNQueens(int[][] chess, String queenSoFar, int row) {    // row are level of tree
        if (row == chess.length){
            System.out.println(queenSoFar);
            return;
        }

        for (int col = 0; col < chess[0].length; col++){        // col are options in each level
            if(isSafeLocation(chess, row, col)) {
                chess[row][col] = 1;
                printNQueens(chess, queenSoFar + row + "-" + col + ",", row + 1);
                chess[row][col] = 0;
            }
        }
    }


    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] chess = new int[n][n];
        printNQueens(chess, "", 0);
    }

}
