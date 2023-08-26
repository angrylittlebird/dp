package coinchange;

public class Solution2 {
    int INF = Integer.MAX_VALUE / 2;

    public int coinChange(int[] coins, int amount) {
        //dp[i] = min(dp[i-coin]) + 1, coin ∈ coins
        Integer[] dp = new Integer[amount + 1];
        //init
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            int res = INF;
            for (int coin : coins) {
                if (coin > i) continue;
                res = Math.min(res, dp[i - coin]);
            }
            dp[i] = res + 1;
        }
        return dp[amount] >= INF ? -1 : dp[amount];
    }

    //凑出总金额amount，最少需要的硬币数
    private int dfs(int[] coins, int amount, Integer[] memo) { //dfs(i) = min{ dfs(i-coin) } + 1, coin ∈ coins
        if (amount == 0) return 0;
        if (memo[amount] != null) return memo[amount];

        int res = INF;
        for (int coin : coins) {
            if (coin > amount) continue;
            res = Math.min(res, dfs(coins, amount - coin, memo));
        }
        return memo[amount] = res + 1;
    }
}
