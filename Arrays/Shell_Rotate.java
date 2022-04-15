package Arrays;

public class Shell_Rotate {

    private static void reverse(int[] one_d_array, int left, int right) {
        if (left > right) return;

        while (left <= right){
            int temp = one_d_array[left];
            one_d_array[left] = one_d_array[right];
            one_d_array[right] = temp;
        }
    }

    private static void rotate1D(int[] one_d_array, int rotateBy) {
        int size = one_d_array.length;
        int rotate = ((rotateBy % size) + size) % size;

        reverse(one_d_array, 0, size-rotate-1);
        reverse(one_d_array, size-rotate, size-1);
        reverse(one_d_array, 0, size - 1);
    }

    private static int[] fillOneDArrayFromShell(int[][] arr, int shell) {
        int minRow = shell - 1;
        int minCol = shell - 1;
        int maxRow = arr.length - shell;
        int maxCol = arr[0].length - shell;
        int size = 2*(maxRow - minRow + 1) + 2*(maxCol - minCol + 1) - 4;   // 2*leftWall + 2*bottomWall - 4 (corners);
        int[] one_D_Array = new int[size];
        int x = 0;

        // Left wall
        for (int i = minRow, j = minCol; i <= maxRow; i++){
            one_D_Array[x++] = arr[i][j];
        }
        // Bottom wall
        for (int j = minCol + 1, i = minRow; j <= maxCol; j++){
            one_D_Array[x++] = arr[i][j];
        }
        // Right wall
        for (int i = maxRow - 1, j = maxCol; i >= minRow; i--){
            one_D_Array[x++] = arr[i][j];
        }
        // Up Wall
        for (int j = maxCol - 1, i = minRow; j >= minCol +1; j--){
            one_D_Array[x++] = arr[i][j];
        }
        return one_D_Array;
    }

    private static void fillShellFromOneDArray(int[][] arr, int shell, int[] one_D_Array) {
        int minRow = shell - 1;
        int minCol = shell - 1;
        int maxRow = arr.length - shell;
        int maxCol = arr[0].length - shell;
        int x = 0;

        // Left wall
        for (int i = minRow, j = minCol; i <= maxRow; i++){
             arr[i][j] = one_D_Array[x++];
        }
        // Bottom wall
        for (int j = minCol + 1, i = minRow; j <= maxCol; j++){
            arr[i][j] = one_D_Array[x++];
        }
        // Right wall
        for (int i = maxRow - 1, j = maxCol; i >= minRow; i--){
            arr[i][j] = one_D_Array[x++];
        }
        // Up Wall
        for (int j = maxCol - 1, i = minRow; j >= minCol +1; j--){
            arr[i][j] = one_D_Array[x++];
        }
    }

    // Get shell elements into 1D array - > Rotate - > Give Back
    private static int[][] shellRotate(int[][] arr, int shell, int rotateBy) {
        if(arr.length==0 || arr[0].length==0 || shell==0 || shell==0)
            return new int[0][];

        int [] one_D_Array = fillOneDArrayFromShell(arr, shell);
        rotate1D(one_D_Array, rotateBy);
        fillShellFromOneDArray(arr, shell, one_D_Array);

        return arr;
    }

    public static void main(String[] args) {
        int arr[][] = { { 1, 5, 19, 1, 2, 7},
                        { 2, 6, 10, 3, 4, 0},
                        { 3, 7, 11, 5, 6, 8},
                        { 4, 8, 12, 7, 8, 9},
                        { 2, 6, 10, 3, 4, 6},
                        { 1, 5, 19, 1, 2, 7},
        };
        shellRotate(arr, 3, 5);
    }
}
