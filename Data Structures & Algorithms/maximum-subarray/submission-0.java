class Solution {
    public int maxSubArray(int[] nums) {
        int cval =0;
        int max = Integer.MIN_VALUE;
        for(int i = 0;i<nums.length;i++)
        {
            if(cval<0)
            {
                cval = nums[i];
            }
            else
            {
                cval+=nums[i];
            }
            max = Math.max(max,cval);
        }
        return max;
    }
}
