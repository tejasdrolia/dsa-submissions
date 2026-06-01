class Solution {
    public int[] twoSum(int[] nums, int target) {
        int ans[] = new int[2];
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i<nums.length;i++)
        {
            int cnum = nums[i];
            if(map.containsKey(target-cnum))
            {
                ans[1] = i;
                ans[0] = map.get(target-cnum);
                return ans; 
            }
            map.put(cnum,i);
        }
        return ans;
    }
}
