package Level_2.Graphs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Remove_Max_Number_of_Edges_to_Keep_Graph_Fully_Traversable {
    public static int find(int x, int[] parent){
        if (parent[x] != x)
            parent[x] = find(parent[x], parent);
        return parent[x];
    }
    public static boolean union(int x, int y, int[] parent, int[] rank){
        int px = find(x, parent);
        int py = find(y, parent);
        if (px != py){
            if (rank[px] > rank[py]){
                parent[py] = px;
            } else if (rank[px] < rank[py]) {
                parent[px] = py;
            } else {
                parent[px] = py;
                rank[py]++;
            }
            return true;
        }
        return false;
    }
    public static int maxNumEdgesToRemove(int n, int[][] edges) {
        Arrays.sort(edges, (a,b) -> Integer.compare(a[0], b[0]));
        int[] parentA = new int[n+1];
        int[] rankA = new int[n+1];
        int[] parentB = new int[n+1];
        int[] rankB = new int[n+1];

        for (int i = 0; i < parentA.length; i++){
            parentA[i] = i;
            parentB[i] = i;
            rankA[i] = 1;
            rankB[i] = 1;
        }

        int mergedA = 1, mergedB = 1;
        int removeEdges = 0;

        for (int[] edge : edges){
            if (edge[0] == 3){
                boolean tempA = union(edge[1], edge[2], parentA, rankA);
                boolean tempB = union(edge[1], edge[2], parentB, rankB);

                if (tempA) mergedA++;
                if (tempB) mergedB++;
                if (!tempA && !tempB) removeEdges++;

            } else if (edge[0] == 1) {
                boolean tempA = union(edge[1], edge[2], parentA, rankA);

                if (tempA) mergedA++;
                else removeEdges++;

            } else {
                boolean tempB = union(edge[1], edge[2], parentB, rankB);

                if (tempB) mergedB++;
                else removeEdges++;
            }
        }

        if (mergedA != n || mergedB != n) return -1;

        return removeEdges;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] st = br.readLine().split(" ");
        int n = Integer.parseInt(st[0]);
        int m = Integer.parseInt(st[1]);

        int[][] edges = new int[m][3];
        for (int i = 0; i < m; i++) {
            st = br.readLine().split(" ");
            edges[i][0] = Integer.parseInt(st[0]);
            edges[i][1] = Integer.parseInt(st[1]);
            edges[i][2] = Integer.parseInt(st[2]);
        }
        System.out.println(maxNumEdgesToRemove(n, edges));
    }
}
