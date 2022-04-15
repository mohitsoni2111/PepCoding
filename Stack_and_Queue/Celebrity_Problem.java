package Stack_and_Queue;

import java.util.Stack;

public class Celebrity_Problem {

    static boolean knows(int[][] matrix, int a, int b){
        return (matrix[a][b] == 1);
    }

    private static int findCelebrity(int[][] matrix, int n) {
        if (n <= 1) return -1;

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++)
            stack.push(i);

        while (stack.size() > 1){
            int i = stack.pop();
            int j = stack.pop();
            if (matrix[i][j] == 1)
                stack.push(j);
            else
                stack.push(i);
        }

        int potential = stack.pop();
        for (int i = 0; i < matrix.length; i++){
            if (i!= potential && matrix[i][potential] == 0 || matrix[potential][i] == 1)
                    return -1;
        }
        return potential;
    }

    // Driver code
    public static void main(String[] args) {
        int[][] matrix = {
                { 0, 0, 1, 0 },
                { 0, 0, 1, 0 },
                { 0, 0, 0, 0 },
                { 0, 0, 1, 0 } };
        int n = 4;
        int id = findCelebrity(matrix, n);
        if (id == -1)
            System.out.print("No celebrity");
        else
            System.out.print("Celebrity ID " + id);
    }
}
