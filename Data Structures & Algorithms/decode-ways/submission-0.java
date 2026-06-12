class Solution {
    public int numDecodings(String s) {
        int dp[] = new int[s.length()];
        dp[0] = s.charAt(0)=='0'?0:1;
        for(int i = 1;i<dp.length;i++)
        {
            char ch1 = s.charAt(i);
            char ch2 = s.charAt(i-1);
            String ss = s.substring(i-1,i+1);
            if(ch1!='0' && ch2!='0')
            {
                dp[i] = dp[i-1];
                if(Integer.parseInt(ss)<=26)
                dp[i]+=i-2>=0?dp[i-2]:1;
            }
            else if(ch1!='0' && ch2=='0')
            {
                dp[i] = dp[i-1];
            }
            else if(ch1=='0' && ch2!='0')
            {
                if(Integer.parseInt(ss)<=26)
                dp[i]+=i-2>=0?dp[i-2]:1;
            }
            else
            {
                dp[i] = 0;
            }
        }
        return dp[dp.length-1];
    }
}