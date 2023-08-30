package coinchange;


//1. 这个问题的base case是什么？
// 总金额为0时，所需的硬币个数为0
//2. 这个问题有什么“状态”？
// 目标金额amount
//3. 对于每个“状态”，可以做出什么“选择”使得“状态”发生改变？
// coin = {1, 5, 11}, amount = 15
//f(15): 凑成面额为15的最少硬币数
//        f(15) = f(15 - 1) + 1;
//        f(15) = f(15 - 5) + 1;
//        f(15) = f(15 - 11) + 1;
//        f(15) = min{ f(14), f(10), f(4) } + 1;
//4. 如何定义 dp数组/函数 的含义来表现“状态”和“选择”？
//        f(i) = min{ f(i-coin) } + 1, coin ∈ coins; i >= coin
public class Solution0 {
    int INF = Integer.MAX_VALUE / 2;

    public int coinChange(int[] coins, int amount) {
        int res = dfs(coins, amount);
        return res >= INF ? -1 : res;
    }

    //凑出目标金额amount，最少需要的硬币数
    private int dfs(int[] coins, int amount) { //dfs(i) = min{ dfs(i-coin) } + 1, coin ∈ coins
        if (amount == 0) return 0;

        int res = INF;
        for (int coin : coins) {
            if (coin > amount) continue;
            res = Math.min(res, dfs(coins, amount - coin));
        }
        return res + 1;
    }

    public static void main(String[] args) {
        Solution0 solution1 = new Solution0();
        solution1.coinChange(new int[]{1, 5, 11}, 12);
    }
}
