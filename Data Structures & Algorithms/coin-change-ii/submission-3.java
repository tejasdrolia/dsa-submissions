class Solution {
    public int change(int amount, int[] coins) {
        int dp[] = new int[amount+1];
        dp[0] = 1;
        //since it's combination therefor coins is present in outer array to prevent any duplication
        for(int i = 0;i<coins.length;i++)
        {
            int ccoin = coins[i];
            for(int j = ccoin;j<dp.length;j++)
            {
                dp[j]+=dp[j-ccoin];
            }
        }
        return dp[dp.length-1];
    }
}