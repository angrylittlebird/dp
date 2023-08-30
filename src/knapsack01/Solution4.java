package knapsack01;

import java.util.Arrays;
import java.util.HashSet;

public class Solution4 {
    //计算所有可能的和
    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 != 0) return false;
        int target = sum / 2;

        HashSet<Integer> existsSum = new HashSet<>();
        existsSum.add(0);
        for (int num : nums) {
            HashSet<Integer> newSums = new HashSet<>();
            for (Integer exist : existsSum) {
                int newSum = exist + num;
                if (newSum <= target) newSums.add(newSum);
            }
            existsSum.addAll(newSums);
        }
        return existsSum.contains(target);
    }
}
