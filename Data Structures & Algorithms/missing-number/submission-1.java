class Solution {
    public int missingNumber(int[] nums) {
        //xor b/w 2 same number is 0
        int xor = 0;
        for(int i = 1;i<=nums.length;i++)
        xor = xor^i;
        for(int i = 0;i<nums.length;i++)
        xor = xor^nums[i];

        return xor;
    }
}
