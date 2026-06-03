class Solution {
    public int maxProfit(int[] prices) {
        int minval = prices[0];
        int max = 0;
        for(int i = 1;i<prices.length;i++)
        {
            minval = Math.min(minval,prices[i]);
            max = Math.max(max,prices[i] - minval);
        }
        return max;
    }
}
