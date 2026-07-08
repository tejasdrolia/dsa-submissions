class Solution {
    public int dfs(int idx,int nums[],int val)
    {
        if(idx==nums.length)
        return val;
        return dfs(idx+1,nums,val^nums[idx]) + dfs(idx+1,nums,val);
    }
    public int subsetXORSum(int[] nums) {
        return dfs(0,nums,0);
    }
}