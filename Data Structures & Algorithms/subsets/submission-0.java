class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public void dfs(int nums[],int idx,List<Integer> ll)
    {
        if(idx==nums.length)
        {
            ans.add(new ArrayList<>(ll));
            return;
        }
        int cval = nums[idx];
        ll.add(cval);
        dfs(nums,idx+1,ll);
        ll.remove(ll.size()-1);
        dfs(nums,idx+1,ll);
    }
    public List<List<Integer>> subsets(int[] nums) {
        dfs(nums,0,new ArrayList<>());
        return ans;
    }
}
