package Level_2.Dynamic_Programming;

public class Jump_Game_II {
    public int jump(int[] nums) {
        int[] dp = new int[nums.length];
        dp[nums.length - 1] = 1;

        for (int i = dp.length - 2; i >= 0; i--){
            if (nums[i] == 0){
                dp[i] = 0;
                continue;
            }
            int min = Integer.MAX_VALUE;
            for (int j = 1; j <= nums[i]; j++){
                min = Math.min(dp[i + j], min);
            }
            if (min == Integer.MAX_VALUE){
                dp[i] = 0;
            } else {
                dp[i] = min + 1;
            }
        }
        return dp[0] - 1;
    }
}
