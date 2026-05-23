package algoexpert.hard.juice_bottling;
import java.util.*;

// Approach: Bottom-up DP with split backtracking.
class Solution1 {
    public static List<Integer> juiceBottling(int[] prices) {
        int n = prices.length - 1;
        int[] dp = new int[n + 1];
        int[] bestSplit = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            dp[i] = prices[i];
            for (int j = 1; j < i; j++) {
                if (dp[i] < dp[i - j] + prices[j]) {
                    dp[i] = dp[i - j] + prices[j];
                    bestSplit[i] = j;
                }
            }
        }

        List<Integer> result = new ArrayList<>();
        while (n > 0) {
            int split = bestSplit[n] == 0 ? n : bestSplit[n];
            result.add(split);
            n -= split;
        }

        return result;
    }
}
