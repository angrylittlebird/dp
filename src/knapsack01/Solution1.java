package knapsack01;

//转换问题：
//设target等于元素和的一半，是否可以从【数组】中的挑选一些元素使得它们的和为【target】？

//1. 这个问题的base case是什么？
//f(i, 0) = true, 0 <= i < nums.length

//2. 这个问题有什么“状态”？
//当给定的条件中有数组时，定义的状态有可能应包含【数组的取值范围】。
//f(i) = f(i-1)... 取nums[0, i]之间的元素 和 取nums[0, i-1]之间的元素 之间的关系
//状态：
//  -只考虑数组可选取的范围在[0,i]之间的时候，第i位【可能取/可能不取】
//  -只考虑数组可选取的范围在[0,i]之间的时候，第i位【必须取】

//f(i, target)

//3. 对于每个“状态”，可以做出什么“选择”使得“状态”发生改变？
//nums = [1,5,11,5]
//f(3, 11): 当只选 nums[0,3] 之间的某些元素时，是否可以凑到【11】
//        f(3, 11) = f(2, 11) || f(2, 6);
//        f(2, 11) = f(1, 11) || f(2, 0);

//4. 如何定义 dp数组/函数 的含义来表现“状态”和“选择”？
//      f(i, target) = f(i-1, target) || f(i-1, target - nums[i]); target >= nums[i] && i >= 0

public class Solution1 {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) sum += num;
        if (sum % 2 != 0) return false;

        int n = nums.length;
        int target = sum / 2;
        Boolean[][] memo = new Boolean[n][target + 1];
        return dfs(nums, n - 1, target, memo);
    }

    //判断数据nums[0, idx]之间是否 有子序列的和为target
    private boolean dfs(int[] nums, int idx, int target, Boolean[][] memo) {
        if (idx == -1 || target < 0) return false;
        if (target == 0) return true;

        if (memo[idx][target] != null) return memo[idx][target];

        boolean select = dfs(nums, idx - 1, target - nums[idx], memo);
        boolean notSelect = dfs(nums, idx - 1, target, memo);
        return memo[idx][target] = select || notSelect;
    }
}
