package Level_2.Graphs;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Bus_Routes {
    public static int numBusesToDestination2(int[][] routes, int source, int destination) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

        for (int i = 0; i < routes.length; i++){
            for (int j = 0; j < routes[i].length; j++){
                int busStopNo = routes[i][j];
                ArrayList<Integer> busNo = map.getOrDefault(busStopNo, new ArrayList<>());
                busNo.add(i);
                map.put(busStopNo, busNo);
            }
        }

        LinkedList<Integer> queue = new LinkedList<>();
        HashSet<Integer> busStopVisited = new HashSet<>();
        HashSet<Integer> busVisited = new HashSet<>();
        int level = 0;

        queue.addLast(source);
        busStopVisited.add(source);

        while (queue.size() > 0){
            int size = queue.size();

            while (size-- > 0){
                int rem = queue.removeFirst();

                if (rem == destination){
                    return level;
                }

                ArrayList<Integer> buses = map.get(rem);
                for (int bus : buses){
                    if (busVisited.contains(bus)){
                        continue;
                    }

                    int[] arr = routes[bus];
                    for (int busStop : arr){
                        if (busStopVisited.contains(busStop)){
                            continue;
                        }

                        queue.addLast(busStop);
                        busStopVisited.add(busStop);
                    }
                    busVisited.add(bus);
                }
            }
            level++;
        }
        return -1;
    }

    public static int numBusesToDestination(int[][] routes, int S, int T) {
        int n = routes.length;
        HashMap<Integer, HashSet<Integer>> to_routes = new HashMap<>();
        for (int i = 0; i < routes.length; ++i) {
            for (int j : routes[i]) {
                if (!to_routes.containsKey(j))
                    to_routes.put(j, new HashSet<Integer>());
                to_routes.get(j).add(i);
            }
        }
        Queue<int[]> bfs = new ArrayDeque<>();
        bfs.offer(new int[] {S, 0});
        HashSet<Integer> seen = new HashSet<>();
        seen.add(S);
        boolean[] seen_routes = new boolean[n];
        while (!bfs.isEmpty()) {
            int stop = bfs.peek()[0], bus = bfs.peek()[1];
            bfs.poll();
            if (stop == T) return bus;
            for (int i : to_routes.get(stop)) {
                if (seen_routes[i]) continue;
                for (int j : routes[i]) {
                    if (!seen.contains(j)) {
                        seen.add(j);
                        bfs.offer(new int[] {j, bus + 1});
                    }
                }
                seen_routes[i] = true;
            }
        }
        return -1;
    }
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int[][] arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            String[] st = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st[j]);
            }
        }

        String[] st1 = br.readLine().split(" ");
        int src = Integer.parseInt(st1[0]);
        int dest = Integer.parseInt(st1[1]);
        System.out.println(numBusesToDestination(arr, src, dest));

    }
}
