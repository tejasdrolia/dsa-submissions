class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>();
        for(int i = 0;i<wordDict.size();i++)
            set.add(wordDict.get(i));
        int dp[] = new int[s.length()];
        for(int i = 0;i<dp.length;i++)
        {
            for(int j = 0;j<=i;j++)
            {
                String help = s.substring(j,i+1);
                if(set.contains(help))
                    dp[i] += j-1>=0?dp[j-1]:1;
                
            }
        }
        // for(int i:dp)
        //     System.out.print(i+" ");
        if(dp[dp.length-1]!=0)
            return true;
        else return false;
    }
}