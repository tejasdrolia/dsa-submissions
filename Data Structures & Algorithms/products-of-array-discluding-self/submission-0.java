class Solution {
    public int[] productExceptSelf(int[] nums) {
        int left[] = new int[nums.length];
        left[0] = nums[0];
        for(int i = 1;i<nums.length;i++)
        {
            left[i] = nums[i]*left[i-1];
        }
        int right[] = new int[nums.length];
        right[right.length-1] = nums[nums.length-1];
        for(int i = nums.length-2;i>=0;i--)
        {
            right[i] = nums[i]*right[i+1];
        }

        int ans[] = new int[nums.length];
        ans[0] = right[1];
        ans[ans.length-1] = left[left.length-2];
        for(int i = 1;i<nums.length-1;i++)
        {
            ans[i] = left[i-1]*right[i+1];
        }
        return ans;
    }
}  
