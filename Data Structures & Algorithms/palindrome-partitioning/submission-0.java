class Solution {
    //levels and options
    public void dfs(String s,List<String> l,List<List<String>> ans)
    {
        if(s.length()==0)
        {
            ans.add(new ArrayList<>(l));
            return;
        }
        for(int i = 0;i<s.length();i++)
        {
            String prefix = s.substring(0,i+1);
            if(isPalindrome(prefix))
            {
                String ros = s.substring(i+1);
                l.add(prefix);
                dfs(ros,l,ans);
                l.remove(l.size() - 1);
            }
        }
    }
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        dfs(s,new ArrayList<>(),ans);
        return ans;
    }
    public boolean isPalindrome(String s)
    {
        int i = 0;
        int j = s.length()-1;
        while(i<=j)
        {
            char chi = s.charAt(i);
            char chj = s.charAt(j);
            if(chi!=chj)
            return false;
            else
            {
                i++;
                j--;
            }
        }
        return true;
    }
}
