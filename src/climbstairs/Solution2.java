package climbstairs;

public class Solution2 {
    public int climbStairs(int n) {
        ////当处于第0阶楼梯时，从下往上走到第N阶楼梯总共有几种走法
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
    //当处于第N阶楼梯时，从上往下走到第0阶楼梯有几种走法
    private int dfs(int n, Integer[] memo) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        if(memo[n] != null) return memo[n];

        return memo[n] = dfs(n - 1, memo) + dfs(n - 2, memo);
    }
}
