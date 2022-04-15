package Graphs;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;

public class Is_Cyclic {
    static class Pair{
        int v;
        String psf;

        public Pair(int v, String psf) {
            this.v = v;
            this.psf = psf;
        }
    }
    public static boolean isCyclicHelper(ArrayList<Edge>[] graph, int vtces){
        boolean[] visited = new boolean[vtces];
        for (int v = 0 ;v < vtces; v++){
            if (!visited[v]){
                boolean cycle = isCyclic(graph, v, visited);
                if (cycle) return true;
            }
        }
        return false;
    }
    public static boolean isCyclic(ArrayList<Edge>[] graph, int src, boolean[] visited){
        ArrayDeque<Pair> queue = new ArrayDeque<>();
        queue.add(new Pair(src, src + ""));

        while (queue.size() > 0){
            Pair rem = queue.removeFirst();
            if (visited[rem.v]){
                return true;
            }
            visited[rem.v] = true;

            for (Edge edge : graph[rem.v]){
                if (!visited[edge.nbr]){
                    queue.add(new Pair(edge.nbr, rem.psf + edge.nbr));
                }
            }
        }
        return false;
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
            int wt = Integer.parseInt(parts[2]);
            graph[v1].add(new Edge(v1, v2, wt));
            graph[v2].add(new Edge(v2, v1, wt));
        }

        // write your code here
        boolean ans = isCyclicHelper(graph, vtces);
        System.out.println(ans);
    }
}
