package Level_2.Graphs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class Mother_Vertex {
    private static void dfs(ArrayList<ArrayList<Integer>> graph, boolean[] visited, int current, Stack<Integer> stack) {
        visited[current] = true;

        for (int nbrs : graph.get(current)){
            if (!visited[nbrs]){
                dfs(graph, visited, nbrs, stack);
            }
        }
        stack.push(current);
    }

    static int count;
    private static void dfs(ArrayList<ArrayList<Integer>> graph, boolean[] visited, int current) {
        visited[current] = true;
        count++;

        for (int nbrs : graph.get(current)){
            if (!visited[nbrs]){
                dfs(graph, visited, nbrs);
            }
        }
    }
    public static int findMotherVertex(int N, ArrayList<ArrayList<Integer>> graph) {
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[N];

        for (int i = 0; i < N; i++){
            if (!visited[i]){
                dfs(graph, visited, i, stack);
            }
        }

        int ans = stack.pop();
        visited = new boolean[N];
        count = 0;
        dfs(graph, visited, ans);

        if (count == N)
            return ans + 1;        // Bcoz 1 base indexing is changed to 0 based.

        return -1;                              // else
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] st = br.readLine().split(" ");
        int n = Integer.parseInt(st[0]);
        int m = Integer.parseInt(st[1]);

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = br.readLine().split(" ");
            int u = Integer.parseInt(st[0]) - 1;
            int v = Integer.parseInt(st[1]) - 1;
            graph.get(u).add(v);
        }

        System.out.println(findMotherVertex(n, graph));
    }
}
