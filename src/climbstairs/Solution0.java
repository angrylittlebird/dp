package climbstairs;

//转换问题：
//从第N阶楼梯往下走，每次可以选择往下走1阶或者2阶，走到第0阶楼梯总共有几种走法？

//1. 这个问题的base case是什么？
//N = 1时，有1种方法
//N = 2时，有2种方法

//为什么base case 不包含3？
//为什么base case 不从 N = 0 开始？

//2. 这个问题有什么“状态”？
// 爬到第i阶楼梯可以有几种方式

//3. 对于每个“状态”，可以做出什么“选择”使得“状态”发生改变？
//f(3): 当处于第3阶楼梯时，往下走到第0阶楼梯有几种走法
//        f(3) = f(3 - 1);
//        f(3) = f(3 - 2);
//        f(3) = f(2) + f(1);
//4. 如何定义 dp数组/函数 的含义来表现“状态”和“选择”？
//        f(i) = f(i-1) + f(i-2)
public class Solution0 {
    public int climbStairs(int n) { //O(2^n)
        return dfs(n);
    }

    //f(n) = f(n-1) + f(n-2)
    //当处于第N阶楼梯时，往下走到第0阶楼梯有几种走法
    private int dfs(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;

        return dfs(n - 1) + dfs(n - 2);
    }
}
