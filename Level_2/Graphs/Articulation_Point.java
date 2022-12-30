package Level_2.Graphs;

import java.util.ArrayList;
import java.util.Scanner;

// https://www.youtube.com/watch?v=sAk4W8q0Rmw&list=PL-Jc9J83PIiEuHrjpZ9m94Nag4fwAvtPQ&index=23
public class Articulation_Point {
    static int[] parent;
    static int[] discovery;
    static int[] low;
    static int time;
    static boolean[] visited;
    static boolean[] articulationPoint;

    private static void dfs(int u, ArrayList<ArrayList<Integer>> graph) {
        discovery[u] = low[u] = time;
        time++;
        int count = 0;
        visited[u] = true;

        for (int v : graph.get(u)) {
            if (parent[u] == v) {
                continue;
            } else if (visited[v]) {
                low[u] = Math.min(low[u], discovery[v]);
            } else {
                parent[v] = u;
                count++;

                dfs(v, graph);

                low[u] = Math.min(low[u], low[v]);

                if (parent[u] == -1) {   // Actual source
                    if (count >= 2) {
                        articulationPoint[u] = true;
                    }
                } else {
                    if (low[v] >= discovery[u]) {
                        articulationPoint[u] = true;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int vertices  = scanner.nextInt();
        int edges = scanner.nextInt();

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0 ; i < vertices; i++){
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < edges; i++){
            int u = scanner.nextInt()-1;
            int v = scanner.nextInt()-1;
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        parent = new int[vertices];
        discovery = new int[vertices];
        low = new int[vertices];
        time = 0;
        visited = new boolean[vertices];
        articulationPoint = new boolean[vertices];

        parent[0] = -1;
        dfs(0, graph);

        int ans = 0;
        for (int i = 0; i < vertices; i++){
            if (articulationPoint[i])
                ans++;
        }
        System.out.print(ans);
    }
}
