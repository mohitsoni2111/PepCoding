package Graphs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;

public class BFS {
    static class Pair{
        int vertex;
        String psf;

        public Pair(int vertex, String psf) {
            this.vertex = vertex;
            this.psf = psf;
        }
    }
    private static void bfs(ArrayList<Edge>[] graph, int src, int vtces){
        boolean[] visited = new boolean[vtces];
        ArrayDeque<Pair> queue = new ArrayDeque<>();
        queue.add(new Pair(src, src + ""));

        while (queue.size() > 0){
            Pair rem = queue.removeFirst();
            if (visited[rem.vertex]) continue;
            visited[rem.vertex] = true;

            System.out.println(rem.vertex + "@" + rem.psf);

            for (Edge edge : graph[rem.vertex]){
                if (!visited[edge.nbr]){
                    queue.add(new Pair(edge.nbr, rem.psf + edge.nbr));
                }
            }
        }
    }

    static class Edge {
        int src;
        int nbr;

        Edge(int src, int nbr) {
            this.src = src;
            this.nbr = nbr;
        }
    }
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
            graph[v1].add(new Edge(v1, v2));
            graph[v2].add(new Edge(v2, v1));
        }

        int src = Integer.parseInt(br.readLine());

        // write your code here
        bfs(graph, src, vtces);
    }
}
