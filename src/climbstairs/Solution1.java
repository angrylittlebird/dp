package climbstairs;

public class Solution1 {
    public int climbStairs(int n) { //O(N)
        Integer[] memo = new Integer[n + 1];
        return dfs(n, memo);
    }

    //f(n) = f(n-1) + f(n-2)
    //当处于第N阶楼梯时，往下走到第0阶楼梯有几种走法
    private int dfs(int n, Integer[] memo) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        if(memo[n] != null) return memo[n];

        return memo[n] = dfs(n - 1, memo) + dfs(n - 2, memo);
    }
}
