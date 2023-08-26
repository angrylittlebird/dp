package climbstairs;

public class Solution2 {
    public int climbStairs(int n) {
        Integer[] dp = new Integer[n + 2];
        //init
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    //f(n) = f(n-1) + f(n-2)
    //走到第N个台阶有几种方式
    private int dfs(int n, Integer[] memo) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        if(memo[n] != null) return memo[n];

        return memo[n] = dfs(n - 1, memo) + dfs(n - 2, memo);
    }
}
