class Solution {
    int count = 0;
    public void dfs(int []nums,int idx,int tar,int ssf)
    {
        if(idx==nums.length && ssf == tar)
        {
            count++;
            return;
        }
        if(idx==nums.length)
        return;
        
        dfs(nums,idx+1,tar,ssf+nums[idx]);
        dfs(nums,idx+1,tar,ssf-nums[idx]);
    }
    public int findTargetSumWays(int[] nums, int target) {
        count = 0;
        dfs(nums,0,target,0);
        return count;
    }
}