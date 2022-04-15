package Recursion_and_Backtracking;

import java.util.Scanner;

public class Knights_Tour {

    private static void knightsTour(int[][] chess, int row, int col, int move) {
        if (row < 0 || col < 0 || row >= chess.length || col >= chess[0].length || chess[row][col] > 0)
            return;
        else if (move == chess.length){
            chess[row][col] = move;
            displayBoard(chess);
            chess[row][col] = 0;
            return;
        }

        chess[row][col] = move;
        knightsTour(chess, row - 2, col + 1, move + 1);
        knightsTour(chess, row - 1, col + 2, move + 1);
        knightsTour(chess, row + 1, col + 2, move + 1);
        knightsTour(chess, row + 2, col + 1, move + 1);
        knightsTour(chess, row + 2, col - 1, move + 1);
        knightsTour(chess, row + 1, col - 2, move + 1);
        knightsTour(chess, row - 1, col - 2, move + 1);
        knightsTour(chess, row - 2, col - 1, move + 1);
        chess[row][col] = 0;
    }

    private static void displayBoard(int[][] chess) {
        for (int i = 0; i < chess.length; i++){
            for (int j = 0; j <chess[0].length; j++){
                System.out.print(chess[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] chess = new int[n][n];
        int row = sc.nextInt();
        int col = sc.nextInt();
        knightsTour(chess, row, col, 1);
    }
}
