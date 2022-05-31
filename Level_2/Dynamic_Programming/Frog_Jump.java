package Level_2.Dynamic_Programming;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Frog_Jump {
    public static boolean solution(int[] stones) {
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();

        for (int stone : stones) {
            map.put(stone, new HashSet<>());
        }

        map.get(stones[0]).add(1);

        for (int i = 0; i < stones.length; i++){
            int currentStone = stones[i];
            HashSet<Integer> jumps = map.get(currentStone);
            for (int jump : jumps){
                int position = currentStone + jump;

                if (position == stones[stones.length - 1]){
                    return true;
                }

                if (map.containsKey(position)){
                    if (jump - 1 > 0) {
                        map.get(position).add(jump - 1);
                    }
                    map.get(position).add(jump);
                    map.get(position).add(jump + 1);
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0 ; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        System.out.println(solution(arr));
    }
}
