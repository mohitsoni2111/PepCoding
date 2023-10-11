package Level_2.Graphs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;

public class Kahn_Algorithm {

    private static int[] findOrder(ArrayList<ArrayList<Integer>> graph, int n) {
        int[] inDegree = new int[n];
        int[] ans = new int[n];

        for (int i = 0; i < n; i++){
            for (int nbrs : graph.get(i)){
                inDegree[nbrs]++;
            }
        }


        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++){
            if (inDegree[i] == 0){
                queue.addLast(i);
            }
        }

        int idx = 0;
        while (queue.size() > 0){
            int rem = queue.removeFirst();

            ans[idx] = rem;
            idx++;

            for (int nbrs : graph.get(rem)){
                inDegree[nbrs]--;

                if (inDegree[nbrs] == 0){
                    queue.addLast(nbrs);
                }
            }
        }

        if (idx == n) return ans;
        else return new int[]{-1};
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] st = br.readLine().split(" ");
        int n = Integer.parseInt(st[0]);
        int m = Integer.parseInt(st[1]);

        int[][] prereq = new int[m][2];
        for (int i = 0; i < m; i++){
            st = br.readLine().split(" ");
            prereq[i][0] = Integer.parseInt(st[0]);
            prereq[i][1] = Integer.parseInt(st[1]);
        }

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0 ; i < n; i++){
            int u = prereq[i][0];
            int v = prereq[i][1];
            graph.get(u).add(v);
        }
        int[] ans = findOrder(graph, n);
        for (int val : ans){
            System.out.println(val +  " ");
        }
    }
}