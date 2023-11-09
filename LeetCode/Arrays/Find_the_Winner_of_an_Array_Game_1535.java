package LeetCode.Arrays;

import java.util.LinkedList;
import java.util.Queue;

public class Find_the_Winner_of_an_Array_Game_1535 {
    public static int getWinner(int[] arr, int k) {
        int maxElement = arr[0];
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i < arr.length; i++) {
            maxElement = Math.max(maxElement, arr[i]);
            queue.offer(arr[i]);
        }

        int curr = arr[0];
        int winstreak = 0;

        while (!queue.isEmpty()) {
            int opponent = queue.poll();

            if (curr > opponent) {
                queue.offer(opponent);
                winstreak++;
            } else {
                queue.offer(curr);
                curr = opponent;
                winstreak = 1;
            }

            if (winstreak == k || curr == maxElement) {
                return curr;
            }
        }

        return -1;
    }

    public int getWinnerNoQueue(int[] arr, int k) {
        int maxElement = arr[0];
        for (int i = 1; i < arr.length; i++) {
            maxElement = Math.max(maxElement, arr[i]);
        }

        int curr = arr[0];
        int winstreak = 0;

        for (int i = 1; i < arr.length; i++) {
            int opponent = arr[i];

            if (curr > opponent) {
                winstreak++;
            } else {
                curr = opponent;
                winstreak = 1;
            }

            if (winstreak == k || curr == maxElement) {
                return curr;
            }
        }

        return -1;
    }

    public static void main(String[] args){
        int[] arr = {2,1,3,5,4,6,7};
        int k = 2;
        int ans = getWinner(arr, k);
        System.out.println(ans);
    }
}
