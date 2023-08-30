package maxsubarray;

public class Solution1 {
    public int maxSubArray(int[] nums) {
        //dp[i]: 以nums[i]结尾的子数组的最大和
        //dp[i] = dp[i-1] < 0 ? nums[i] : dp[i-1]+nums[i]

        int n = nums.length;
        int[] dp = new int[n];
        //init
        dp[0] = nums[0];

        for (int i =1; i < n; i++) {
            dp[i] = dp[i - 1] < 0 ? nums[i] : dp[i - 1] + nums[i];
        }

        int max = dp[0];
        for (int val : dp) {
            max = Math.max(max, val);
        }
        return max;
    }
}
