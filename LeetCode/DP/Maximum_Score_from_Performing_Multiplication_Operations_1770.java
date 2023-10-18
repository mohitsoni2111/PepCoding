package LeetCode.DP;

public class Maximum_Score_from_Performing_Multiplication_Operations_1770 {
    public static int maximumScore(int[] nums, int[] multipliers) {
        int left = 0;
        int right = nums.length - 1;
        int ans = 0;
        for (int i = 0; i < multipliers.length; i++){
            int multiplyBy = multipliers[i];

            if (multiplyBy*nums[left] > multiplyBy*nums[right]){
                ans += multiplyBy*nums[left];
                left++;
            } else {
                ans += multiplyBy*nums[right];
                right--;
            }
        }
        return ans;
    }

    public static void main(String[] args){
        int[] nums = {-5,-3,-3,-2,7,1};
        int[] multipliers = {-10,-5,3,4,6};
        int result = maximumScore(nums, multipliers);
        System.out.println(result);
    }
}
