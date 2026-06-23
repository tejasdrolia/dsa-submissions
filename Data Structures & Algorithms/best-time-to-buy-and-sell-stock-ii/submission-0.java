class Solution {
    public int maxProfit(int[] prices) {
        // book profit at every uphill

        int i = 0;
        int j = 0;
        int psf = 0;
        while(j<prices.length)
        {
            while(j+1<prices.length && prices[j+1]>=prices[j])
            {
                j++;
            }
            psf+=prices[j] - prices[i];
            j++;
            i = j;
            //System.out.println("i + j "+i+" "+j);
        }
        return psf;
    }
}