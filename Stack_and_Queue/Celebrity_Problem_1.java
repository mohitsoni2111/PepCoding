package Stack_and_Queue;

public class Celebrity_Problem_1 {

    private static int findCelebrityPointer(int[][] matrix, int n) {
        int i = 0, j = n - 1;
        while (i < j){
            if (matrix[i][j] == 1)  // j knows i
                j--;
            else                    // j doesn't know i so i can't be celebrity
                i++;
        }

        // i points to celebrity candidate
        int candidate = i;

        for (i = 0; i < n; i++){
            if (i != candidate && matrix[i][candidate] == 0 || matrix[candidate][i] == 1)
                return -1;
        }
        return candidate;
    }

    // Driver code
    public static void main(String[] args) {
        int[][] matrix = {
                { 0, 0, 1, 0 },
                { 0, 0, 1, 0 },
                { 0, 0, 0, 0 },
                { 0, 0, 1, 0 } };
        int n = 4;
        int id = findCelebrityPointer(matrix, n);
        if (id == -1)
            System.out.print("No celebrity");
        else
            System.out.print("Celebrity ID " + id);
    }
}
