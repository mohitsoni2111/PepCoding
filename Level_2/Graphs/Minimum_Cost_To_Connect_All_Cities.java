package Level_2.Graphs;

import java.util.*;

public class Minimum_Cost_To_Connect_All_Cities {

    /* Kruskal’s algorithm to generate a minimum spanning tree for the graph. Use Union-Find to detect cycle.

    1. Sort edges to non-decreasing order
    2. Pick the smallest edge that does not form a cycle
    3. Repeat until MST is formed and every node is connected.

    Implemented Union-Find with path compression to improve efficiency.
     */
    int[] parent;
    int n;
    public int find(int x) {
        if (parent[x] == x) {
            return parent[x];
        }
        parent[x] = find(parent[x]); // path compression
        return parent[x];
    }
    public void union(int x, int y) {
        int px = find(x);
        int py = find(y);

        if (px != py) {
            parent[px] = py;
            n--;
        }
    }
    public int minimumCost(int N, int[][] connections) {
        parent = new int[N + 1];
        n = N;
        for (int i = 0; i <= N; i++) {
            parent[i] = i;
        }

        Arrays.sort(connections, (a, b) -> (a[2] - b[2]));

        int res = 0;

        for (int[] c : connections) {
            int x = c[0], y = c[1];
            if (find(x) != find(y)) {
                res += c[2];
                union(x, y);
            }
        }

        return n == 1 ? res : -1;
    }
}
