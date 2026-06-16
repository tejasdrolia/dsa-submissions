class Solution {
    public int trap(int[] height) {
        int dpl[] = new int[height.length];
        int dpr[] = new int[height.length];
        dpl[0] = height[0];
        for(int i = 1;i<dpl.length;i++)
        {
            dpl[i] = Math.max(height[i],dpl[i-1]);
        }
        dpr[dpr.length-1] = height[height.length-1];
        for(int i = dpr.length-2;i>=0;i--)
        {
            dpr[i] = Math.max(dpr[i+1],height[i]);
        }
        int ans = 0;
        for(int i = 0;i<dpr.length;i++)
        {
            int val = Math.min(dpr[i],dpl[i]);
            ans+= (val-height[i]);
        }
        return ans;
    }
}
