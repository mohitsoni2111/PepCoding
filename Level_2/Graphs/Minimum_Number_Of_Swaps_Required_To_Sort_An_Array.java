package Level_2.Graphs;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Minimum_Number_Of_Swaps_Required_To_Sort_An_Array {
    private static class Pair implements Comparable<Pair> {
        int value;
        int index;

        Pair(int value, int index) {
            this.value = value;
            this.index = index;
        }

        @Override
        public int compareTo(Pair o) {
            return this.value - o.value;
        }
    }   // Value, Index
    public static int minSwaps(int[] arr1) {
        int n = arr1.length;
        Pair[] arr = new Pair[n];

        for (int i = 0; i < n; i++){
            arr[i] = new Pair(arr1[i], i);
        }
        Arrays.sort(arr);

        int ans = 0;
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++){
            if (visited[i] || arr[i].index == i){
                continue;
            }

            int length = 0;
            int j = i;
            while (!visited[j]){
                visited[j] = true;
                length++;
                j = arr[j].index;
            }
            ans += length - 1;
        }

        return ans;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        String[] st = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st[i]);
        }

        System.out.println(minSwaps(arr));
    }
}
