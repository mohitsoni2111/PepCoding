package Level_2.Graphs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Critical_Connection {
    static int[] parent;
    static int[] discovery;
    static int[] low;
    static int time;
    static boolean[] visited;

    public static void bridges(int u, List<List<Integer>> graph, List<List<Integer>> ans) {
        discovery[u] = low[u] = time;
        time++;
        visited[u] = true;

        for (int v : graph.get(u)){
            if (parent[u] == v){
                continue;
            } else if (visited[v]){
                low[u] = Math.min(low[u], discovery[v]);
            } else {
                parent[v] = u;

                bridges(v, graph, ans);

                low[u] = Math.min(low[u], low[v]);

                if (low[v] > discovery[u]){
                    List<Integer> temp = new ArrayList<>();
                    temp.add(u);
                    temp.add(v);
                    ans.add(temp);
                }
            }
        }
    }
    public static List<List<Integer>> criticalConnections(int n, List<List<Integer>> edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++)
            graph.add(new ArrayList<>());

        for (List<Integer> edge : edges) {
            int u = edge.get(0);
            int v = edge.get(1);

            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        parent = new int[n];
        discovery = new int[n];
        low = new int[n];
        time = 0;
        visited = new boolean[n];
        List<List<Integer>> ans = new ArrayList<>();

        bridges(0, graph, ans);

        return ans;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] st = br.readLine().split(" ");
        int n = Integer.parseInt(st[0]);
        int e = Integer.parseInt(st[1]);
        List<List<Integer>> edges = new ArrayList<>();


        for (int i = 0; i < e; i++) {
            edges.add(new ArrayList<>());
            st = br.readLine().split(" ");
            edges.get(i).add(Integer.parseInt(st[0]));
            edges.get(i).add(Integer.parseInt(st[1]));
        }

        System.out.println(criticalConnections(n, edges));
    }
}
