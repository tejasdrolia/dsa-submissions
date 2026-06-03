class Solution {
    public int maxProfit(int[] prices) {
        int maxArr[] = new int[prices.length];
        maxArr[prices.length-1] = prices[prices.length-1];
        for(int i = prices.length-2;i>=0;i--)
        {
            maxArr[i] = Math.max(prices[i],maxArr[i+1]);
        }
        int ans = 0;
        for(int i = 0;i<prices.length;i++)
        {
            ans = Math.max(ans,maxArr[i]-prices[i]);
        }
        return ans;
    }
}
