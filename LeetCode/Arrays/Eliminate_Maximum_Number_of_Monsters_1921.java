package LeetCode.Arrays;

import java.util.Arrays;

public class Eliminate_Maximum_Number_of_Monsters_1921 {
    public static int eliminateMaximum(int[] dist, int[] speed) {
        double[] arrival = new double[dist.length];
        for (int i = 0; i < dist.length; i++) {
            arrival[i] = (double) dist[i] / speed[i];
        }

        Arrays.sort(arrival);
        int ans = 0;

        for (int i = 0; i < arrival.length; i++) {
            if (arrival[i] <= i) {
                break;
            }

            ans++;
        }

        return ans;
    }
    public static void main(String[] args){
        int[] dist = {4,3,4}, speed = {1,1,2};
        int ans = eliminateMaximum(dist, speed);
        System.out.println(ans);
    }
}
