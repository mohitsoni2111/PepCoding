package LeetCode.BinaryTree;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Binary_Trees_With_Factors_823 {
    /*
    Input: arr = [2,4,5,10]
    Output: 7
    Explanation: We can make these trees: [2], [4], [5], [10], [4, 2, 2], [10, 2, 5], [10, 5, 2].
     */
    public int numFactoredBinaryTrees(int[] arr) {
        int MOD = (int)1e9+7;
        int n = arr.length;
        Arrays.sort(arr);
        long[] dp = new long[n];
        Arrays.fill(dp, 1);

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++){
            map.put(arr[i], i);
        }

        for (int i = 0; i < n; i++){
            for (int j = 0; j < i; j++){
                if (arr[i] % arr[j] == 0){  // arr[j] is the left child
                    int right = arr[i] / arr[j];
                    if (map.containsKey(right)){
                        dp[i] = (dp[i] + dp[j] * dp[map.get(right)]) % MOD;
                    }
                }
            }
        }

        long ans = 0;
        for (long num : dp) ans += num;

        return (int) (ans % MOD);
    }
}
