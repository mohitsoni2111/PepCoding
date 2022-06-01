package Graphs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;

public class Is_Bipartite {
    public static class Pair{
        int v;
        String psf;
        int level;

        public Pair(int v, String psf, int level) {
            this.v = v;
            this.psf = psf;
            this.level = level;
        }
    } // Vertex, PathSoFar, Level
    private static boolean isBipartite(ArrayList<Edge>[] graph, int vtces) {
        int[] visited = new int[vtces];
        Arrays.fill(visited, -1);
        for (int v = 0; v < vtces; v++){
            if (visited[v] == -1){
                if (!checkComponentForBipartite(graph, v, visited)) return false;
            }
        }
        return true;
    }
    private static boolean checkComponentForBipartite(ArrayList<Edge>[] graph, int src, int[] visited) {
        ArrayDeque<Pair> queue = new ArrayDeque<>();
        queue.add(new Pair(src, src + "", 0));

        while (queue.size() > 0){
            Pair rem = queue.removeFirst();

            if (visited[rem.v] != -1){
                if (rem.level != visited[rem.level]){
                    return false;
                }
            } else {
                visited[rem.v] = rem.level;
            }

            for (Edge edge : graph[rem.v]){
                if (visited[edge.nbr] == -1){
                    queue.add(new Pair(edge.nbr, rem.psf + edge.nbr, rem.level + 1));
                }
            }
        }
        return true;
    }


    static class Edge {
        int src;
        int nbr;
        int wt;

        Edge(int src, int nbr, int wt) {
            this.src = src;
            this.nbr = nbr;
            this.wt = wt;
        }
    }   // Source, Neighbour, Weight
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int vtces = Integer.parseInt(br.readLine());
        ArrayList<Edge>[] graph = new ArrayList[vtces];
        for (int i = 0; i < vtces; i++) {
            graph[i] = new ArrayList<>();
        }

        int edges = Integer.parseInt(br.readLine());
        for (int i = 0; i < edges; i++) {
            String[] parts = br.readLine().split(" ");
            int v1 = Integer.parseInt(parts[0]);
            int v2 = Integer.parseInt(parts[1]);
            int wt = Integer.parseInt(parts[2]);
            graph[v1].add(new Edge(v1, v2, wt));
            graph[v2].add(new Edge(v2, v1, wt));
        }
        // write your code here
        boolean ans = isBipartite(graph, vtces);
        System.out.println(ans);
    }
}
