package coinchange;

public class Solution1 {
    int INF = Integer.MAX_VALUE / 2;

    public int coinChange(int[] coins, int amount) {
        Integer[] memo = new Integer[amount + 1];
        int res = dfs(coins, amount, memo);
        return res >= INF ? -1 : res;
    }

    //凑出总金额amount，最少需要的硬币数
    private int dfs(int[] coins, int amount, Integer[] memo) { //dfs(i) = min{ dfs(i-coin) } + 1, coin ∈ coins
        if (amount == 0) return 0;
        if (memo[amount] != null) return memo[amount];

        int res = INF;
        for (int coin : coins) {
            if(coin > amount) continue;
            res = Math.min(res, dfs(coins, amount - coin, memo));
        }
        return memo[amount] = res + 1;
    }

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
//        solution1.coinChange(new int[]{1, 5, 11}, 12);
        solution1.coinChange(new int[]{5, 11}, 6);
    }
}
