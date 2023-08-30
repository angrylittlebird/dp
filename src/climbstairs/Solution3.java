package climbstairs;

public class Solution3 {
    public int climbStairs(int n) {
        if (n < 3) return n;

        //init
        int a = 1;
        int b = 2;

        int cur = 0;
        for (int i = 3; i <= n; i++) {
            cur = a + b;

            a = b;
            b = cur;
        }
        return cur;
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
