package Dynamic_Programming;

public class Jump_Game_55 {
    // nums = [2,3,1,1,4]
    public boolean canJump(int[] nums) {
        boolean[] dp = new boolean[nums.length];
        dp[nums.length - 1] = true;

        for (int i = dp.length - 2; i >= 0; i--){
            for (int j = 1 ; j <= nums[i]; j++){
                if (dp[i + j]) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[0];
    }
}
