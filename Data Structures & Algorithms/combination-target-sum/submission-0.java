class Solution {

    List<List<Integer>> ans;
    public void dfs(int nums[], int tar, int ssf, int idx, List<Integer> lsf)
    {
        if(idx>=nums.length)
        return;
        if(ssf>tar)
        return;
        if(ssf==tar)
        {
            ans.add(new ArrayList<>(lsf));
            return;
        }

        for(int i = idx;i<nums.length;i++)
        {
            lsf.add(nums[i]);
            dfs(nums,tar,ssf+nums[i],i,lsf);
            lsf.remove(lsf.size()-1);
        }
    }
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        ans = new ArrayList<>();
        dfs(nums,target,0,0,new ArrayList<>());
        return ans;
    }
}
