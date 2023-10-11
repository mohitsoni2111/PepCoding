package Level_2.Graphs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.LinkedList;

public class Zero_One_BFS {
    public static class Pair{
        int vtx;
        int wt;
        Pair(int vtx, int wt){
            this.vtx = vtx;
            this.wt = wt;
        }
    }   // Vertex, Weight

    public static void main(String[] args) throws NumberFormatException, IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] st = br.readLine().split(" ");
        int n = Integer.parseInt(st[0]);
        int m = Integer.parseInt(st[1]);

        ArrayList<ArrayList<Pair>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++){
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++){
            st = br.readLine().split(" ");
            int u = Integer.parseInt(st[0]) - 1;
            int v = Integer.parseInt(st[0]) - 1;

            graph.get(u).add(new Pair(v, 0));
            graph.get(v).add(new Pair(u, 1));
        }
        LinkedList<Pair> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];
        queue.addLast(new Pair(0, 0));

        while (queue.size() > 0){
            // Remove
            Pair rem = queue.removeFirst();

            // Mark
            visited[rem.vtx] = true;

            // Work
            if (rem.vtx == n - 1){
                System.out.println(rem.wt);
                return;
            }

            // Add
            for (Pair nbrs : graph.get(rem.vtx)){
                if (visited[nbrs.vtx]) continue;

                if (nbrs.wt == 0){
                    queue.addFirst(new Pair(nbrs.vtx, rem.wt));
                } else {
                    queue.addLast(new Pair(nbrs.vtx, nbrs.wt + 1));
                }
            }
        }
        System.out.println("-1");
    }
}