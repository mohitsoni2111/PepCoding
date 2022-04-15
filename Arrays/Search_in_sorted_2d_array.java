package Arrays;

public class Search_in_sorted_2d_array {

    private static int[] binarySearch(int[][] matrix, int midRow, int element) {
        int left = 0;
        int right = matrix[0].length - 1;
        int midCol;

        int[] ans = new int[2];

        while (left <= right){
            midCol = left + (right - left)/2;

            if (matrix[midRow][midCol] == element){
                ans[0] = midRow;
                ans[1] = midCol;
                return ans;
            }
            if (matrix[midRow][midCol] > element)
                right = midCol - 1;
            if (matrix[midRow][midCol] < element)
                left = midCol + 1;
        }
        return null;

    }
    private static int[] findElement(int[][] matrix, int element) {
        if(matrix.length==0 || matrix[0].length==0) return null;

        int left = 0;
        int right = matrix[0].length - 1;
        int mid;

        int[] ans = new int[2];

        while (left <= right){
            mid = left + (right - left)/2;

            // Left Extreme of mid
            if (matrix[mid][0] == element){
                ans[0] = 0;
                ans[1] = mid;
                return ans;
            }
            // Right extreme of mid
            if (matrix[mid][matrix[0].length - 1] == element){
                ans[0] = mid;
                ans[1] = matrix[0].length - 1;
                return ans;
            }
            // In between
            if (element > matrix[mid][0] && element < matrix[mid+1][matrix[0].length - 1]){
                int[] a;
                a = binarySearch(matrix, mid, element);
                if(a == null) return null;
                else{
                    for(int b = 0; b < a.length; b++)
                        ans[b] = a[b];
                }
            }
            if (element < matrix[mid][0])
                right = mid - 1;
            if (element > matrix[mid][matrix[0].length - 1])
                left = mid + 1;
        }
        return ans;
    }

    // Driver method
    public static void main(String[] args) {
        int matrix[][] = { { 0, 6, 8, 9, 11 },
                { 20, 22, 28, 29, 31 },
                { 36, 38, 50, 61, 63 },
                { 64, 66, 100, 122, 128 } };

        int element = 5;
        int[] ans = findElement(matrix, element);
        for (int i = 0; i < ans.length; i++)
            System.out.print(ans[i]+ " ");
    }
}
