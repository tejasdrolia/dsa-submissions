

class Solution {
    public int coinChange(int[] coins, int amount) {
        int dp[] = new int[amount + 1];
        Arrays.fill(dp, 1000000);
        dp[0] = 0;
        for (int i = 0; i < coins.length; i++) {
            int ccoin = coins[i];
            for (int j = ccoin; j < dp.length; j++) {
                dp[j] = Math.min(dp[j], (dp[j - ccoin] + 1));
            }
        }
        return dp[dp.length - 1] == 1000000 ? -1 : dp[dp.length - 1];
    }
}