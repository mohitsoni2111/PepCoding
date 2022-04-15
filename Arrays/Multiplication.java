package Arrays;

public class Multiplication {

    static void printMatrix(int[][] C){
        for (int i=0; i < C.length; i++){
            for (int j = 0; j < C[0].length; j++){
                System.out.print(C[i][j]);
            }
            System.out.println();
        }
    }

    static void multiplyMatrix(int A[][], int B[][]){
        int rowA = A.length;
        int colA = A[0].length;
        int rowB = B.length;
        int colB = B[0].length;
        int i, j ,k;

        // Check if multiplication is possible or not
        if(colA != rowB)
            return;

        int C[][] = new int[rowA][colB];

        for(i = 0; i < rowA; i++){
            for (j=0; j < colB; j++){
                for (k=0; k < rowB; k++){
                    C[i][j] = A[i][k] * B[k][j];
                }
            }
        }

        printMatrix(C);


    }

    public static void main(String[] args) {
        int row1 = 4, col1 = 3, row2 = 3, col2 = 4;
        int A[][] = { { 1, 1, 1 },
                { 2, 2, 2 },
                { 3, 3, 3 },
                { 4, 4, 4 } };

        int B[][] = { { 1, 1, 1, 1 },
                { 2, 2, 2, 2 },
                { 3, 3, 3, 3 } };

        multiplyMatrix(A, B);
    }
}
