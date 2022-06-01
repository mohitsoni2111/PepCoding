package Graphs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Perfect_Friends {
    private static void drawTreeAndGenerateComponent(ArrayList<Edge>[] graph, int src, ArrayList<Integer> comp, boolean[] visited){
        visited[src] = true;
        comp.add(src);

        for (Edge edge : graph[src]){
            if (!visited[edge.nbr]){
                drawTreeAndGenerateComponent(graph, edge.nbr, comp, visited);
            }
        }
    }
    public static class Edge{
        int src;
        int nbr;
        Edge(int src, int nbr) {
            this.src = src;
            this.nbr = nbr;
        }
    }  // Source, Neighbour, Weight
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        // write your code here
        ArrayList<Edge>[] graph = new ArrayList[n];
        for (int v = 0; v < n; v++){
            graph[v] = new ArrayList<>();
        }

        for (int e = 0; e < k; e++){
            String[] parts = br.readLine().split(" ");
            int v1 = Integer.parseInt(parts[0]);
            int v2 = Integer.parseInt(parts[1]);
            graph[v1].add(new Edge(v1, v2));
            graph[v2].add(new Edge(v2, v1));
        }

        // Write your code here
        boolean[] visited = new boolean[n];
        ArrayList<ArrayList<Integer>> comps = new ArrayList<>();
        for (int v = 0; v < n; v++){
            if(!visited[v]){
                ArrayList<Integer> comp = new ArrayList<>();
                drawTreeAndGenerateComponent(graph, v, comp, visited);
                comps.add(comp);
            }
        }

        int count = 0;

        for (int  i = 0; i < comps.size(); i++){
            for (int j = i + 1; j < comps.size(); j++){
                count += comps.get(i).size() * comps.get(j).size();
            }
        }

        System.out.println(count);
    }
}
