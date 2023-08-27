package climbstairs;

public class Solution0 {
    public int climbStairs(int n) { //O(2^n)
        return dfs(n);
    }

    //f(n) = f(n-1) + f(n-2)
    //走到第N个台阶有几种方式
    private int dfs(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;

        return dfs(n - 1) + dfs(n - 2);
    }
}
