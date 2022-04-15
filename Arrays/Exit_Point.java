package Arrays;

public class Exit_Point {

    public static int[] exitPoint(int[][] matrix){
        if(matrix.length==0 || matrix[0].length==0) return new int[0];

        int m = matrix.length;
        int n = matrix[0].length;
//        boolean[][] visited = new boolean[m][n];
        int[] ans = new int[2];

        int dir = 0; // 0 - east, 1 - south, 2 - west, 3 - North
        int i = 0, j = 0, x = 0;

        while (true){
            dir = (dir + matrix[i][j]) % 4;
            if (dir == 0){
                // visited[i][j] = true;
                j++;
            }

            else if (dir == 1){
                // visited[i][j] = true;
                i++;
            }

            else if (dir == 2){
                // visited[i][j] = true;
                j--;
            }

            else if (dir == 3){
                // visited[i][j] = true;
                i--;
            }

            if(i < 0){
                i++;
                break;
            }
            else if(j < 0){
                j++;
                break;
            }
            else if (i == m) {
                i--;
                break;
            }
            else if (j == n){
                j--;
                break;
            }
        }
        // System.out.print(i);
        // System.out.print(j);
        ans[x] = i;
        ans[++x] = j;
        for (int y = 0; y < ans.length; y++)
            System.out.print(ans[y] + " ");
        return ans;
    }


    public static void main(String[] args) {
        int M[][] = {
                {0, 0, 0, 1},
                {0, 1, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 1, 0, 1},
        };
        exitPoint(M);
    }
}
