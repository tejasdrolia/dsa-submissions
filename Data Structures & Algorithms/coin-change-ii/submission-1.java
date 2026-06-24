class Solution {

    Integer[][] dp;

    private int dfs(int[] coins, int idx, int amount) {
        if (amount == 0) return 1;
        if (idx == coins.length || amount < 0) return 0;

        if (dp[idx][amount] != null)
            return dp[idx][amount];

        // Take current coin
        int take = dfs(coins, idx, amount - coins[idx]);

        // Skip current coin
        int skip = dfs(coins, idx + 1, amount);

        return dp[idx][amount] = take + skip;
    }

    public int change(int amount, int[] coins) {
        dp = new Integer[coins.length][amount + 1];
        return dfs(coins, 0, amount);
    }
}