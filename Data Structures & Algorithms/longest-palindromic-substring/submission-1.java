class Solution {
    public String longestPalindrome(String s) {
        // 2d array
        boolean dp[][] = new boolean[s.length()][s.length()];
        String ans ="";
        int fx = 0;
        int fy = 0;
        for(int g = 0;g<s.length();g++)
        {
            for(int i = 0,j = g;j<s.length();i++,j++)
            {
                if(g==0)
                {
                    dp[i][j] = true;
                    //ans = s.substring(i,j+1);
                    fx = i;fy=j;
                }
                else if(g==1)
                {
                    if(s.charAt(i) == s.charAt(j))
                    {
                        dp[i][j] = true;
                        //ans = s.substring(i,j+1);
                        fx = i;fy=j;
                    }
                    else
                    dp[i][j] = false;
                }
                else
                {
                    if(s.charAt(i) == s.charAt(j) && dp[i+1][j-1])
                    {
                        dp[i][j] = true;
                        //ans = s.substring(i,j+1);
                        fx = i;fy=j;
                    }
                    else
                    dp[i][j] = false;
                }
            }
        }
        return s.substring(fx,fy+1);
    }
}
