class Solution {
    public int climbStairs(int n) {
        int dp[] = new int[n+1];
        dp[dp.length-1] = 1;
        for(int i = dp.length-2;i>=0;i--)
        {
            dp[i] = dp[i+1] + (i+2<dp.length? dp[i+2]:0);
        }
        return dp[0];
    }
}
