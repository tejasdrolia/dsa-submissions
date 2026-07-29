class Solution {
    public void replace(int[] nums, int x, int y) {
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }

    public void sortColors(int[] nums) {
        int i = 0;
        int j = 0;
        int k = nums.length - 1;
        while (j <= k) {
            int cnum = nums[j];
            if (cnum == 1)
                j++;
            else if (cnum == 0) {
                replace(nums, i, j);
                i++;
                j++;
            } else {
                replace(nums, j, k);
                k--;
            }
        }
    }
}