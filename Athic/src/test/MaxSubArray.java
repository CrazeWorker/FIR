package test;

import java.util.Arrays;

public class MaxSubArray {
    public int maxSubArray(int[] nums) {
        int length = nums.length;
        // 边界值判断
        if (nums.length == 0) {
            return 0;
        }
        // 定义状态，dp[i]表示以当前元素为结尾的连续最大子序列和
        int[] dp = new int[length];
        // 初始化数组
        for (int i = 0; i < dp.length; i++) {
            dp[i] = nums[i];
        }
        // 状态转移方程，dp[i]的要么是自身，要么就是dp[i-1]，即dp[i] = max(dp[i],dp[i-1]+dp[i])
        for (int i = 1; i < dp.length; i++) {
            dp[i] = Math.max(dp[i], dp[i - 1] + dp[i]);
        }
        Arrays.sort(dp);
        return dp[length - 1];
    }
}
