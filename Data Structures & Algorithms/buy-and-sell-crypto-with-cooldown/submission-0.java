class Solution {
    public int maxProfit(int[] prices) {
        int obms = -prices[0];
        int osms = 0;
        int ocms = 0;

        for (int i = 1; i < prices.length; i++) {
            int nbms = 0;
            int nsms = 0;
            int ncms = 0;
            if (obms < ocms - prices[i]) {
                nbms = ocms - prices[i];
            } else
                nbms = obms;

            if (osms < obms + prices[i]) {
                nsms = obms + prices[i];
            } else
                nsms = osms;

            
            if(ocms<osms)
            ncms = osms;
            else
            ncms = ocms;


            obms = nbms;
            osms = nsms;
            ocms = ncms;
        }

        return osms;
    }
}
