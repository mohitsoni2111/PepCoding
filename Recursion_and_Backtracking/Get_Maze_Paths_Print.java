package Recursion_and_Backtracking;

public class Get_Maze_Paths_Print {
    private static void printMazePaths(int sourceRow, int sourceCol, int desRow, int desCol, String path) {
        if (sourceCol > desCol || sourceRow > desRow)
            return;
        if (sourceRow == desRow && sourceCol == desCol){
            System.out.println(path);
            return;
        }

        printMazePaths(sourceRow, sourceCol + 1, desRow, desCol, path + "h");
        printMazePaths(sourceRow + 1, sourceCol, desRow, desCol, path + "v");
    }

    public static void main(String[] args) {
        int sourceRow = 1;
        int sourceCol = 1;
        int desRow = 4;
        int desCol = 5;
        printMazePaths(sourceRow, sourceCol, desRow, desCol, "");
    }
}
