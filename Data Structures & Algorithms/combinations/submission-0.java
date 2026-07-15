class Solution {
    //level -> k , options all the not used numbers from 1 to n
    public void backtrack(int n,int currK,int k,int cidx,HashSet<Integer> set,List<Integer> lsf)
    {
        if(k==currK)
        {
            ans.add(new ArrayList<>(lsf));
            return;
        }
        for(int i = cidx;i<=n;i++)
        {
            if(!set.contains(i))
            {
                set.add(i);
                lsf.add(i);
                backtrack(n,currK+1,k,i+1,set,lsf);
                set.remove(i);
                lsf.remove(lsf.size()-1);
            }
        }
    }
    List<List<Integer>> ans;
    public List<List<Integer>> combine(int n, int k) {
        ans = new ArrayList<>();
        backtrack(n,0,k,1,new HashSet<>(),new ArrayList<>());
        return ans;
    }
}