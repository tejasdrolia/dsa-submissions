class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i:nums)
        sum+=i;
        if(sum%2!=0)
        return false;
        int target = sum/2;

        boolean dp[][] = new boolean[nums.length+1][target+1];
       for(int i = 0;i<dp.length;i++)
        {
            for(int j = 0;j<dp[0].length;j++)
            {
                if(i==0&&j==0)
                    dp[i][j] = true;
                else if(i==0)
                    dp[i][j] = false;
                else if(j==0)
                    dp[i][j] = true;
                else
                {
                    int runs = nums[i-1];
                    if(j>=runs)
                    {
                        dp[i][j] = dp[i-1][j] || dp[i-1][j-runs];
                    }
                    else
                    {
                        dp[i][j] = dp[i-1][j];
                    }
                }
            }
        }
        return dp[dp.length-1][dp[0].length-1];
    }
}
