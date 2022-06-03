package Level_2.Graphs;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;

public class Sliding_Puzzle {
    private static String swapChar(String str, int i, int j) {
        StringBuilder sb = new StringBuilder(str);
        sb.setCharAt(i, sb.charAt(j));
        sb.setCharAt(j, sb.charAt(i));

        return sb.toString();
    }
    public static int slidingPuzzle(int[][] board) {

        LinkedList<String> queue = new LinkedList<>();
        String target = "123450";

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[0].length; j++){
                sb.append(board[i][j]);
            }
        }
        String initial = sb.toString();

        int[][] swapIndex = {{1,3}, {0,2,4}, {1,5}, {0,4}, {1,3,5}, {2,4}};

        queue.addLast(initial);
        int level = 0;
        HashSet<String> visited = new HashSet<>();

        while (queue.size() > 0){
            int size = queue.size();

            while (size-- > 0) {
                String rem = queue.removeFirst();

                if (rem.equals(target)){
                    return level;
                }

                // Finding index of '0'
                int index = -1;
                for (int i = 0; i < rem.length(); i++){
                    if (rem.charAt(i) == '0'){
                        index = i;
                        break;
                    }
                }

                int[] swap = swapIndex[index];
                for (int i = 0; i < swap.length; i++){
                    String newString = swapChar(rem, index, swap[i]);
                    if (visited.contains(newString)){
                        continue;
                    }
                    queue.addLast(newString);
                    visited.add(newString);
                }
            }
            level++;
        }
        return -1;
    }
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] arr = new int[2][3];

        for (int i = 0; i < 2; i++) {
            String[] st = br.readLine().split(" ");
            for (int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(st[j]);
            }
        }

        System.out.println(slidingPuzzle(arr));
    }
}
