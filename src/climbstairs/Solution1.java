package climbstairs;

public class Solution1 {
    public int climbStairs(int n) { //O(N)
        Integer[] memo = new Integer[n + 1];
        return dfs(n, memo);
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
