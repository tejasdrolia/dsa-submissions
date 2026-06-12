class Solution {
    public int rob(int[] nums) {
        // 2 cases
        //  take 1st in consideration and not last.
        //  take 2nd house in consideration and also last if needed
        if(nums.length==1)
        return nums[0];

        int dp1[][] = new int[2][nums.length];
        int max1 = 0;
        dp1[0][0] = nums[0];
        dp1[1][0] = 0;
        for (int i = 1; i < dp1[0].length - 1; i++) {
            dp1[0][i] = dp1[1][i - 1] + nums[i];
            dp1[1][i] = Math.max(dp1[0][i - 1], dp1[1][i - 1]);
        }
        max1 = Math.max(dp1[0][dp1[0].length-2],dp1[1][dp1[0].length-2]);

        int max2 = 0;

        int dp2[][] = new int[2][nums.length];
        dp2[0][0] = 0;
        dp2[1][0] = 0;
        dp2[0][1] = nums[1];
        dp2[1][1] = 0;
        for (int i = 2; i < dp2[0].length; i++) {
            dp2[0][i] = dp2[1][i - 1] + nums[i];
            dp2[1][i] = Math.max(dp2[0][i - 1], dp2[1][i - 1]);
        }

        max2 = Math.max(dp2[0][dp2[0].length-1],dp2[1][dp2[0].length-2]);

        return Math.max(max1,max2);
        
    }
}
