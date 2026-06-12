class Solution {
    public boolean canJump(int[] nums) {
        boolean dp[] = new boolean[nums.length];
        Arrays.fill(dp,false);
        dp[dp.length-1] = true;
        for(int i = nums.length-2;i>=0;i--)
        {
            int jval = nums[i];
            for(int j = i ;j<=i+jval && j<dp.length;j++)
            {
                dp[i] |= dp[j];
            }
        }
        return dp[0];
    }
}
