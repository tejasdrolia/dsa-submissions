class Solution {
    HashMap<String,String> map;
    List<String> ans;
    public void dfs(String digits,int idx,String ssf)
    {
        if(idx==digits.length())
        {
            ans.add(ssf);
            return;
        }
        String pattern = map.get(digits.charAt(idx)+"");
        for(int i = 0;i<pattern.length();i++)
        {
            char ch = pattern.charAt(i);
            ssf+=ch;
            dfs(digits,idx+1,ssf);
            ssf = ssf.substring(0,ssf.length()-1);
        }
    }
    public List<String> letterCombinations(String digits) {
        if(digits.length()==0)
        return new ArrayList<>();
        map = new HashMap<>();
        ans = new ArrayList<>();
        map.put("2","abc");
        map.put("3","def");
        map.put("4","ghi");
        map.put("5","jkl");
        map.put("6","mno");
        map.put("7","pqrs");
        map.put("8","tuv");
        map.put("9","wxyz");
        dfs(digits,0,"");
        return ans;
    }
}
