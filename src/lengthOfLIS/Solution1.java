package lengthOfLIS;

import java.util.Arrays;

public class Solution1 {
    //当给定的条件中有数组时，定义的状态有可能应包含【数组的取值范围】。
    //f(i) = f(i-1)... 取nums[0, i]之间的元素 和 取nums[0, i-1]之间的元素 之间的关系
    //状态：
    //  -只考虑数组可选取的范围在[0,i]之间的时候，第i位【可能取/可能不取】
    //  -只考虑数组可选取的范围在[0,i]之间的时候，第i位【必须取】*
    public int lengthOfLIS(int[] nums) {
        //dp[i] 表示以nums[i]结尾 的 最长递增子序列的长度
        //dp[i] = max( dp[j] + 1 ); for i in [0, i)

        int n = nums.length;
        int[] dp = new int[n];
        //init
        Arrays.fill(dp, 1);

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }

        int max = 0;
        for (int val : dp) {
            max = Math.max(max, val);
        }
        return max;
    }
}
