class Solution {
    public int findDuplicate(int[] nums) {
        for(int i = 0;i<nums.length;i++)
        {
            int num = Math.abs(nums[i]);
            if(nums[num-1]<0)
            return Math.abs(num);
            nums[num-1] = -nums[num-1];
        }
        return -1;
    }
}
