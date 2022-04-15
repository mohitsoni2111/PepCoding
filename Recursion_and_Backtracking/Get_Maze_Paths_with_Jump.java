package Recursion_and_Backtracking;

import java.util.ArrayList;

public class Get_Maze_Paths_with_Jump {
    private static ArrayList<String> getMazePathsWithJump(int sourceRow, int sourceCol, int desRow, int desCol) {
        if (sourceRow == desRow && sourceCol == desCol){
            ArrayList<String> bres = new ArrayList<>();
            bres.add("");
            return bres;
        }

        ArrayList<String> paths = new ArrayList<>();

        // Horizontal moves
        for (int moveSize = 1; moveSize <= desCol - sourceCol; moveSize++){
           ArrayList<String> hpaths = getMazePathsWithJump(sourceRow, sourceCol + moveSize, desRow, desCol);
           for (String hpath : hpaths){
               paths.add("h" + moveSize + hpath);
           }
        }

        // Vertical moves
        for (int moveSize = 1; moveSize <=desRow - sourceRow; moveSize++){
            ArrayList<String> vpaths = getMazePathsWithJump(sourceRow + moveSize, sourceCol, desRow, desCol);
            for (String vpath : vpaths){
                paths.add("v" + moveSize + vpath);
            }
        }

        // Diagonal moves
        for (int moveSize = 1; (moveSize <= (desRow - sourceRow)) && (moveSize <= (desCol - sourceCol)); moveSize++){
            ArrayList<String> dpaths = getMazePathsWithJump(sourceRow + moveSize, sourceCol+ moveSize, desRow, desCol);
            for (String dpath : dpaths){
                paths.add("d" + moveSize + dpath);
            }
        }
        return paths;
    }

    public static void main(String[] args) {
        int sourceRow = 1;
        int sourceCol = 1;
        int desRow = 4;
        int desCol = 5;
        System.out.println(getMazePathsWithJump(sourceRow, sourceCol, desRow, desCol));
    }
}
