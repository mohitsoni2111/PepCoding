package Level_2.Dynamic_Programming;

import java.util.HashMap;
import java.util.Scanner;

public class Count_Distinct_Subsequences {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        String str = scn.next();

        long[] dp = new long[str.length() + 1];
        dp[0] = 1;

        HashMap<Character, Integer> lastOccurence = new HashMap<>();
        for (int i = 1; i < dp.length; i++) {
            dp[i] = 2 * dp[i - 1];

            char ch = str.charAt(i - 1);
            if (lastOccurence.containsKey(ch)) {
                int j = lastOccurence.get(ch);
                dp[i] = dp[i] - dp[j - 1];
            }
            lastOccurence.put(ch, i);
        }
        System.out.println(dp[str.length()] - 1);
    }
}
