package Level_2.Arrays;

import java.util.ArrayList;
import java.util.Scanner;

public class Best_Meeting_Point {
    public static int minTotalDistance(int[][] grid) {
        // 1. Get x coordinates by row wise traversal
        ArrayList<Integer> xcord = new ArrayList<>();
        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[0].length; j++){
                if (grid[i][j] == 1){
                    xcord.add(i);
                }
            }
        }

        // 2. Get y coordinates by col wise traversal
        ArrayList<Integer> ycord = new ArrayList<>();
        for (int j = 0; j < grid[0].length; j++){
            for (int i = 0; i < grid.length; i++){
                if (grid[i][j] == 1){
                    ycord.add(j);
                }
            }
        }

        // 3. Get median values of x and y
        int x = xcord.get(xcord.size() / 2);
        int y = ycord.get(ycord.size() / 2);

        // 4. Calculate distance -> min(bcoz, median)
        int dist = 0;
        for (int xval : xcord){
            dist += Math.abs(x - xval);
        }

        for (int yval : ycord){
            dist += Math.abs(y - yval);
        }

        // 5. Return ans
        return dist;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();


        int[][] grid = new int[n][m];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                grid[i][j] = scn.nextInt();
            }
        }

        int dist = minTotalDistance(grid);
        System.out.println(dist);
    }
}
