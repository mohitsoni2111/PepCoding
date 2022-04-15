package Recursion_and_Backtracking;

import java.util.ArrayList;

public class Get_Maze_Paths {
    private static ArrayList<String> getMazePaths(int sourceRow, int sourceCol, int desRow, int desCol) {
        if (sourceCol == desCol && sourceRow == desRow){
            ArrayList<String> bres = new ArrayList<>();
            bres.add("");
            return bres;
        }

        ArrayList<String> horizontalPaths = new ArrayList<>();
        ArrayList<String> verticalPaths = new ArrayList<>();

        if ( sourceCol < desCol){
            horizontalPaths = getMazePaths(sourceRow, sourceCol+1, desRow, desCol);
        }
        if (sourceRow < desRow){
            verticalPaths = getMazePaths(sourceRow+1, sourceCol, desRow, desCol);
        }

        ArrayList<String> paths = new ArrayList<>();

        for (String hpath  : horizontalPaths){
            paths.add("h" + hpath);
        }
        for (String vpath  : verticalPaths){
            paths.add("v" + vpath);
        }

        return paths;
    }

    public static void main(String[] args) {
        int sourceRow = 1;
        int sourceCol = 1;
        int desRow = 4;
        int desCol = 5;
        System.out.println(getMazePaths(sourceRow, sourceCol, desRow, desCol));
    }
}
