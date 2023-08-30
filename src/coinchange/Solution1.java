package coinchange;

//1. 这个问题的base case是什么？
// 总金额为0时，所需的硬币个数为0
//2. 这个问题有什么“状态”？
// 目标金额amount
//3. 对于每个“状态”，可以做出什么“选择”使得“状态”发生改变？
// coins = {1, 2, 3}, amount = 11
//f(11): 凑成面额为11的最少硬币数
//        f(11) = f(11 - 1) + 1;
//        f(11) = f(11 - 2) + 1;
//        f(11) = f(11 - 3) + 1;
//        f(11) = min{ f(10), f(9), f(8) } + 1;
//4. 如何定义 dp数组/函数 的含义来表现“状态”和“选择”？
//        f(i) = min{ f(i-coin) } + 1, coin ∈ coins; i >= coin
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
        solution1.coinChange(new int[]{1, 5, 11}, 12);
    }
}
