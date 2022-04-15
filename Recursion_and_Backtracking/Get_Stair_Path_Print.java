package Recursion_and_Backtracking;

public class Get_Stair_Path_Print {

    private static void printStairPaths(int n, String path) {
        if (n < 0)
            return;
        if (n == 0){
            System.out.println(path);
            return;
        }

        printStairPaths(n - 1, path + "1");
        printStairPaths(n - 2, path + "2");
        printStairPaths(n - 3, path + "3");
    }

    public static void main(String[] args) {
        int n = 4;
        printStairPaths(n, "");
    }
}
