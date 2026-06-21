class Solution {
    public int jump(int[] nums) {
        Integer dp[] = new Integer[nums.length];
        Arrays.fill(dp,null);
        dp[dp.length-1] = 1;
        for(int i = nums.length-2;i>=0;i--)
        {
            int jumps = nums[i];
            int min = Integer.MAX_VALUE;
            for(int j = i;j<=i+jumps && j<nums.length ;j++)
            {
                if(dp[j]!=null)
                min = Math.min(min,dp[j]);
            }
            if(min==Integer.MAX_VALUE)
            dp[i] = null;
            else
            dp[i] = min+1;
        }
        return dp[0]==null?-1:dp[0]-1;
    }
}
