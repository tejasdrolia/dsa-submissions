class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder("");
        for(String s:strs)
        {
            sb.append((s.length()+"#"+s));
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> ans = new ArrayList<>();
        int i = 0;
        int j = 0;
        while(j<str.length())
        {
            if(str.charAt(j)=='#')
            {
                int len = Integer.parseInt(str.substring(i,j));
                String ss = str.substring(j+1,j+len+1);
                ans.add(ss);
                i = j+len+1;
                j = i+1;
            }
            else{
            j++;}
        }
        return ans;
    }
}
