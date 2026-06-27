class Solution {
    List<List<Integer>> ans;
    public void dfs(int nums[],List<Integer> ll)
    {
        if(ll.size()==nums.length)
        {
            ans.add(new ArrayList<>(ll));
            return;
        }
        for(int i = 0;i<nums.length;i++)
        {
            if(nums[i]!=-11)
            {
                ll.add(nums[i]);
                nums[i] = -11;
                dfs(nums,ll);
                nums[i] = ll.get(ll.size()-1);
                ll.remove(ll.size()-1);
            }
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        ans = new ArrayList<>();
        dfs(nums,new ArrayList<>());
        return ans;
    }
}
