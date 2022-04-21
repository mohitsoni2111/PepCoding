package Graphs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Is_Graph_Connected {
    private static void drawTreeAndGenerateComponent(ArrayList<Edge>[] graph, int src, ArrayList<Integer> comp, boolean[] visited){
        visited[src] = true;
        comp.add(src);
        for (Edge edge : graph[src]){
            if (!visited[edge.nbr]){
                drawTreeAndGenerateComponent(graph, edge.nbr, comp, visited);
            }
        }
    }

    private static ArrayList<ArrayList<Integer>> getConnectedComponents(ArrayList<Edge>[] graph, int vtces){
        ArrayList<ArrayList<Integer>> comps = new ArrayList<>();

        boolean[] visited = new boolean[vtces];
        for (int v = 0; v < vtces; v++){
            if (!visited[v]){
                ArrayList<Integer> comp = new ArrayList<>();
                drawTreeAndGenerateComponent(graph, v, comp, visited);
                comps.add(comp);
            }
        }
        return comps;
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

        ArrayList<ArrayList<Integer>> comps = getConnectedComponents(graph, vtces);
        System.out.println(comps.size() == 1);
    }
}