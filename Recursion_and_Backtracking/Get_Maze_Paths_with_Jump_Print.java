package Recursion_and_Backtracking;

public class Get_Maze_Paths_with_Jump_Print {
    private static void printMazePathsWithJump(int sourceRow, int sourceCol, int desRow, int desCol, String path) {
        if (sourceCol == desCol && sourceRow == desRow){
            System.out.println(path);
            return;
        }

        for (int moveSize = 0; moveSize <= desCol - sourceCol; moveSize++){
            printMazePathsWithJump(sourceRow, sourceCol + moveSize, desRow, desCol, path + "h" + moveSize);
        }
        for (int moveSize = 0; moveSize <= desRow - sourceRow; moveSize++){
            printMazePathsWithJump(sourceRow + moveSize, sourceCol, desRow, desCol, path + "v" + moveSize);
        }
        for (int moveSize = 0; moveSize <= desCol - sourceCol && moveSize <= desRow - sourceRow; moveSize++){
            printMazePathsWithJump(sourceRow + moveSize, sourceCol + moveSize, desRow, desCol, path + "d" + moveSize);
        }
    }

    public static void main(String[] args) {
        int sourceRow = 1;
        int sourceCol = 1;
        int desRow = 4;
        int desCol = 5;
        printMazePathsWithJump(sourceRow, sourceCol, desRow, desCol, "");
    }

}
