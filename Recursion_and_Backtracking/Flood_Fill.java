package Recursion_and_Backtracking;

import java.util.Scanner;

public class Flood_Fill {

    private static void floodFill(int[][] maze, int row, int col, String pathSoFar, boolean[][] visited) {
        if (row < 0 || col < 0 || row == maze.length || col == maze[0].length || maze[row][col] == 1 || visited[row][col])
            return;

        if (row == maze.length - 1 && col == maze[0].length - 1){
            System.out.println(pathSoFar);
            return;
        }

        visited[row][col] = true;
        floodFill(maze, row - 1, col, pathSoFar + "t", visited);
        floodFill(maze, row , col - 1, pathSoFar + "l", visited);
        floodFill(maze, row + 1, col, pathSoFar + "d", visited);
        floodFill(maze, row, col + 1, pathSoFar + "r", visited);
        visited[row][col] = false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] maze = new int[n][m];

        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                maze[i][j] = sc.nextInt();
            }
        }
        boolean[][] visited = new boolean[n][m];
        floodFill(maze, 0, 0, "", visited);
    }
}
