class Solution {
    public List<List<Integer>> TwoSum(int[] nums,int si,int ntar)
    {
        List<List<Integer>> ans = new ArrayList<>();
        int i = si;
        int j  = nums.length-1;
        while(i<j)
        {
            if(i!=si&&nums[i]==nums[i-1])
            {i++;continue;}
            int val = nums[i]+nums[j];
            if(val==ntar)
            {
                List<Integer> ll = new ArrayList<>();
                ll.add(nums[i]);
                ll.add(nums[j]);
                i++;
                j--;
                ans.add(ll);
            }
            else if(val>ntar)
            {
                j--;
            }
            else
            {
                i++;
            }
            
        }
        return ans;
    }
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0;i<n-2;i++)
        {
            if(i!=0&&nums[i]==nums[i-1])
                continue;
            int val1 = nums[i];
            int ntar = -nums[i];
            List<List<Integer>> temp = TwoSum(nums,i+1,ntar);
            for(List<Integer> l:temp)
            {
                l.add(val1);
                ans.add(l);
            }
            
        }
        return ans;
    }
}