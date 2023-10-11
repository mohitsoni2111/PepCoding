package LeetCode.Graphs;

import java.util.*;

public class The_Maze_II_505 {
    public static void dfs(int[][] maze, int[] start, int[][] distance){
        int[][] dirs={{0,1}, {0,-1}, {-1,0}, {1,0}};
        for (int[] dir : dirs){
            int x = start[0] + dir[0];
            int y = start[1] + dir[1];
            int count = 0;

            while (x >= 0 && x < maze.length && y >= 0 && y < maze[0].length && maze[x][y] == 0){
                x += dir[0];
                y += dir[1];
                count++;
            }
            if ((distance[start[0]][start[1]] + count) < distance[x - dir[0]][y - dir[1]]){
                distance[x - dir[0]][y - dir[1]] = distance[start[0]][start[1]] + count;
                dfs(maze, new int[]{x - dir[0], y - dir[1]}, distance);
            }
        }
    }
    public static int shortestDistance(int[][] maze, int[] start, int[] dest) {
        int[][] distance = new int[maze.length][maze[0].length];
        for (int[] row : distance){
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        distance[start[0]][start[1]] = 0;
        dfs(maze, start, distance);
        return distance[dest[0]][dest[1]] == Integer.MAX_VALUE ? -1 : distance[dest[0]][dest[1]];
    }

    // BFS
    public static int shortestDistance2(int[][] maze, int[] start, int[] dest){
        int[][] distance = new int[maze.length][maze[0].length];
        for (int[] row: distance)
            Arrays.fill(row, Integer.MAX_VALUE);
        distance[start[0]][start[1]] = 0;
        int[][] dirs={{0, 1} ,{0, -1}, {-1, 0}, {1, 0}};
        Queue<int[]> queue = new LinkedList<>();
        queue.add(start);
        while (!queue.isEmpty()){
            int[] rem = queue.remove();
            for (int[] dir : dirs){
                int x = rem[0] + dir[0];
                int y = rem[1] + dir[1];
                int count = 0 ;

                while (x >= 0 && x < maze.length && y >= 0 && y < maze[0].length && maze[x][y] == 0){
                    x += dir[0];
                    y += dir[1];
                    count++;
                }
                if ((distance[rem[0]][rem[1]] + count) < distance[x - dir[0]][y - dir[1]]){
                    distance[x - dir[0]][y - dir[1]] = distance[rem[0]][rem[1]] + count;
                    queue.add(new int[]{x - dir[0], y - dir[1]});
                }
            }
        }
        return distance[dest[0]][dest[1]] == Integer.MAX_VALUE ? -1 : distance[dest[0]][dest[1]];
    }

    // Dijkstra and Priority Queue
    private static void dijkstra(int[][] maze, int[] start, int[][] distance) {
        int[][] dirs = {{0,1}, {0,-1}, {-1,0}, {1,0}};
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        queue.offer(new int[]{start[0], start[1], 0});

        while (!queue.isEmpty()){
            int[] rem = queue.poll();

            if (distance[rem[0]][rem[1]] < rem[2]) continue;

            for (int[] dir : dirs){
                int x = rem[0] + dir[0];
                int y = rem[1] + dir[1];
                int count = 0;

                while (x >= 0 && y >= 0 && x < maze.length && y < maze[0].length && maze[x][y] == 0) {
                    x += dir[0];
                    y += dir[1];
                    count++;
                }
                if (distance[rem[0]][rem[1]] + count < distance[x - dir[0]][y - dir[1]]){
                    distance[x - dir[0]][y - dir[1]] = distance[rem[0]][rem[1]] + count;
                    queue.offer(new int[]{x - dir[0], y - dir[1], distance[x - dir[0]][y - dir[1]]});
                }
            }

        }
    }
    public static int shortestDistance3(int[][] maze, int[] start, int[] dest){
        int[][] distance = new int[maze.length][maze[0].length];
        for (int[] row : distance){
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        distance[start[0]][start[1]] = 0;
        dijkstra(maze, start, distance);
        return distance[dest[0]][dest[1]] == Integer.MAX_VALUE ? -1 : distance[dest[0]][dest[1]];
    }

    public static void main(String[] args){
        int[][] maze = {{0,0,1,0,0},{0,0,0,0,0},{0,0,0,1,0},{1,1,0,1,1},{0,0,0,0,0}};
        int[] start = {0,4};
        int[] destination = {4,4};

        int res = shortestDistance(maze, start, destination);
        System.out.println(res);
    }
}
