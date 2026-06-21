class Solution {
    public int jump(int[] nums) {
        int dp[] = new int[nums.length];
        Arrays.fill(dp,10000000); //Taking any random high number
        dp[dp.length-1] = 0;
        for(int i = dp.length-2;i>=0;i--)
        {
            int jumps = nums[i];
            int min = Integer.MAX_VALUE;
            for(int j = i+1;j<=i+jumps && j<dp.length ;j++)
            {
                min = Math.min(min,dp[j]);
                dp[i] = min+1;
            }
        }
        return dp[0];
    }
}