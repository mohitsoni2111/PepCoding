package Level_2.Arrays;

import java.util.HashMap;
import java.util.Map;

public class Pairs_of_Songs_With_Total_Durations_Divisible_by_60 {
    public int numPairsDivisibleBy60(int[] time) {
        int count = 0;

        for(int i = 0; i<time.length; i++) {
            if(time[i] >= 60)
                time[i] = time[i]%60;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int t : time) {
            if (map.containsKey((60 - t) % 60)) {
                count += map.get((60 - t) % 60);
            }
            map.put(t, map.getOrDefault(t, 0) + 1);
        }
        return count;
    }
}
