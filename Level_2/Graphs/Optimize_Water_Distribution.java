package Level_2.Graphs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Optimize_Water_Distribution {
    public static class Pair implements Comparable<Pair> {
        int vertex;
        int wt;

        Pair(int vertex, int wt) {
            this.vertex = vertex;
            this.wt = wt;
        }

        @Override
        public int compareTo(Pair o) {
            return this.wt - o.wt;
        }
    }   // nbr, weight
    // Some test cases were failing
    public static int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
        ArrayList<ArrayList<Pair>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++){
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < pipes.length; i++){
            int u = pipes[i][0];
            int v = pipes[i][1];
            int wt = pipes[i][2];

            graph.get(u).add(new Pair(v, wt));
            graph.get(v).add(new Pair(u, wt));
        }

        for (int i = 1; i < wells.length; i++){
            graph.get(i).add(new Pair(0, wells[i-1]));
            graph.get(0).add(new Pair(i, wells[i-1]));
        }

        // MST
        int ans = 0;
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(0, 0));
        boolean[] visited = new boolean[n+1];
        while (pq.size() > 0){
            Pair rem = pq.remove();
            if (visited[rem.vertex]){
                continue;
            }
            ans += rem.wt;
            visited[rem.vertex] = true;

            ArrayList<Pair> nbrs = graph.get(rem.vertex);
            for (Pair nbr : nbrs){
                if (!visited[nbr.vertex]){
                    pq.add(nbr);
                }
            }

        }

        return ans;
    }

    // Leetcode similar approach
    int[] uf;
    public int minCostToSupplyWater2(int n, int[] wells, int[][] pipes) {
        uf = new int[n + 1];
        List<int[]> edges = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            uf[i + 1] = i + 1;
            edges.add(new int[] {0, i + 1, wells[i]});
        }
        for (int[] p : pipes) {
            edges.add(p);
        }
        // Same as above
        // edges.addAll(Arrays.asList(pipes));

        Collections.sort(edges, (a, b) -> Integer.compare(a[2], b[2]));
        // Same as above
        // edges.sort((a, b) -> Integer.compare(a[2], b[2]));

        int res = 0;
        for (int[] e : edges) {
            int x = find(e[0]);
            int y = find(e[1]);
            if (x != y) {
                res += e[2];
                uf[x] = y;
                --n;
            }
        }
        return res;
    }

    private int find(int x) {
        if (x != uf[x])
            uf[x] = find(uf[x]);
        return uf[x];
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] st = br.readLine().split(" ");
        int v = Integer.parseInt(st[0]);
        int e = Integer.parseInt(st[1]);

        int[] wells = new int[v];
        String[] words = br.readLine().split(" ");

        for (int i = 0; i < wells.length; i++) {
            wells[i] = Integer.parseInt(words[i]);
        }

        int[][] pipes = new int[e][3];
        for (int i = 0; i < e; i++) {
            String[] st1 = br.readLine().split(" ");
            pipes[i][0] = Integer.parseInt(st1[0]);
            pipes[i][1] = Integer.parseInt(st1[1]);
            pipes[i][2] = Integer.parseInt(st1[2]);

        }

        System.out.println(minCostToSupplyWater(v, wells, pipes));

    }
}
