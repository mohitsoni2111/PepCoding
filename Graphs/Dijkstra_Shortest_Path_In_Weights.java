package Graphs;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class Dijkstra_Shortest_Path_In_Weights {
    static class Pair implements Comparable<Pair>{
        int v;
        String psf;
        int wsf;
        public Pair(int v, String psf, int weight) {
            this.v = v;
            this.psf = psf;
            this.wsf = weight;
        }

        @Override
        public int compareTo(Pair o) {
            return this.wsf - o.wsf;
        }
    }   // Vertex, PathSoFar, WeightSoFar
    private static void dijkstra(ArrayList<Edge>[] graph, int src, int vtces) {
        boolean[] visited = new boolean[vtces];
        PriorityQueue<Pair> queue = new PriorityQueue<>();
        queue.add(new Pair(src, src + "", 0));

        while (queue.size() > 0){
            Pair rem = queue.remove();
            if (visited[rem.v]) continue;
            visited[rem.v] = true;

            System.out.println(rem.v  + " via " + rem.psf + " @ " + rem.wsf);

            for (Edge edge : graph[rem.v]){
                if (!visited[edge.nbr]){
                    queue.add(new Pair(edge.nbr, rem.psf + edge.nbr, rem.wsf + edge.wt));
                }
            }
        }
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
    } // Source, Neighbour, Weight
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

        int src = Integer.parseInt(br.readLine());

        // write your code here
        dijkstra(graph, src, vtces);
    }
}
