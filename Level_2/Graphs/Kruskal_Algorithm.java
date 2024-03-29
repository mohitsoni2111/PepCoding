package Level_2.Graphs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Kruskal_Algorithm {
    private static int[] parent;
    private static int[] rank;
    public static class Pair implements Comparable<Pair> {
        int u;
        int v;
        int wt;

        Pair(int u, int v, int wt) {
            this.u = u;
            this.v = v;
            this.wt = wt;
        }

        @Override
        public int compareTo(Pair o) {
            return this.wt - o.wt;
        }
    }   // u, v, weight
    public static int find(int a){
        if (parent[a] == a){
            return a;
        }
        int temp = find(parent[a]);
        parent[a] = temp;
        return temp;
    }
    public static boolean union(int x, int y){
        int lx = find(x);
        int ly = find(y);

        if (lx != ly){
            if (rank[lx] > rank[ly]){
                parent[ly] = lx;
            } else if (rank[lx] < rank[ly]) {
                parent[lx] = ly;
            } else {
                parent[lx] = ly;
                rank[ly]++;
            }
            return true;
        }
        return false;
    }
    public static int minCostToSupplyWater(int n, int[][] edges) {
        Pair[] arr = new Pair[edges.length];
        for (int i = 0; i < edges.length; i++){
            arr[i] = new Pair(edges[i][0], edges[i][1], edges[i][2]);
        }

        Arrays.sort(arr);

        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++){
            parent[i] = i;
            rank[i] = 1;
        }

        int ans = 0;
        for (int i = 0; i < arr.length; i++){
            boolean flag = union(arr[i].u, arr[i].v);
            if (flag){
                ans += arr[i].wt;
            }
        }

        return ans;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int v = Integer.parseInt(br.readLine());
        int e = Integer.parseInt(br.readLine());

        int[][] edges = new int[e][3];
        for (int i = 0; i < e; i++) {
            String[] st = br.readLine().split(" ");
            edges[i][0] = Integer.parseInt(st[0]);
            edges[i][1] = Integer.parseInt(st[1]);
            edges[i][2] = Integer.parseInt(st[2]);
        }

        System.out.println(minCostToSupplyWater(v, edges));
    }
}
